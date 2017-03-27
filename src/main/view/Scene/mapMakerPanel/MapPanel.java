package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Game;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Terrains.Rock;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;
import java.util.HashMap;

public class MapPanel extends Panel{

    HashMap<Location, Tile> gameMap;
    AssetManager assets;

    public MapPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root){
        super(game, assets,gameMode);
        this.assets = assets;

        gameMap = new HashMap<Location, Tile>();
        gameMap = generateMap();
    }

    //TODO: This is a hard coded thing, remove it later
    private HashMap<Location, Tile> generateMap(){
        LandTile mountainTile = new LandTile(Mountains.getInstance());
        LandTile rockTile = new LandTile(Rock.getInstance());
        LandTile seaTile = new LandTile(Sea.getInstance());
        Location l1 = new Location(0, 0, 0);
        Location l2 = new Location(0, 1, -1);
        Location l3 = new Location(1, -1, 0);
        Location l4 = new Location(-1, 0, 1);
        Location l5 = new Location(0, -1, 1);

        Map map = new Map();
        map.addTile(mountainTile, l1);

        return map.getMap();
    }


    public void draw(GraphicsContext gc, Point screenDimension){
        for(Object o:gameMap.keySet()){
            Location l = (Location)o;
            drawTile(gc, new Point(l.getX()*115, l.getZ()*100),2);
        }
    }

    public void drawTile(GraphicsContext gc, Point p, int type){
        Image image;
        switch(type){
            case 0:
                image = assets.getImage("GRASS_TILE");
                gc.drawImage(image, p.x, p.y);
                break;
            case 1:
                image = assets.getImage("SEA_TILE");
                gc.drawImage(image, p.x, p.y);
                break;
            case 2:
                image = assets.getImage("MOUNTAIN_TILE");
                gc.drawImage(image, p.x, p.y);
                break;
            case 3:
                image = assets.getImage("ROCK_TILE");
                gc.drawImage(image, p.x, p.y);
                break;
            default:
                break;
        }
    }

    public void showGUIElements(){}
    public void hideGUIElements(){}
}
