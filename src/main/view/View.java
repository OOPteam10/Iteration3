package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by cduica on 3/22/17.
 */
public class View {
    private AssetManager assets;
    private static final int SCREEN_WIDTH = 1024;
    private static final int SCREEN_HEIGHT = 768;

    private Canvas canvas;
    private GraphicsContext gc;
    private Group root;
    private PanelManager panelManager;
    private Point screenDimension = new Point();
    private Scene scene;
    private int pulse = 0;
    private Camera camera;

    public View(Game game, Scene scene, Group root){
        assets = new AssetManager();
        this.root = root;
        this.scene = scene;

        canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        screenDimension.x = SCREEN_WIDTH;
        screenDimension.y = SCREEN_HEIGHT;
        camera = new Camera(screenDimension);
        gc = canvas.getGraphicsContext2D();
        panelManager = new PanelManager(game, assets, root, gc, camera);

        initializeView();
    }

    private void initializeView(){
        root.getChildren().add(canvas);
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
}
