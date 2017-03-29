package view;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Scene.MapMakerPanel;
import view.assets.AssetManager;

import java.awt.*;
import java.util.ArrayList;

public class PanelManager {
    private ViewEnum currentViewMode;
    private MapMakerPanel mapMakerPanel;
    private Game game;
    private AssetManager assets;
    private GraphicsContext gc;
    private ArrayList<Panel> panels;
    private Camera camera;

    public PanelManager(Game game, AssetManager assets, Group group, GraphicsContext gc, Camera camera){
        currentViewMode = ViewEnum.MAP_MAKER;

        this.game = game;
        this.gc = gc;
        this.camera = camera;
        panels = new ArrayList<>();
        mapMakerPanel = new MapMakerPanel(game, assets, ViewEnum.MAP_MAKER, group, camera);
        panels.add(mapMakerPanel);
    }

    public void drawPanels(Point screenDimension){
        for(int i = 0; i<panels.size();i++){
            panels.get(i).drawPanel(gc, screenDimension, currentViewMode);
        }
    }

    public void setMode(ViewEnum currentViewMode){this.currentViewMode = currentViewMode;}
}
