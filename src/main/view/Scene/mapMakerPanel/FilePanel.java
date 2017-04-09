package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.Game;
import model.MapSubsystem.Location;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileFileVisitor;
import utilities.FileManager.FileManager;
import view.*;
import utilities.FileManager.TileFileInfo;
import view.assets.AssetManager;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class FilePanel extends view.Panel {

    private AnchorPane filePanelLayout = new AnchorPane();
    private Button newMapButton = new Button();
    private Button fileSaveButton = new Button();
    private Button fileLoadButton = new Button();
    private Button startGameButton = new Button();

    private Camera camera;
    private HashMap<Location, Tile> gameMap = new HashMap<>();
    private Group root;
    private Game game;
    private PanelManager panelManager;

    public FilePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
        this.game =game;
        this.root = root;
        this.camera = camera;
        this.panelManager = panelManager;
        setUpButton(newMapButton, getAssets().getImage("NEW_MAP_BUTTON"));
        newMapButton.setOnAction(event-> restartMap());
        setUpButton(fileSaveButton, getAssets().getImage("FILE_SAVE_BUTTON"));
        fileSaveButton.setOnAction(event -> FileManager.saveMap(gameMap));
        setUpButton(fileLoadButton, getAssets().getImage("FILE_LOAD_BUTTON"));

        fileLoadButton.setOnAction(event -> {
            try {
                gameMap = FileManager.loadMap();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        setUpButton(startGameButton, getAssets().getImage("START_GAME_BUTTON"));
        startGameButton.setOnAction(event->startGame());

    }

    public void draw(GraphicsContext gc, Point screenDimension){
        setPositions(screenDimension);
    }

    private void setUpButton(Button button, Image image){
        button.setGraphic(new ImageView(image));
        filePanelLayout.getChildren().add(button);
    }

    private void setPositions(Point screenDimension){
        int x = 130;
        int y = screenDimension.y - 125;


        newMapButton.setTranslateX(0);
        newMapButton.setTranslateY(y);

        fileSaveButton.setTranslateX(x);
        fileSaveButton.setTranslateY(y);

        fileLoadButton.setTranslateX(2*x);
        fileLoadButton.setTranslateY(y);

        startGameButton.setTranslateX(screenDimension.x - 120);
        startGameButton.setTranslateY(y);
    }

    private void restartMap(){
        HashMap<Location, Tile> newMap = new HashMap<>();
        game.setMap(newMap);
    }


    private void startGame() {
        camera.centerBoardInGame();
        panelManager.setMode(ViewEnum.MAIN_GAME);
    }

    public void hideGUIElements(){root.getChildren().remove(filePanelLayout);}
    public void showGUIElements(){root.getChildren().add(filePanelLayout);}

    public HashMap<Location, Tile> getGameMap() {
        return gameMap;
    }
}
