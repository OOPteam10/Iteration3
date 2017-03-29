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
    private int rotation;

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
        this.rotation = 0;
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
        panelManager.updateTerrainPreview("DESERT_TILE");
    }

    @Override
    public void updateTerrainToMountain() {
        panelManager.updateTerrainPreview("MOUNTAIN_TILE");
    }

    @Override
    public void updateTerrainToPasture() {
        panelManager.updateTerrainPreview("GRASS_TILE");
    }

    @Override
    public void updateTerrainToRock() {
        panelManager.updateTerrainPreview("ROCK_TILE");
    }

    @Override
    public void updateTerrainToSea() {
        panelManager.updateTerrainPreview("SEA_TILE");
    }

    @Override
    public void updateTerrainToWoods() {
        panelManager.updateTerrainPreview("WOOD_TILE");
    }

    @Override
    public void updateRiverToFork() {
        panelManager.updateRiverPreview("FORKED_RIVER");
    }

    @Override
    public void updateRiverToNone() {
        panelManager.updateRiverPreview("EMPTY_HEX_GRID");
    }

    @Override
    public void updateRiverToShape1() {
        panelManager.updateRiverPreview("NORMAL_RIVER_60");
    }

    @Override
    public void updateRiverToShape2() {
        panelManager.updateRiverPreview("NORMAL_RIVER_120");
    }

    @Override
    public void updateRiverToShape3() {
        panelManager.updateRiverPreview("NORMAL_RIVER_180");
    }

    @Override
    public void updateRiverToSource() {
        panelManager.updateRiverPreview("SOURCE_RIVER");
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
        panelManager.updateTerrainPreview("DESERT_TILE");
        panelManager.updateRiverPreview("NORMAL_RIVER_60");
        rotation = 0;
        panelManager.updateRotation(rotation%4);
        panelManager.selectTerrain();
    }

    @Override
    public void terrainSelected() {
        panelManager.selectRiver();
    }

    @Override
    public void riverSelected() {
        panelManager.selectFinal();
    }

    @Override
    public void rotateLeft() {
        rotation--;
        panelManager.updateRotation(rotation%4);
    }

    public void rotateRight(){
        rotation++;
        panelManager.updateRotation(rotation%4);

    }
}
