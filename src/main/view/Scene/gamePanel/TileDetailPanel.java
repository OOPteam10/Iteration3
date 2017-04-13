package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import model.Managers.LandTransporterManager;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDetailDrawingVisitor;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
import model.Transporters.LandTransporter;
import model.Transporters.Visitor.LandTransporterDetailDrawingVisitor;
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
    private AssetManager assets;
    private Camera camera;
    private Game game;
    private Group root;
    private LandTransporterManager landTransporterManager;

    public TileDetailPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
        this.game = game;
        this.assets = assets;
        this.root = root;
        this.camera = camera;
        this.panelManager = panelManager;
        this.landTransporterManager = game.getLandTransporterManager();
        updateGameMap();
    }

    private void updateGameMap(){
        gameBoard = game.getMap();
        gameMap = game.getActualMap();
        landTransporterManager = game.getLandTransporterManager();
        drawPoint.x = (int)(1183*camera.getBackgroundScaleX());
        drawPoint.y = (int)(514*camera.getBackgroundScaleY());

    }

    public void draw(GraphicsContext gc, Point screenDimension){
        updateGameMap();
        drawTileDetail(gc);
        drawTransporterDetail(gc);
    }

    private void drawTileDetail(GraphicsContext gc){
        //tileDetailVisitor = new tileDetailVisitor(assets,gc,Point location);
        //gameMap.get(loc of tileEditor).accept(visitor);
        try {
            Location loc = TileEditor.getInstance().getLocation();
            TileDetailDrawingVisitor tileDrawingVisitor = new TileDetailDrawingVisitor(assets, gc, drawPoint, camera);
            gameBoard.get(loc).accept(tileDrawingVisitor);
        } catch (NullPointerException e){
            gc.drawImage(assets.getImage("EMPTY_HEX_GRID"), drawPoint.x*camera.getBackgroundScaleX(),
                    drawPoint.y*camera.getBackgroundScaleY());
        }
    }

    private void drawTransporterDetail(GraphicsContext gc){
        try{
            Location loc = TileEditor.getInstance().getLocation();
            for(Sector sector: gameBoard.get(loc).getSectors()) {
                LandTransporterDetailDrawingVisitor v = new LandTransporterDetailDrawingVisitor(assets, gc, camera, sector);
                for(LandTransporter landTransporter:sector.getTransporters(landTransporterManager))
                {
                    landTransporter.accept(v);
                }
            }
        }catch (NullPointerException e){
            System.out.println("Something fucked up");
        }
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
