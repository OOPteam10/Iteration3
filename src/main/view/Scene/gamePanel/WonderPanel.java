package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Game;
import model.Wonder.Wonder;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;

/**
 * Created by Karth on 4/5/2017.
 */
public class WonderPanel extends Panel {
    private Image wonderBoard = getAssets().getImage("WONDER_BOARD");
    private Image wonderBackground = getAssets().getImage("WONDER_BACKGROUND");
    private int basePointX;
    private int basePointY;
    private Wonder wonder;
    private Camera camera;
    private int brickCount;
    private int wonderX;
    private int wonderY;
    private boolean isVisible = false;
    public WonderPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
        this.wonder = game.getWonder();
        brickCount = wonder.getCount();
        this.camera = camera;
    }

    private void drawWonderBoard(GraphicsContext gc, Point screenDimension){
        wonderX = (int)((screenDimension.x-430)/2 - wonderBoard.getWidth()/2);
        wonderY = (int)(screenDimension.y/2 - wonderBoard.getHeight()/2);
        gc.drawImage(wonderBoard, wonderX,
                wonderY);
    }

    private void drawWonderBackground(GraphicsContext gc, Point screenDimension){
        gc.drawImage(wonderBackground,0,0,
                wonderBackground.getWidth()*camera.getBackgroundScaleX(),
                wonderBackground.getHeight()*camera.getBackgroundScaleY());
    }

    private void drawBricks(GraphicsContext gc, Point screenDimension){
        Image img = getAssets().getImage("RED_BRICK");
        basePointX = wonderX;
        basePointY = screenDimension.y - wonderY - (int)img.getHeight();
        brickCount = wonder.getCount()-1;
        for(int i = 0; i<Math.min(12, brickCount); i++){
            drawSingleBrick(gc, i%4, i/4);
        }
        if(brickCount>=12){
            for(int i = 12; i<Math.min(32,brickCount);i++){
                drawSingleBrick(gc, (i-12)%5, (i-12)/5+3);
            }
        }
        if(brickCount>=32){
            for(int i = 32; i<brickCount;i++){
                drawSingleBrick(gc, (i-32)%6, (i-32)/6+7);
            }
        }

       // gc.drawImage(img, basePointX, basePointY);
    }

    public void draw(GraphicsContext gc, Point screenDimension) {
        if(isVisible) {
            drawWonderBackground(gc, screenDimension);
            drawWonderBoard(gc, screenDimension);
            drawBricks(gc, screenDimension);
        }
    }

    private void drawSingleBrick(GraphicsContext gc, int i, int j){
        Image img = getAssets().getImage("RED_BRICK");
        gc.drawImage(img, basePointX+94*i, basePointY - 66*j);
    }

    public void toggle(){
        isVisible = !isVisible;
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
