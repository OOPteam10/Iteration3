package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

public class BottomPanel extends Panel {

    private Rectangle bottomPanelRect;
    private Group root;
    private Camera camera;
    private Image terrainPreviewImage;
    private Image riverPreviewImage;
    private PanelManager panelManager;
    private int rotationAngle;
    private double terrainScale;
    private double riverScale;
    private double finalPreviewScale;

    String currentMode;

    public BottomPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);

        this.bottomPanelRect = new Rectangle();
        this.root = root;
        this.camera = camera;
        this.panelManager = panelManager;
        terrainPreviewImage = assets.getImage("DESERT_TILE");
        riverPreviewImage = assets.getImage("NORMAL_RIVER_60");
        rotationAngle = 0;
        terrainScale = 0.31;
        riverScale = 0.31;
        finalPreviewScale = 0.31;
        currentMode = "TERRAIN_SELECTED";
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        initializePanel(gc, screenDimension);
        drawPreview(gc, screenDimension);
        drawIndicator(gc, screenDimension);
    }

    private void initializePanel(GraphicsContext gc, Point screenDimension){
        gc.drawImage(getAssets().getImage("BOTTOM_PANEL"), 0, screenDimension.y-125);
    }

    public void drawPreview(GraphicsContext gc, Point screenDimension){
        gc.drawImage(terrainPreviewImage, screenDimension.x/2-125, screenDimension.y-110, terrainScale*terrainPreviewImage.getWidth(),
                terrainPreviewImage.getHeight()*terrainScale);
        gc.drawImage(riverPreviewImage, screenDimension.x/2, screenDimension.y-110, riverScale* riverPreviewImage.getWidth(), riverScale * riverPreviewImage.getHeight());
        drawRotatedPreview(gc, terrainPreviewImage, riverPreviewImage, rotationAngle, screenDimension.x/2+125,screenDimension.y-110);
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }

    public void setTerrainPreviewImage(String terrainPreview){
        terrainPreviewImage = getAssets().getImage(terrainPreview);
    }

    public void setRiverPreviewImage(String riverPreview){
        riverPreviewImage = getAssets().getImage(riverPreview);
    }

    private void drawRotatedPreview(GraphicsContext gc,Image terrainPreview, Image riverPreview, double angle, double tlpx, double tlpy) {
        gc.drawImage(terrainPreview, tlpx, tlpy, finalPreviewScale*terrainPreview.getWidth(), finalPreviewScale*terrainPreview.getHeight());
        gc.save(); // saves the current state on stack, including the current transform
        try {
            camera.rotate(gc, angle, tlpx + finalPreviewScale*riverPreview.getWidth() / 2, tlpy + finalPreviewScale*riverPreview.getHeight() / 2);
            gc.drawImage(riverPreview, tlpx, tlpy, finalPreviewScale * riverPreview.getWidth(),
                    finalPreviewScale * riverPreview.getHeight());
        }catch (NullPointerException e){
            System.out.println("Error: Preview Not drawing right");
        }
        gc.restore(); // back to original state (before rotation)

    }

    public void setRotationAngle(int numRotation){
        rotationAngle = numRotation *60;
    }

    public void terrainModeSelected(){
        currentMode = "TERRAIN_SELECTED";
    }

    public void riverModeSelected(){
        currentMode = "RIVER_SELECTED";
    }

    public void finalPreviewModeSelected(){
        currentMode = "FINAL_SELECTED";
    }

    private void drawIndicator(GraphicsContext gc, Point screenDimension){
        gc.drawImage(getAssets().getImage(currentMode),screenDimension.x-300, screenDimension.y-110);
    }
}
