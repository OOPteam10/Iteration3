package view.Scene;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.Scene.gamePanel.GameboardPanel;
import view.Scene.gamePanel.ResearchPanel;
import view.Scene.gamePanel.TileDetailPanel;
import view.Scene.gamePanel.WonderPanel;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by Karth on 4/5/2017.
 */
public class GamePanel extends Panel {

    private GameboardPanel gameboardPanel;
    private ResearchPanel researchPanel;
    private TileDetailPanel tileDetailPanel;
    private WonderPanel wonderPanel;

    private Game game;
    private AssetManager assets;
    private ViewEnum gameMode;
    private Camera camera;
    private PanelManager panelManager;
    private Group root;

    public GamePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);

        this.game = game;
        this.assets = assets;
        this.gameMode = gameMode;
        this.camera = camera;
        this.panelManager = panelManager;
        this.root = root;
        initializeGame();
    }

    private void initializeGame(){
        gameboardPanel = new GameboardPanel(game, assets, gameMode, root, camera, panelManager);
        researchPanel = new ResearchPanel(game, assets, gameMode, root, camera, panelManager);
        tileDetailPanel = new TileDetailPanel(game, assets, gameMode, root, camera, panelManager);
        wonderPanel = new WonderPanel(game, assets, gameMode, root, camera, panelManager);
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        gameboardPanel.draw(gc, screenDimension);
        researchPanel.draw(gc, screenDimension);
        tileDetailPanel.draw(gc,screenDimension);
        wonderPanel.draw(gc, screenDimension);

        //Code for draw the borders
    }

    public void showGUIElements(){
        gameboardPanel.showGUIElements();
        researchPanel.showGUIElements();
        tileDetailPanel.showGUIElements();
        wonderPanel.showGUIElements();
    }

    public void hideGUIElements(){
        gameboardPanel.hideGUIElements();
        researchPanel.hideGUIElements();
        tileDetailPanel.hideGUIElements();
        wonderPanel.hideGUIElements();
    }
}
