package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import model.Game;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.Mountains;
import model.TileSubsystem.Terrains.Pasture;
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

import javax.xml.transform.Source;
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
        ForkedRiver riverF = new ForkedRiver(HexSide.SE , HexSide.N, HexSide.SW);

        SourceRiver riverS = new SourceRiver(HexSide.NW);
        RiverTile riverTile = new RiverTile(Mountains.getInstance(), river);
        RiverTile riverTile2 = new RiverTile(Rock.getInstance(), riverF);
        RiverTile riverTile3 = new RiverTile(Pasture.getInstance(), riverS);

        Location l1 = new Location(0, 0, 0);
        Location l2 = new Location(1, -1, 0);
        Location l3 = new Location(2, -1, -1);
        Location l4 = new Location(-1, 0, 1);
        Location l5 = new Location(0, -1, 1);

        Map map = new Map();
        //map.addTile(mountainTile, l1);
        map.addTile(riverTile, l1);
        map.addTile(riverTile2, l2);
        map.addTile(riverTile3, l3);

        return map.getMap();
    }


    public void draw(GraphicsContext gc, Point screenDimension){
        int i = 0;
        for(Location loc:gameMap.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            TileDrawingVisitor tileDrawingVisitor = new TileDrawingVisitor(assets, gc,p);
            gameMap.get(loc).accept(tileDrawingVisitor);
            i++;
        }

    }

    public void showGUIElements(){}
    public void hideGUIElements(){}
}
