package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Camera;
import view.Panel;
import view.ViewEnum;
import view.assets.AssetManager;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;

public class BottomPanel extends Panel {

    private Rectangle bottomPanelRect;
    private Group root;
    private Camera camera;
    private Image terrainPreviewImage;
    private Image riverPreviewImage;

    public BottomPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera){
        super(game, assets, gameMode);

        this.bottomPanelRect = new Rectangle();
        this.root = root;
        this.camera = camera;
        terrainPreviewImage = assets.getImage("MOUNTAIN_TILE");
        riverPreviewImage = assets.getImage("EMPTY_HEX_GRID");
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        initializePanel(gc, screenDimension);
        drawPreview(gc, screenDimension);
    }

    private void initializePanel(GraphicsContext gc, Point screenDimension){
        gc.drawImage(getAssets().getImage("BOTTOM_PANEL"), 0, screenDimension.y-125);
    }

    public void drawPreview(GraphicsContext gc, Point screenDimension){
        gc.drawImage(terrainPreviewImage, screenDimension.x/2-115, screenDimension.y-110);
        gc.drawImage(riverPreviewImage, screenDimension.x/2, screenDimension.y-110);
        drawRotatedPreview(gc, terrainPreviewImage, riverPreviewImage, 0, screenDimension.x/2+115,screenDimension.y-110);
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
        gc.drawImage(terrainPreview, tlpx, tlpy);
        gc.save(); // saves the current state on stack, including the current transform
        try {
            camera.rotate(gc, angle, tlpx + riverPreview.getWidth() / 2, tlpy + riverPreview.getHeight() / 2);
            gc.drawImage(riverPreview, tlpx, tlpy, camera.getScale() * riverPreview.getWidth(),
                    camera.getScale() * riverPreview.getHeight());
        }catch (NullPointerException e){
            System.out.println();
        }
        gc.restore(); // back to original state (before rotation)

    }
}
