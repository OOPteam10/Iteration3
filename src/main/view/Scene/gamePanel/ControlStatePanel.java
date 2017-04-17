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

public class ControlStatePanel extends Panel {



    public ControlStatePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera,
                             PanelManager panelManager){
        super(game, assets, gameMode);
    }

    @Override
    public void draw(GraphicsContext gc, Point screenDimension) {

    }

    @Override
    public void hideGUIElements() {

    }

    @Override
    public void showGUIElements() {

    }
}
