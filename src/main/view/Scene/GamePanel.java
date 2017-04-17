package view.Scene;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.Scene.gamePanel.*;
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
    private GameFilePanel gameFilePanel;
    private AnchorPane gamePanelLayout;
    private ControlStatePanel controlStatePanel;

    private Game game;
    private AssetManager assets;
    private ViewEnum gameMode;
    private Camera camera;
    private PanelManager panelManager;
    private Group root;
    private Image gameboardBorder;
    private Image sidePanelBackground;

    private Button wonderButton;

    public GamePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);

        this.game = game;
        this.assets = assets;
        this.gameMode = gameMode;
        this.camera = camera;
        this.panelManager = panelManager;
        this.root = root;
        this.wonderButton = new Button();

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
        controlStatePanel = new ControlStatePanel(game, assets, gameMode, root, camera, panelManager);
        gamePanelLayout = new AnchorPane();
        setUpButton(wonderButton, assets.getImage("WONDER_BUTTON"));
        wonderButton.setOnAction(event -> toggleWonderPanel());
        setPosition();
    }

    private void setUpButton(Button button, Image image){
        button.setGraphic(new ImageView(image));
        gamePanelLayout.getChildren().add(button);
        button.getStyleClass().setAll("");
    }

    private void setPosition(){
        wonderButton.setTranslateX(21*camera.getBackgroundScaleX());
        wonderButton.setTranslateY(820*camera.getBackgroundScaleY());
    }

    private void toggleWonderPanel(){
        wonderPanel.toggle();
    }
    private void drawBorder(GraphicsContext gc){
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

        setPosition();

        gameboardPanel.draw(gc, screenDimension);
        drawSidePanelBackground(gc, screenDimension);
        researchPanel.draw(gc, screenDimension);
        tileDetailPanel.draw(gc,screenDimension);
        gameFilePanel.draw(gc, screenDimension);
        controlStatePanel.draw(gc, screenDimension);
        wonderPanel.draw(gc, screenDimension);
        drawBorder(gc);
    }

    public void showGUIElements(){
        root.getChildren().add(gamePanelLayout);
        gameboardPanel.showGUIElements();
        researchPanel.showGUIElements();
        tileDetailPanel.showGUIElements();
        wonderPanel.showGUIElements();
        controlStatePanel.showGUIElements();
        gameFilePanel.showGUIElements();
    }

    public void hideGUIElements(){
        gameboardPanel.hideGUIElements();
        researchPanel.hideGUIElements();
        tileDetailPanel.hideGUIElements();
        wonderPanel.hideGUIElements();
        controlStatePanel.showGUIElements();
        gameFilePanel.hideGUIElements();

        root.getChildren().remove(gamePanelLayout);
    }
}
