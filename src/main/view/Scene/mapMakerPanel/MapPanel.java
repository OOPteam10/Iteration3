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
import model.TileSubsystem.Tiles.SeaTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
import model.TileSubsystem.Visitor.TileVisitor;
import utilities.TileEditor;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import javax.xml.transform.Source;
import java.awt.*;
import java.util.HashMap;

public class MapPanel extends Panel{

    private HashMap<Location, Tile> gameMap;
    private AssetManager assets;
    private Camera camera;
    private Game game;

    public MapPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera){
        super(game, assets,gameMode);
        this.assets = assets;
        this.game = game;
        //TODO: this is hard coded, remove it after
        gameMap = new HashMap<Location, Tile>();
        gameMap = game.getMap();
        this.camera = camera;

//        camera.setScale(1);
//        camera.setCameraOffset(1,1);
        //gameMap = generateMap();
    }

    //TODO: This is a hard coded thing, remove it later
//    private HashMap<Location, Tile> generateMap(){
//        LandTile mountainTile = new LandTile(Mountains.getInstance());
//        LandTile rockTile = new LandTile(Rock.getInstance());
//        LandTile seaTile = new LandTile(Sea.getInstance());
//
//        NormalRiver river = new NormalRiver(HexSide.N ,HexSide.NE);
//        ForkedRiver riverF = new ForkedRiver(HexSide.SE , HexSide.N, HexSide.SW);
//
//        SourceRiver riverS = new SourceRiver(HexSide.NW);
//
//        RiverTile riverTile = new RiverTile(Mountains.getInstance(), river);
//        RiverTile riverTile2 = new RiverTile(Rock.getInstance(), riverF);
//        RiverTile riverTile3 = new RiverTile(Pasture.getInstance(), riverS);
//
//        Location l1 = new Location(0, 0, 0);
//        Location l2 = new Location(1, -1, 0);
//        Location l3 = new Location(2, -1, -1);
//        Location l4 = new Location(-1, 0, 1);
//        Location l5 = new Location(0, -1, 1);
//
//        Map map = new Map();
//        //map.addTile(mountainTile, l1);
//        map.addTile(riverTile, l1);
//        map.addTile(riverTile2, l2);
//        map.addTile(riverTile3, l3);
//        map.addTile(seaTile,l4);
//        //map.addTile(mountainTile,l5);
//
//        return map.getMap();
//    }
    public void draw(GraphicsContext gc, Point screenDimension){
        int i = 0;
        drawBackground(gc);
        for(Location loc:gameMap.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            TileDrawingVisitor tileDrawingVisitor = new TileDrawingVisitor(assets, gc,p,camera);
            gameMap.get(loc).accept(tileDrawingVisitor);
            i++;
        }
        drawTileSelector(gc);
        updateMap();
    }

    public void drawBackground(GraphicsContext gc){
        for (int i=0;i<21;i++){
            for(int j=0;j<21;j++){
                Point p = new Point(i-10,j-10);
                gc.drawImage(assets.getImage("EMPTY_HEX_GRID"), camera.offset(gc, p).x,camera.offset(gc, p).y,camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getWidth(),
                        camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getHeight());
            }
        }
    }

    public void drawTileSelector(GraphicsContext gc){
        Point p = new Point();
        p.x = TileEditor.getInstance().getLocation().getX();
        p.y = TileEditor.getInstance().getLocation().getY();
        gc.drawImage(assets.getImage("TILE_SELECTOR"), camera.offset(gc, p).x, camera.offset(gc, p).y,camera.getScale() * assets.getImage("TILE_SELECTOR").getWidth(),
                camera.getScale() * assets.getImage("TILE_SELECTOR").getHeight());
    }

    private void updateMap(){
        gameMap = game.getMap();
    }


    public void updateMap(HashMap<Location, Tile> gameMap){
        this.gameMap = gameMap;
    }

    public void showGUIElements(){}
    public void hideGUIElements(){}
}
