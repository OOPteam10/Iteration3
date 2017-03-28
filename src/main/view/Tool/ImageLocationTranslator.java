package view.Tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;

import java.awt.*;

public class ImageLocationTranslator {
    private Point p;
    private final static int HEX_W = 115;
    private final static int HEX_H = 100;
    public ImageLocationTranslator(GraphicsContext gc, Point p){
        this.p = p;
    }

    public Point offset() {
        Point offsetTile = new Point();
        Point offset = new Point(1024/2-115,768/2-100);

        offsetTile.x = getPixelLocation().x + offset.x;
        offsetTile.y = getPixelLocation().y + offset.y;
        return offsetTile;
    }

    public void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }


    private Point getPixelLocation() {
        Point pixelLocation = new Point();

        pixelLocation.x = (int)(0.75f * HEX_W * p.x);
        pixelLocation.y = (int)(HEX_H * (p.x * 0.5f + p.y));
        return pixelLocation;
    }
}
