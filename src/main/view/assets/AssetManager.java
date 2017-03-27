package view.assets;

import javafx.scene.image.Image;

public class AssetManager {
    Assets assets;

    public AssetManager(){
        this.assets = Assets.getInstance();
        assets.loadResources();
    }

    public Image getImage(String imageName){return assets.getImage(imageName);}

    public int getImageWidth(String imageName){return (int)assets.getImage(imageName).getWidth();}
    public int getImageHeight(String imageName){return (int)assets.getImage(imageName).getHeight();}
}
