package view.Scene;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import view.Camera;
import view.Panel;
import view.Scene.mapMakerPanel.BottomPanel;
import view.Scene.mapMakerPanel.FilePanel;
import view.Scene.mapMakerPanel.MapPanel;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

public class MapMakerPanel extends Panel {

    private static final int BOARD_SIZE = 21;
    private Point screenDimension = new Point(0,0);
    private Group root;


    private BottomPanel bottomPanel;
    private FilePanel filePanel;
    private MapPanel mapPanel;

    public MapMakerPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera){
        super(game, assets, gameMode);
        mapPanel = new MapPanel(game, assets,gameMode, root, camera);
        bottomPanel = new BottomPanel(game, assets, gameMode, root,camera);
        filePanel = new FilePanel(game, assets,gameMode,root);
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        filePanel.draw(gc, screenDimension);
        mapPanel.draw(gc, screenDimension);
        bottomPanel.draw(gc, screenDimension);


        //mapPanel.updateMap(filePanel.getGameMap());
    }

    public void hideGUIElements(){

    }

    public void showGUIElements(){
        filePanel.showGUIElements();
    }

    public void updateTilePreview(String img) {
        bottomPanel.setTerrainPreviewImage(img);
    }

    public void updateRiverPreview(String img){
        bottomPanel.setRiverPreviewImage(img);
    }

    public void updateRotation(int rotation){bottomPanel.setRotationAngle(rotation);}
}
