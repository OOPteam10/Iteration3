package view.Scene;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.Scene.gamePanel.*;
import view.ViewEnum;
import view.assets.AssetManager;
import javafx.scene.image.Image;
import java.awt.*;

/**
 * Created by Karth on 4/5/2017.
 */
public class GamePanel extends Panel {
    private GameboardPanel gameboardPanel;
    private ResearchPanel researchPanel;
    private TileDetailPanel tileDetailPanel;
    private WonderPanel wonderPanel;
    private GameFilePanel gameFilePanel;

    private Game game;
    private AssetManager assets;
    private ViewEnum gameMode;
    private Camera camera;
    private PanelManager panelManager;
    private Group root;
    private Image gameboardBorder;
    private Image sidePanelBackground;

    public GamePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);

        this.game = game;
        this.assets = assets;
        this.gameMode = gameMode;
        this.camera = camera;
        this.panelManager = panelManager;
        this.root = root;

        gameboardBorder = getAssets().getImage("GAME_BORDER");
        sidePanelBackground = getAssets().getImage("SIDE_PANEL_BACKGROUND");
        initializeGame();
    }

    private void initializeGame(){
        gameboardPanel = new GameboardPanel(game, assets, gameMode, root, camera, panelManager);
        researchPanel = new ResearchPanel(game, assets, gameMode, root, camera, panelManager);
        tileDetailPanel = new TileDetailPanel(game, assets, gameMode, root, camera, panelManager);
        wonderPanel = new WonderPanel(game, assets, gameMode, root, camera, panelManager);
        gameFilePanel = new GameFilePanel(game, assets, gameMode, root, camera, panelManager);
    }

    private void drawBorder(GraphicsContext gc){
        //gc.drawImage(getAssets().getImage("GAME_BORDER"), 0, 0);
        gc.drawImage(gameboardBorder, 0, 0, gameboardBorder.getWidth()*camera.getBackgroundScaleX(),
                gameboardBorder.getHeight()*camera.getBackgroundScaleY());
    }

    private void drawSidePanelBackground(GraphicsContext gc, Point screenDimension){
        gc.drawImage(sidePanelBackground,
                (screenDimension.x - sidePanelBackground.getWidth()*camera.getBackgroundScaleX()),
                (screenDimension.y-sidePanelBackground.getHeight()*camera.getBackgroundScaleY()),
                sidePanelBackground.getWidth()*camera.getBackgroundScaleX(),
                sidePanelBackground.getHeight()*camera.getBackgroundScaleY());
    }

    public void draw(GraphicsContext gc, Point screenDimension){

        gameboardPanel.draw(gc, screenDimension);
        drawSidePanelBackground(gc, screenDimension);
        researchPanel.draw(gc, screenDimension);
        tileDetailPanel.draw(gc,screenDimension);
        gameFilePanel.draw(gc, screenDimension);
        //wonderPanel.draw(gc, screenDimension);
        drawBorder(gc);
    }

    public void showGUIElements(){
        gameboardPanel.showGUIElements();
        researchPanel.showGUIElements();
        tileDetailPanel.showGUIElements();
        wonderPanel.showGUIElements();
        gameFilePanel.showGUIElements();
    }

    public void hideGUIElements(){
        gameboardPanel.hideGUIElements();
        researchPanel.hideGUIElements();
        tileDetailPanel.hideGUIElements();
        wonderPanel.hideGUIElements();
        gameFilePanel.hideGUIElements();
    }
}
