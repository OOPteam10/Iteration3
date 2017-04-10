package view;

import controller.MapMakerControlSubsystem.MMCObserver;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import utilities.TileEditor;
import view.assets.AssetManager;

import java.awt.*;
import java.io.File;

/**
 * Created by cduica on 3/22/17.
 */
public class View{
    private AssetManager assets;
    private static final int SCREEN_WIDTH = 1600;
    private static final int SCREEN_HEIGHT = 900;

    private Canvas canvas;
    private GraphicsContext gc;
    private Group root;
    private PanelManager panelManager;
    private Point screenDimension = new Point();
    private Scene scene;
    private Camera camera;
    private MapMakerPreview mapMakerPreview;

    public View(Game game, Scene scene, Group root){
        assets = new AssetManager();
        this.root = root;
        this.scene = scene;

        canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        screenDimension.x = SCREEN_WIDTH;
        screenDimension.y = SCREEN_HEIGHT;
        camera = new Camera(screenDimension, SCREEN_WIDTH, SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        panelManager = new PanelManager(game, assets, root, gc, camera);
        initializeView();
    }

    private void initializeView(){
        root.getChildren().add(canvas);
        mapMakerPreview = new MapMakerPreview(panelManager);
//
//        File buttonStyle = new File("Assets/ButtonStyle.css");
//        scene.getStylesheets().clear();
//        scene.getStylesheets().add("file:///"+buttonStyle.getAbsolutePath().replace("\\","/"));
    }

    public void renderGame(){
        double width = scene.getWidth();
        double height = scene.getHeight();
        canvas.setWidth(width);
        canvas.setHeight(height);
        screenDimension.x = (int)width;
        screenDimension.y = (int)height;

        gc.clearRect(0,0,width,height);
        panelManager.drawPanels(screenDimension);
    }

    public Camera getCamera(){
        return this.camera;
    }

    public MapMakerPreview getMapMakerPreview(){return mapMakerPreview;}
}
