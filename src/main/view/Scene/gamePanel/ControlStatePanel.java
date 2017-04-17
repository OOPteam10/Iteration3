package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

public class ControlStatePanel extends Panel {

    private Point drawPoint = new Point(1195,184);
    private Point indicatorDrawPoint = new Point(1300,184);
    private int controlState;
    private Game game;
    private Camera camera;

    Image movePhase = getAssets().getImage("MOVE_PHASE");
    Image buildPhase = getAssets().getImage("BUILD_PHASE");
    Image productionPhase = getAssets().getImage("PRODUCTION_PHASE");
    Image wonderPhase = getAssets().getImage("WONDER_PHASE");
    Image indicator = getAssets().getImage("PHASE_INDICATOR");

    public ControlStatePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera,
                             PanelManager panelManager){
        super(game, assets, gameMode);
        this.camera  = camera;
        this.game = game;
        updateControlState();
        updateIndicatorLocation();
    }


    private void updateIndicatorLocation(){
        updateControlState();
        indicatorDrawPoint.x = 1210 + Math.max(1,controlState)*85;
    }

    private void updateControlState(){
        this.controlState = game.getControlState();
    }

    private void drawControlIndicator(GraphicsContext gc){
        gc.drawImage(indicator, indicatorDrawPoint.x*camera.getBackgroundScaleX(),
                indicatorDrawPoint.y*camera.getBackgroundScaleY(), indicator.getWidth()*camera.getBackgroundScaleX(),
                indicator.getHeight()*camera.getBackgroundScaleY());
    }

    private void drawPhaseStates(GraphicsContext gc){
        gc.drawImage(movePhase, (drawPoint.x+100) * camera.getBackgroundScaleX(), drawPoint.y * camera.getBackgroundScaleY(),
                movePhase.getWidth()*camera.getBackgroundScaleX(), movePhase.getHeight()*camera.getBackgroundScaleY());
        gc.drawImage(buildPhase, (drawPoint.x) * camera.getBackgroundScaleX(), drawPoint.y * camera.getBackgroundScaleY(),
                buildPhase.getWidth()*camera.getBackgroundScaleX(), buildPhase.getHeight()*camera.getBackgroundScaleY());
        gc.drawImage(productionPhase, (drawPoint.x+180) * camera.getBackgroundScaleX(), drawPoint.y * camera.getBackgroundScaleY(),
                productionPhase.getWidth()*camera.getBackgroundScaleX(), productionPhase.getHeight()*camera.getBackgroundScaleY());
        gc.drawImage(wonderPhase, (drawPoint.x+265) * camera.getBackgroundScaleX(), drawPoint.y * camera.getBackgroundScaleY(),
                wonderPhase.getWidth()*camera.getBackgroundScaleX(), wonderPhase.getHeight()*camera.getBackgroundScaleY());
    }

    @Override
    public void draw(GraphicsContext gc, Point screenDimension) {
        updateIndicatorLocation();
        drawPhaseStates(gc);
        drawControlIndicator(gc);
    }

    @Override
    public void hideGUIElements() {

    }

    @Override
    public void showGUIElements() {

    }
}
