package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.Game;
import utilities.FileManager.FileManager;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by Karth on 4/8/2017.
 */
public class GameFilePanel extends Panel {
    private double buttonScale = 1;
    private double IMAGE_SPACE = (getAssets().getImage("NEW_MAP_BUTTON").getWidth()-10)*buttonScale;
    private AnchorPane gameFilePanelLayout = new AnchorPane();
    private Button newGameButton = new Button();
    private Button fileSaveButton = new Button();
    private Button fileLoadButton = new Button();
    private Button mainMenuButton = new Button();

    private Game game;
    private AssetManager assets;
    private ViewEnum gameMode;
    private Camera camera;
    private PanelManager panelManager;
    private Group root;
    public GameFilePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game,assets,gameMode);

        this.game = game;
        this.assets = assets;
        this.gameMode = gameMode;
        this.camera = camera;
        this.panelManager = panelManager;
        this.root = root;

        setUpButton(newGameButton, getAssets().getImage("NEW_MAP_BUTTON"));
        newGameButton.setOnAction(event->restartGame());
        setUpButton(fileSaveButton, getAssets().getImage("FILE_SAVE_BUTTON"));
        fileSaveButton.setOnAction(event->saveGame());
        setUpButton(fileLoadButton, getAssets().getImage("FILE_LOAD_BUTTON"));
        fileLoadButton.setOnAction(event->loadGame());
        setUpButton(mainMenuButton, getAssets().getImage("RETURN_MAIN_MENU_BUTTON"));
        mainMenuButton.setOnAction(event->returnToMainMenu());
    }

    private void setUpButton(Button button, Image image){
        button.setGraphic(new ImageView(image));
        gameFilePanelLayout.getChildren().add(button);
        button.getStyleClass().setAll("");
    }

    private void saveGame(){
        FileManager.saveGameManager(game);
    }

    private void loadGame(){
        try {
            this.game = FileManager.loadGameManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void returnToMainMenu(){
        panelManager.setMode(ViewEnum.INTRO_SCENE);
    }

    private void restartGame(){
        this.game = new Game();
    }

    private void setPosition(Point screenDimension){
        double x = 1187*camera.getBackgroundScaleX();
        double y = (screenDimension.y/40)*camera.getBackgroundScaleY();

        newGameButton.setTranslateX(x);
        newGameButton.setTranslateY(y);
        fileSaveButton.setTranslateX(x+IMAGE_SPACE);
        fileSaveButton.setTranslateY(y);
        fileLoadButton.setTranslateX(x+2*IMAGE_SPACE-5);
        fileLoadButton.setTranslateY(y);
        mainMenuButton.setTranslateX(1526*camera.getBackgroundScaleX());
        mainMenuButton.setTranslateY(19*camera.getBackgroundScaleY());

       IMAGE_SPACE = (getAssets().getImage("NEW_MAP_BUTTON").getWidth()-10)*camera.getBackgroundScaleX();
    }

    private void saveFile(File saveMap){
        BufferedWriter writeGame;
        try{
            writeGame = new BufferedWriter(new PrintWriter(saveMap));
            gameWrite(saveMap, writeGame);
            writeGame.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void gameWrite(File gameFile, BufferedWriter bf) throws IOException {
//        //TODO hardcoded to test the method, replace with logic that gets the actual game board
//        HashMap<Location, Tile> map = new HashMap<>();
//        map = game.getMap();
//
//        TileFileVisitor fileVisitor = new TileFileVisitor();
//        for (Location o: map.keySet()) {
//            fileVisitor.refresh();
//            map.get(o).accept(fileVisitor);
//
//            TileFileInfo tileInfo = fileVisitor.getTileInfo();
//
//            if (tileInfo.getTerrain() == null) {
//                System.out.println("Map write aborted, null terrain!!!");
//                break;
//            }
//
//            String writeLine = location_print(o) + " " + tileInfo.getTerrain();
//
//            if (!tileInfo.getRiverEdges().isEmpty()) {
//                writeLine += " (" + edge_print(tileInfo.getRiverEdges()) + ")";
//            }
//
//            bf.write(writeLine);
//            bf.newLine();
//        }
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        setPosition(screenDimension);
    }

    public void showGUIElements(){
        root.getChildren().add(gameFilePanelLayout);
    }

    public void hideGUIElements(){
        root.getChildren().remove(gameFilePanelLayout);
    }


}
