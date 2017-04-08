package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by Karth on 4/5/2017.
 */
public class TileDetailPanel extends Panel {
    public TileDetailPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
    }

    public void draw(GraphicsContext gc, Point screenDimension){

    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
