package view.Scene.gamePanel;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;
import javafx.scene.image.Image;

import java.awt.*;

/**
 * Created by Karth on 4/5/2017.
 */
public class WonderPanel extends Panel {
    private Image wonderBoard = getAssets().getImage("WONDER_BOARD");
    private Image wonderBackground = getAssets().getImage("WONDER_BACKGROUND");
    private Camera camera;
    private boolean isVisible = false;
    public WonderPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);

        this.camera = camera;
    }

    private void drawWonderBoard(GraphicsContext gc, Point screenDimension){
        gc.drawImage(wonderBoard, (screenDimension.x-430)/2 - wonderBoard.getWidth()/2,
                screenDimension.y/2 - wonderBoard.getHeight()/2);
    }

    private void drawWonderBackground(GraphicsContext gc, Point screenDimension){
        gc.drawImage(wonderBackground,0,0,
                wonderBackground.getWidth()*camera.getBackgroundScaleX(),
                wonderBackground.getHeight()*camera.getBackgroundScaleY());
    }

    public void draw(GraphicsContext gc, Point screenDimension) {
        if(isVisible) {
            drawWonderBackground(gc, screenDimension);
            drawWonderBoard(gc, screenDimension);
        }
    }

    public void toggle(){
        isVisible = !isVisible;
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
