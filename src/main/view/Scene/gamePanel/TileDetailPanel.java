package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import model.MapSubsystem.Location;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDetailDrawingVisitor;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
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
    private HashMap<Location, Tile> gameMap;
    private AssetManager assets;
    private Camera camera;
    private Game game;
    private Group root;

    public TileDetailPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
        this.game = game;
        this.assets = assets;
        this.root = root;
        this.camera = camera;
        this.panelManager = panelManager;
        updateGameMap();
    }

    private void updateGameMap(){
        gameMap = game.getMap();
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
            gameMap.get(loc).accept(tileDrawingVisitor);
        } catch (NullPointerException e){
            gc.drawImage(assets.getImage("EMPTY_HEX_GRID"), drawPoint.x*camera.getBackgroundScaleX(),
                    drawPoint.y*camera.getBackgroundScaleY());
        }
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
