package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.Game;
import view.*;
import view.Panel;
import view.assets.AssetManager;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class FilePanel extends view.Panel {

    private AnchorPane filePanelLayout = new AnchorPane();
    private Button newMapButton = new Button();
    private Button fileSaveButton = new Button();
    private Button fileLoadButton = new Button();
    private Button startGameButton = new Button();
    private Group root;

    public FilePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root){
        super(game, assets, gameMode);

        this.root = root;
        setUpButton(newMapButton, getAssets().getImage("NEW_MAP_BUTTON"));
        newMapButton.setOnAction(event-> restartMap());
        setUpButton(fileSaveButton, getAssets().getImage("FILE_SAVE_BUTTON"));
        fileSaveButton.setOnAction(event -> saveMap());
        setUpButton(fileLoadButton, getAssets().getImage("FILE_LOAD_BUTTON"));
        fileLoadButton.setOnAction(event->loadMap());
        setUpButton(startGameButton, getAssets().getImage("START_GAME_BUTTON"));
        //TODO Bind the start game button to StartGame function

    }

    public void draw(GraphicsContext gc, Point screenDimension){
        setPositions(screenDimension);
    }

    private void setUpButton(Button button, Image image){
        button.setGraphic(new ImageView(image));
        filePanelLayout.getChildren().add(button);
    }

    private void setPositions(Point screenDimension){
        int x = screenDimension.x/8;
        int y = screenDimension.y - 125;

        newMapButton.setTranslateX(0);
        newMapButton.setTranslateY(y);

        fileSaveButton.setTranslateX(1*x);
        fileSaveButton.setTranslateY(y);

        fileLoadButton.setTranslateX(2*x);
        fileLoadButton.setTranslateY(y);

        startGameButton.setTranslateX(screenDimension.x - 120);
        startGameButton.setTranslateY(y);
    }

    private void restartMap(){

    }

    private void saveMap(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Map");
        fileChooser.setInitialDirectory(new File("Assets/Maps"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files","*.txt"));
        File saveMap = fileChooser.showSaveDialog(null);
        if(saveMap!=null){
            saveFile(saveMap);
        }
    }

    private void saveFile(File saveMap){
        BufferedWriter writeMap;
        try{
            writeMap = new BufferedWriter(new PrintWriter(saveMap));
            writeMap.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void loadMap(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Map");
        fileChooser.setInitialDirectory(new File("Assets/Maps"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files", "*.txt"));
        File newMap = fileChooser.showOpenDialog(null);
        if(newMap!= null){
            //mapReader function
        }
    }

    public void hideGUIElements(){root.getChildren().remove(filePanelLayout);}
    public void showGUIElements(){root.getChildren().add(filePanelLayout);}
}
