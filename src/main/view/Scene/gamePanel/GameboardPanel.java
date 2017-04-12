package view.Scene.gamePanel;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import model.Managers.LandTransporterManager;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
import model.Transporters.*;
import model.Transporters.Visitor.LandTransporterDrawingVisitor;
import utilities.TileEditor;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Karth on 4/5/2017.
 */
public class GameboardPanel extends Panel {

    private PanelManager panelManager;
    private Map gameMap;
    private HashMap<Location, Tile> gameBoard;
    private AssetManager assets;
    private Camera camera;
    private Game game;
    private Group root;
    private LandTransporterManager landTransporterManager;

    public GameboardPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
        this.game = game;
        this.assets = assets;
        this.root = root;
        this.camera = camera;
        this.panelManager = panelManager;
        landTransporterManager = game.getLandTransporterManager();
        updateGameMap();
        addTransporters();
    }

    //TODO: this is a test function, delete it after
    private void addTransporters(){
//        Donkey dq = new Donkey();
//        Location l = new Location(0,0,0);
//        game.getActualMap().formatSurfaceMaps();
//        LandTile lt1 = game.getActualMap().getLandMap().getTile(l);
//        System.out.println(lt1);
//        landTransporterManager.add(dq, lt1.getSectorAtCardinalDirection(CardinalDirection.NE));

        Donkey dq = new Donkey();
        Wagon dq2 = new Wagon();
        Donkey dq3 = new Donkey();
        Donkey dq4 = new Donkey();
        Wagon dq5 = new Wagon();
        Truck dq6 = new Truck();
        Wagon dq7 = new Wagon();
        Truck dq8 = new Truck();
        landTransporterManager.add(dq, gameMap.getTile(new Location(0,0,0)).getSectorAtCardinalDirection(CardinalDirection.NE));
        landTransporterManager.add(dq2, gameMap.getTile(new Location(0,0,0)).getSectorAtCardinalDirection(CardinalDirection.SSE));
        landTransporterManager.add(dq3, gameMap.getTile(new Location(-1,0,1)).getSectorAtCardinalDirection(CardinalDirection.NNE));
        landTransporterManager.add(dq4, gameMap.getTile(new Location(-1,1,0)).getSectorAtCardinalDirection(CardinalDirection.SSE));
        landTransporterManager.add(dq5, gameMap.getTile(new Location(-1,3,-2)).getSectorAtCardinalDirection(CardinalDirection.SSE));
        landTransporterManager.add(dq6, gameMap.getTile(new Location(1,1,-2)).getSectorAtCardinalDirection(CardinalDirection.NW));
        landTransporterManager.add(dq7, gameMap.getTile(new Location(2,1,-3)).getSectorAtCardinalDirection(CardinalDirection.SSW));
        landTransporterManager.add(dq8, gameMap.getTile(new Location(2,1,-3)).getSectorAtCardinalDirection(CardinalDirection.ENE));

    }

    private void updateGameMap(){
        gameMap = game.getActualMap();
        gameBoard = gameMap.getMap();
    }

    private void drawBackground(GraphicsContext gc){
        for (int i=-10;i<11;i++){
            for(int j=-10;j<11;j++){
                Point p = new Point(i,j);
                if((i+j)>= - 10 && (i+j)<=10) {
                    gc.drawImage(assets.getImage("EMPTY_HEX_GRID"), camera.offset(p).x, camera.offset(p).y, camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getWidth(),
                            camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getHeight());
                }
            }
        }
    }

    private void drawTileSelector(GraphicsContext gc){
        Point p = new Point();
        p.x = TileEditor.getInstance().getLocation().getX();
        p.y = TileEditor.getInstance().getLocation().getY();
        gc.drawImage(assets.getImage("TILE_SELECTOR"), camera.offset( p).x, camera.offset( p).y,camera.getScale() * assets.getImage("TILE_SELECTOR").getWidth(),
                camera.getScale() * assets.getImage("TILE_SELECTOR").getHeight());
    }

    private void drawGameboard(GraphicsContext gc){
        for(Location loc:gameBoard.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            TileDrawingVisitor tileDrawingVisitor = new TileDrawingVisitor(assets, gc,p,camera);

            /**
             * Draw (Land)Transporters
             */
            gameBoard.get(loc).accept(tileDrawingVisitor);
        }
    }

    private void drawTransporters(GraphicsContext gc){
        for(Location loc:gameBoard.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            for(Sector sector:gameBoard.get(loc).getSectors()){
                for(LandTransporter transporter:sector.getTransporters(landTransporterManager)){
                    LandTransporterDrawingVisitor v = new LandTransporterDrawingVisitor(assets, gc, p, camera);
                    transporter.accept(v);
                }
            }
        }
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        drawBackground(gc);
        drawGameboard(gc);
        drawTileSelector(gc);
        drawTransporters(gc);
        updateGameMap();
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
