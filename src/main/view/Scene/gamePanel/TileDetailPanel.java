package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Game;
import model.Managers.LandTransporterManager;
import model.Managers.ResourceManager;
import model.Managers.SeaTransporterManager;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDetailDrawingVisitor;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;
import model.Transporters.Visitor.LandTransporterDetailDrawingVisitor;
import model.Transporters.Visitor.SeaTransporterDetailDrawingVisitor;
import model.resources.Resource;
import model.resources.Visitor.ResourceDetailDrawingVisitor;
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
public class TileDetailPanel extends Panel {
    private Point drawPoint = new Point(1183, 514);
    private PanelManager panelManager;
    private HashMap<Location, Tile> gameBoard;
    private Map gameMap;
    private LandMap landMap;
    private AssetManager assets;
    private Camera camera;
    private Game game;
    private Group root;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private ResourceManager resourceManager;
    private WaterwayMap waterwayMap;

    public TileDetailPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
        this.game = game;
        this.assets = assets;
        this.root = root;
        this.camera = camera;
        this.gameMap = game.getActualMap();
        this.panelManager = panelManager;
        this.landTransporterManager = game.getLandTransporterManager();
        this.seaTransporterManager = game.getSeaTransporterManager();
        this.waterwayMap = gameMap.getWaterwayMap();
        updateGameMap();
    }

    private void updateGameMap(){
        gameBoard = game.getMap();
        gameMap = game.getActualMap();
        landMap = gameMap.getLandMap();
        landTransporterManager = game.getLandTransporterManager();
        resourceManager = game.getResourceManager();
        drawPoint.x = (int)(1183*camera.getBackgroundScaleX());
        drawPoint.y = (int)(514*camera.getBackgroundScaleY());
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        updateGameMap();
        drawTileDetail(gc);
    }

    private void drawTileDetail(GraphicsContext gc){
        //tileDetailVisitor = new tileDetailVisitor(assets,gc,Point location);
        //gameMap.get(loc of tileEditor).accept(visitor);
        try {
            Location loc = TileEditor.getInstance().getLocation();
            TileDetailDrawingVisitor tileDrawingVisitor = new TileDetailDrawingVisitor(assets, gc, drawPoint, camera);
            gameBoard.get(loc).accept(tileDrawingVisitor);
            drawLandTransporterDetail(gc);
            drawSeaTransporterDetail(gc);
            drawResourceDetail(gc);
        } catch (NullPointerException e){
            Image img = assets.getImage("EMPTY_HEX_GRID");
            gc.drawImage(img, drawPoint.x,
                    drawPoint.y,camera.getBackgroundScaleY() * img.getWidth(),
                    camera.getBackgroundScaleY() * img.getHeight());
        }
    }

    private void drawLandTransporterDetail(GraphicsContext gc){
        Location loc = TileEditor.getInstance().getLocation();
        for(Sector sector: gameBoard.get(loc).getSectors()) {
            LandTransporterDetailDrawingVisitor v = new LandTransporterDetailDrawingVisitor(assets, gc, camera, sector);
            for(LandTransporter landTransporter:sector.getTransporters(landTransporterManager))
            {
                landTransporter.accept(v);
            }
        }
    }

    private void drawSeaTransporterDetail(GraphicsContext gc){
        Location loc = TileEditor.getInstance().getLocation();
        for(SeaTransporter transporter:waterwayMap.getTile(loc).getSeaTransporters(seaTransporterManager)){
            SeaTransporterDetailDrawingVisitor v = new SeaTransporterDetailDrawingVisitor(assets, gc, camera);
            transporter.accept(v);
        }
    }

    private void drawResourceDetail(GraphicsContext gc){
        Location loc = TileEditor.getInstance().getLocation();
        for(Sector sector:landMap.getTile(loc).getSectors()){
            for(Resource resource:resourceManager.get(sector)){
                ResourceDetailDrawingVisitor v = new ResourceDetailDrawingVisitor(assets,gc,camera,sector);
                resource.accept(v);
            }
        }
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
