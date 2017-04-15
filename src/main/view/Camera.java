package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;

import java.awt.*;

public class Camera {
    private final static int HEX_W = 400;
    private final static int HEX_H = 347;
    private int screenWidth;
    private int screenHeight;
    private Point screenDimension;
    private int cameraOffsetX;
    private int cameraOffsetY;

    private double scale;

    public Camera(Point screenDimension, int screenWidth, int screenHeight){
        cameraOffsetX = 150;
        cameraOffsetY = -250;
        this.screenDimension = screenDimension;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        scale = 0.3;
    }

    public Point offset(Point p) {
        Point offsetTile = new Point();
        Point offset = new Point(screenDimension.x/2-HEX_W/2,screenDimension.y/2+HEX_H);

        offsetTile.x = getPixelLocation(p).x + offset.x + cameraOffsetX;
        offsetTile.y = screenDimension.y-(getPixelLocation(p).y + offset.y + cameraOffsetY);
        return offsetTile;
    }

    public void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    private void setCameraOffset(int x, int y){
        cameraOffsetX = cameraOffsetX + (int)(x*HEX_W*scale);
        cameraOffsetY = cameraOffsetY + (int)(y*HEX_H*scale);
    }

    private Point getPixelLocation(Point p) {
        Point pixelLocation = new Point();

        pixelLocation.x = (int)(0.75f *scale* HEX_W * p.x);
        pixelLocation.y = (int)(HEX_H *scale* (p.x * 0.5f + p.y));
        return pixelLocation;
    }



    public void setScale(double scale){
        this.scale = scale;
    }

    public double getScale(){
        return scale;
    }

    public void moveUpMap(){
        setCameraOffset(0,-1);
    }

    public void moveDownMap(){
        setCameraOffset(0,1);
    }

    public void moveLeftMap(){
        setCameraOffset(1,0);
    }

    public void moveRightMap(){
        setCameraOffset(-1,0);
    }

    public void zoomIn(){
        if(this.scale <= 2) {
            this.setScale(this.scale + 0.1);
        }
    }

    public void zoomOut(){
        if(this.scale>=0.1) {
            this.setScale(this.scale - 0.1);
            if(scale<=0){
                scale = 0.1;
            }
        }
    }

    public void centerBoardInGame(){
        setCameraOffset(-1, 0);
    }

    public double getBackgroundScaleX(){
        //System.out.print((double)screenDimension.x/screenWidth+" ");
        return (double)screenDimension.x/screenWidth;
    }

    public double getBackgroundScaleY(){
        //System.out.println((double)screenDimension.y/screenHeight);
        return (double)screenDimension.y/screenHeight;
    }

    public double getTransporterScale(){
        return getScale()*0.15;
    }
    public double getResourceScale(){return getScale()*0.08;}

    public int getTileWidth(){
        return HEX_W;
    }

    public int getTileHeight(){
        return HEX_H;
    }
}
