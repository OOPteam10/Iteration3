package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Game;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Terrains.Rock;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
import model.TileSubsystem.Visitor.TileVisitor;
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


        //TODO: this is hard coded, remove it after
        gameMap = new HashMap<Location, Tile>();
        gameMap = generateMap();
    }

    //TODO: This is a hard coded thing, remove it later
    private HashMap<Location, Tile> generateMap(){
        LandTile mountainTile = new LandTile(Mountains.getInstance());
        LandTile rockTile = new LandTile(Rock.getInstance());
        LandTile seaTile = new LandTile(Sea.getInstance());
        NormalRiver river = new NormalRiver(HexSide.N ,HexSide.NE);
        ForkedRiver riverF = new ForkedRiver(HexSide.NE, HexSide.S, HexSide.NW);
        RiverTile riverTile = new RiverTile(Mountains.getInstance(), riverF);
        Location l1 = new Location(0, 0, 0);
        Location l2 = new Location(0, 1, -1);
        Location l3 = new Location(1, -1, 0);
        Location l4 = new Location(-1, 0, 1);
        Location l5 = new Location(0, -1, 1);

        Map map = new Map();
        map.addTile(mountainTile, l1);
        map.addTile(rockTile, l2);
        map.addTile(seaTile, l3);
        map.addTile(mountainTile, l4);
        map.addTile(riverTile, l5);

        return map.getMap();
    }


    public void draw(GraphicsContext gc, Point screenDimension){
        int i = 0;
        for(Location loc:gameMap.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            TileDrawingVisitor tileDrawingVisitor = new TileDrawingVisitor(assets, gc,offset(p));
            gameMap.get(loc).accept(tileDrawingVisitor);
            i++;
        }

    }

    //TODO: integrate the offsets to a Camera class
    //TODO: Change the size of the new/save/load icons, do somehting on the ui design
    //TODO: Background picture should be a hexagon grid

    public Point offset(Point p) {
        Point offsetTile = new Point();
        Point offset = new Point(1024/2-115,768/2-100);
        offsetTile.x = getPixelLocation(p).x + offset.x;
        offsetTile.y = getPixelLocation(p).y + offset.y;
        return offsetTile;
    }

    public Point getPixelLocation(Point tile) {
        Point pixelLocation = new Point();
        int HEX_W = 115;
        int HEX_H = 100;
        pixelLocation.x = (int)(0.75f * HEX_W * tile.x);
        pixelLocation.y = (int)(HEX_H * (tile.x * 0.5f + tile.y));
        return pixelLocation;
    }

    public void showGUIElements(){}
    public void hideGUIElements(){}
}
