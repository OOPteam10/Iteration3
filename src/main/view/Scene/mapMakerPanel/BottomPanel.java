package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Panel;
import view.ViewEnum;
import view.assets.AssetManager;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.awt.*;

public class BottomPanel extends Panel {

    private Rectangle bottomPanelRect;
    private Group root;

    public BottomPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root){
        super(game, assets, gameMode);

        this.bottomPanelRect = new Rectangle();
        this.root = root;
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        initializePanel(gc, screenDimension);
    }

    private void initializePanel(GraphicsContext gc, Point screenDimension){
        gc.drawImage(getAssets().getImage("BOTTOM_PANEL"), 0, screenDimension.y-125);
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
