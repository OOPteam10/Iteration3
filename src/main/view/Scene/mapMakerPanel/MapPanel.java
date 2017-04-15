package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import model.MapSubsystem.Location;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
import utilities.TileEditor;
import view.Camera;
import view.Panel;
import view.ViewEnum;
import view.assets.AssetManager;

import java.awt.*;
import java.util.HashMap;

public class MapPanel extends Panel{

    private HashMap<Location, Tile> gameMap;
    private AssetManager assets;
    private Camera camera;
    private Game game;

    public MapPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera){
        super(game, assets,gameMode);
        this.assets = assets;
        this.game = game;
        //TODO: this is hard coded, remove it after
        gameMap = new HashMap<>();
        gameMap = game.getMap();
        this.camera = camera;

//        camera.setScale(1);
//        camera.setCameraOffset(1,1);
        //gameMap = generateMap();
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        drawBackground(gc);
        for(Location loc:gameMap.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            TileDrawingVisitor tileDrawingVisitor = new TileDrawingVisitor(assets, gc,p,camera);
            gameMap.get(loc).accept(tileDrawingVisitor);
        }
        drawTileSelector(gc);
        updateMap();
    }

    public void drawBackground(GraphicsContext gc){
        for (int i=0;i<21;i++){
            for(int j=0;j<21;j++){
                Point p = new Point(i-10,j-10);
                gc.drawImage(assets.getImage("EMPTY_HEX_GRID"), camera.offset( p).x,camera.offset( p).y,camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getWidth(),
                        camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getHeight());
            }
        }
    }

    public void drawTileSelector(GraphicsContext gc){
        Point p = new Point();
        p.x = TileEditor.getInstance().getLocation().getX();
        p.y = TileEditor.getInstance().getLocation().getY();
        gc.drawImage(assets.getImage("TILE_SELECTOR"), camera.offset( p).x, camera.offset( p).y,camera.getScale() * assets.getImage("TILE_SELECTOR").getWidth(),
                camera.getScale() * assets.getImage("TILE_SELECTOR").getHeight());
    }

    private void updateMap(){
        gameMap = game.getMap();
    }

    public void showGUIElements(){}
    public void hideGUIElements(){}
}
