package model.Managers.Visitor;

import javafx.scene.canvas.GraphicsContext;
import view.Camera;
import view.assets.AssetManager;
import javafx.scene.image.Image;

import java.awt.*;

public class RoadDetailDrawingVisitor implements  RoadVisitor {
    private AssetManager assets;
    private GraphicsContext gc;
    private Point p;
    private Camera camera;
    private int angle;
    public RoadDetailDrawingVisitor(AssetManager assets, GraphicsContext gc, Point p, Camera camera, int angle){
        this.assets = assets;
        this.gc = gc;
        this.p = p;
        this.camera = camera;
        this.angle = angle;
    }


    @Override
    public void visitRoad() {
        Image roadImage = assets.getImage("ROAD");
        drawRotatedImage(roadImage, angle, p.x, p.y);
    }

    private void drawRotatedImage(javafx.scene.image.Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        camera.rotate(gc, angle, tlpx + image.getWidth()*camera.getBackgroundScaleY() / 2,
                tlpy + image.getHeight()*camera.getBackgroundScaleY() / 2);
        gc.drawImage(image, tlpx, tlpy, camera.getBackgroundScaleY() * image.getWidth(),
                camera.getBackgroundScaleY() * image.getHeight());
        gc.restore(); // back to original state (before rotation)
    }
}
