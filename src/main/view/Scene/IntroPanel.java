package view.Scene;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import model.Game;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by Karth on 4/2/2017.
 */
public class IntroPanel extends Panel {
    private Game game;
    private AssetManager assets;
    private ViewEnum gameMode;
    private Group root;
    private Camera camera;
    private AnchorPane introPanelLayout = new AnchorPane();
    private PanelManager panelManager;

    private Button startGameButton = new Button();
    private Button optionButton = new Button();
    private Button mapMakerButton = new Button();
    private double scaleBackground = 0.4;
    private Image background;

    public IntroPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);

        this.game = game;
        this.assets = assets;
        this.gameMode = gameMode;
        this.root = root;
        this.camera = camera;
        this.panelManager = panelManager;
        this.background = getAssets().getImage("INTRO_BACKGROUND_IMAGE");

        setUpButton(startGameButton, getAssets().getImage("START_GAME_BUTTON_TEXT"));
        startGameButton.setOnAction(event -> startGame());
        setUpButton(optionButton, getAssets().getImage("OPTION_BUTTON"));
        optionButton.setOnAction(event->startOptionMenu());
        setUpButton(mapMakerButton, getAssets().getImage("MAP_MAKER_BUTTON"));
        mapMakerButton.setOnAction(event -> startMapMaker());
    }

    private void setUpButton(Button button, Image image){
        button.setGraphic(new ImageView(image));
        introPanelLayout.getChildren().add(button);
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        updateScaleBackground(screenDimension);
        setPosition(screenDimension);
        gc.drawImage(background,screenDimension.x/2 - background.getWidth()/2*scaleBackground, screenDimension.y/3 - background.getHeight()/2*scaleBackground,
                scaleBackground*background.getWidth(), scaleBackground*background.getHeight());
    }

    private void setPosition(Point screenDimension){
        double x = screenDimension.x/2;
        double y = screenDimension.y/20;
        startGameButton.setTranslateX(x - 269/2);
        //startGameButton.setTranslateX(x);
        startGameButton.setTranslateY(14*y);

        optionButton.setTranslateX(x-getAssets().getImage("OPTION_BUTTON").getWidth()/2);
        //optionButton.setTranslateX(x);
        optionButton.setTranslateY(16*y);

        mapMakerButton.setTranslateX(x-getAssets().getImage("MAP_MAKER_BUTTON").getWidth()/2);
        //mapMakerButton.setTranslateX(x);
        mapMakerButton.setTranslateY(18*y);
    }

    public void showGUIElements(){
        root.getChildren().add(introPanelLayout);
    }

    public void hideGUIElements(){
        root.getChildren().remove(introPanelLayout);
    }

    private void startGame(){
        camera.centerBoardInGame();
        panelManager.setMode(ViewEnum.MAIN_GAME);
    }

    private void startOptionMenu(){
        panelManager.setMode(ViewEnum.OPTION_SCENE);
    }

    private void startMapMaker(){
        panelManager.setMode(ViewEnum.MAP_MAKER);
    }

    private void updateScaleBackground(Point screenDimension){
        this.scaleBackground = (double)screenDimension.x/2600;
    }
}
