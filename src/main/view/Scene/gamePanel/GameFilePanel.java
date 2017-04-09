package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import model.Game;
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
import javafx.scene.control.Button;
/**
 * Created by Karth on 4/8/2017.
 */
public class GameFilePanel extends Panel {
    private double buttonScale = 1;
    private double IMAGE_SPACE = getAssets().getImage("NEW_MAP_BUTTON").getWidth()*buttonScale+10;
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
    }

    private void saveGame(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Game");
        fileChooser.setInitialDirectory(new File("Assets/Saves"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files","*.txt"));
        File saveGame = fileChooser.showSaveDialog(null);
        if(saveGame!=null){
            saveFile(saveGame);
        }
    }

    private void loadGame(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Game");
        fileChooser.setInitialDirectory(new File("Assets/Saves"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files", "*.txt"));
        File newgame = fileChooser.showOpenDialog(null);
        if(newgame!= null){

        }
    }

    private void returnToMainMenu(){
        panelManager.setMode(ViewEnum.INTRO_SCENE);
    }

    private void restartGame(){

    }

    private void setPosition(Point screenDimension){
        double x = 1187*camera.getBackgroundScaleX();
        double y = 18*camera.getBackgroundScaleY();

        newGameButton.setTranslateX(x);
        newGameButton.setTranslateY(y);
        fileSaveButton.setTranslateX(x+IMAGE_SPACE);
        fileSaveButton.setTranslateY(y);
        fileLoadButton.setTranslateX(x+2*IMAGE_SPACE);
        fileLoadButton.setTranslateY(y);
        mainMenuButton.setTranslateX(screenDimension.x - 70*camera.getBackgroundScaleX());
        mainMenuButton.setTranslateY(y);

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
