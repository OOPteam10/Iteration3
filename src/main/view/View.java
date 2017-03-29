package view;

import controller.MapMakerControlSubsystem.MMCObserver;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import utilities.TileEditor;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by cduica on 3/22/17.
 */
public class View implements MMCObserver{
    private AssetManager assets;
    private static final int SCREEN_WIDTH = 1024;
    private static final int SCREEN_HEIGHT = 768;

    private Canvas canvas;
    private GraphicsContext gc;
    private Group root;
    private PanelManager panelManager;
    private Point screenDimension = new Point();
    private Scene scene;
    private int pulse = 0;
    private Camera camera;

    public View(Game game, Scene scene, Group root){
        assets = new AssetManager();
        this.root = root;
        this.scene = scene;

        canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        screenDimension.x = SCREEN_WIDTH;
        screenDimension.y = SCREEN_HEIGHT;
        camera = new Camera(screenDimension);
        gc = canvas.getGraphicsContext2D();
        panelManager = new PanelManager(game, assets, root, gc, camera);

        initializeView();
    }

    private void initializeView(){
        root.getChildren().add(canvas);
    }

    public void renderGame(){
        double width = scene.getWidth();
        double height = scene.getHeight();
        canvas.setWidth(width);
        canvas.setHeight(height);
        screenDimension.x = (int)width;
        screenDimension.y = (int)height;

        gc.clearRect(0,0,width,height);
        panelManager.drawPanels(screenDimension);
    }

    //MMCObserver methods
    @Override
    public void updateTerrainToDesert() {

    }

    @Override
    public void updateTerrainToMountain() {

    }

    @Override
    public void updateTerrainToPasture() {

    }

    @Override
    public void updateTerrainToRock() {

    }

    @Override
    public void updateTerrainToSea() {

    }

    @Override
    public void updateTerrainToWoods() {

    }

    @Override
    public void updateRiverToFork() {

    }

    @Override
    public void updateRiverToNone() {

    }

    @Override
    public void updateRiverToShape1() {

    }

    @Override
    public void updateRiverToShape2() {

    }

    @Override
    public void updateRiverToShape3() {

    }

    @Override
    public void updateRiverToSource() {

    }

    @Override
    public void updateCursorN() {

    }

    @Override
    public void updateCursorNE() {

    }

    @Override
    public void updateCursorNW() {

    }

    @Override
    public void updateCursorS() {

    }

    @Override
    public void updateCursorSE() {

    }

    @Override
    public void updateCursorSW() {

    }

    @Override
    public void placeTile(){

    }

    @Override
    public void terrainSelected() {

    }

    @Override
    public void riverSelected() {

    }

    @Override
    public void rotateLeft() {

    }

    public void rotateRight(){


    }
}
