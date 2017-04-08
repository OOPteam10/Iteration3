package view.Scene.gamePanel;

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

    public WonderPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
    }

    private void drawWonderBoard(GraphicsContext gc, Point screenDimension){
        gc.drawImage(wonderBoard, screenDimension.x/1.397, screenDimension.y - 748);
    }

    public void draw(GraphicsContext gc, Point screenDimension) {
        drawWonderBoard(gc, screenDimension);
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
