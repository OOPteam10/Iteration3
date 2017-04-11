package view.Scene.gamePanel;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import model.Managers.LandTransporterManager;
import model.MapSubsystem.Location;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.Visitor.TransporterDrawingVisitor;
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
    private HashMap<Location, Tile> gameMap;
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
        addDonkey();
    }

    //TODO: this is a test function, delete it after
    private void addDonkey(){
        Donkey dq = new Donkey();
        Location l = new Location(0,0,0);
        game.getActualMap().formatSurfaceMaps();
        LandTile lt1 = game.getActualMap().getLandMap().getTile(l);
        System.out.println(lt1);
        landTransporterManager.add(dq, lt1.getSectorAtCardinalDirection(CardinalDirection.NE));
    }

    private void updateGameMap(){
        gameMap = game.getMap();
    }

    private void drawBackground(GraphicsContext gc){
        for (int i=0;i<21;i++){
            for(int j=0;j<21;j++){
                Point p = new Point(i-10,j-10);
                gc.drawImage(assets.getImage("EMPTY_HEX_GRID"), camera.offset(p).x,camera.offset( p).y,camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getWidth(),
                        camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getHeight());
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
        for(Location loc:gameMap.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            TileDrawingVisitor tileDrawingVisitor = new TileDrawingVisitor(assets, gc,p,camera);
            gameMap.get(loc).accept(tileDrawingVisitor);
        }
    }

    private void drawTransporters(GraphicsContext gc){
        for(LandTransporter landTransporter: landTransporterManager.getManagerMap().keySet()){
            Sector findTransporter = landTransporterManager.getLocation(landTransporter);
            TransporterDrawingVisitor v = new TransporterDrawingVisitor(assets, gc,
                    new Location(0,0,0), camera, findTransporter);
        }
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        drawBackground(gc);
        drawGameboard(gc);
        drawTransporters(gc);
        drawTileSelector(gc);
        updateGameMap();
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
