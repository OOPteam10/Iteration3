package view;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Scene.GamePanel;
import view.Scene.IntroPanel;
import view.Scene.MapMakerPanel;
import view.assets.AssetManager;

import java.awt.*;
import java.util.ArrayList;

public class PanelManager {
    private ViewEnum currentViewMode;
    private MapMakerPanel mapMakerPanel;
    private GamePanel gamePanel;
    private IntroPanel introPanel;
    private Game game;
    private AssetManager assets;
    private GraphicsContext gc;
    private ArrayList<Panel> panels;
    private Camera camera;

    public PanelManager(Game game, AssetManager assets, Group group, GraphicsContext gc, Camera camera){
        currentViewMode = ViewEnum.INTRO_SCENE;

        this.game = game;
        this.gc = gc;
        this.camera = camera;
        panels = new ArrayList<>();
        introPanel = new IntroPanel(game, assets, ViewEnum.INTRO_SCENE, group, camera, this);
        panels.add(introPanel);
        mapMakerPanel = new MapMakerPanel(game, assets, ViewEnum.MAP_MAKER, group, camera, this);
        panels.add(mapMakerPanel);
        gamePanel = new GamePanel(game, assets, ViewEnum.MAIN_GAME, group, camera, this);
        panels.add(gamePanel);
    }

    public void drawPanels(Point screenDimension){
        for(int i = 0; i<panels.size();i++){
            panels.get(i).drawPanel(gc, screenDimension, currentViewMode);
        }
    }

    public void setMode(ViewEnum currentViewMode){this.currentViewMode = currentViewMode;}

    public void updateTerrainPreview(String img){
        mapMakerPanel.updateTilePreview(img);
    }

    public void updateRiverPreview(String img){
        mapMakerPanel.updateRiverPreview(img);
    }

    public void updateRotation(int rotation){
        mapMakerPanel.updateRotation(rotation);
    }

    public void selectTerrain(){mapMakerPanel.selectTerrainMode();}
    public void selectRiver(){mapMakerPanel.selectRiverMode();}
    public void selectFinal(){mapMakerPanel.selectFinalPreviewMode();}
}
