package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import model.Game;
import view.assets.AssetManager;

import java.awt.*;

public abstract class Panel {

    private ViewEnum gameMode;
    private Game game;
    private AssetManager assets;

    boolean isGUIShown;

    public Panel(Game game, AssetManager assets, ViewEnum gameMode){
        this.game = game;
        this.assets = assets;
        this.gameMode = gameMode;

        isGUIShown = false;
    }

    public void drawPanel(GraphicsContext gc, Point screenDimension, ViewEnum gameMode){
        if(this.gameMode == gameMode){
            draw(gc, screenDimension);
            if(isGUIShown == false) {
                showGUIElements();
                isGUIShown = true;
            }
        }
    }

    public abstract void draw(GraphicsContext gc, Point screenDimension);
    public abstract void hideGUIElements();
    public abstract void showGUIElements();

    public AssetManager getAssets(){
        return assets;
    }

}
