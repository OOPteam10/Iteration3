package view.Scene;

import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Panel;
import view.Scene.mapMakerPanel.BottomPanel;
import view.Scene.mapMakerPanel.FilePanel;
import view.Scene.mapMakerPanel.MapPanel;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

public class MapMakerPanel extends Panel {
    private BottomPanel bottomPanel;
    private FilePanel filePanel;
    private MapPanel mapPanel;

    public MapMakerPanel(Game game, AssetManager assets, ViewEnum gameMode){
        super(game, assets, gameMode);

    }

    public void draw(GraphicsContext gc, Point screenDimension){
        
    }

    public void hideGUIElements(){

    }

    public void showGUIElements(){

    }
}
