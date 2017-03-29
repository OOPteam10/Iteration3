package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;

import java.awt.*;

public class Camera {
    private final static int HEX_W = 115;
    private final static int HEX_H = 100;

    private int cameraOffsetX;
    private int cameraOffsetY;

    private double scale;

    public Camera(Point screenDimension){
        cameraOffsetX = 0;
        cameraOffsetY = 0;

        scale = 1.0;
    }

    public Point offset(GraphicsContext gc, Point p) {
        Point offsetTile = new Point();
        Point offset = new Point(1024/2-115,768/2-100);

        offsetTile.x = getPixelLocation(p).x + offset.x + cameraOffsetX;
        offsetTile.y = getPixelLocation(p).y + offset.y + cameraOffsetY;
        return offsetTile;
    }

    public void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    public void setCameraOffset(int x, int y){
        cameraOffsetX = x*HEX_W;
        cameraOffsetY = y*HEX_H;
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
}
