package model.Managers.Visitor;

import javafx.scene.canvas.GraphicsContext;
import view.Camera;
import view.assets.AssetManager;
import javafx.scene.image.Image;

import java.awt.*;

public class RoadDrawingVisitor{
    private AssetManager assets;
    private GraphicsContext gc;
    private Camera camera;
    private Point p;
    private int angle;
    // current constructed tile


    public RoadDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera, int angle) {
        this.assets = assets;
        this.gc = gc;
        this.p = p;
        this.angle = angle;

        this.camera = camera;
    }

    public void visitRoad(){
        Image roadImage = assets.getImage("ROAD");
        drawRotatedImage(roadImage, angle, camera.offset(p).x, camera.offset(p).y);
    }

    private void drawRotatedImage(Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        camera.rotate(gc, angle, tlpx + image.getWidth()*camera.getScale() / 2, tlpy + image.getHeight()*camera.getScale() / 2);
        gc.drawImage(image, tlpx, tlpy, camera.getScale() * image.getWidth(),
                camera.getScale() * image.getHeight());
        gc.restore(); // back to original state (before rotation)
    }
}
