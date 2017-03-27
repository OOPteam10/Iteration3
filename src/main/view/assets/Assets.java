package view.assets;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public class Assets {

    private static final Assets INSTANCE = new Assets();
    private HashMap<String, Image> assets = new HashMap<String, Image>();


    private Assets(){}

    static Assets getInstance(){
        return INSTANCE;
    }

    public void loadResources(){
        loadImages();
    }

    public void loadImages(){
        loadItem("GRASS_TILE", "Assets/GrassTile.png");
        loadItem("MOUNTAIN_TILE", "Assets/MountainTile.png");
        loadItem("ROCK_TILE", "Assets/RockTile.png");
        loadItem("SEA_TILE", "Assets/SeaTile.png");
    }

    public void loadItem(String name, String path){
        File file = new File(path);
        String localUrl = "";
        try{
            localUrl = file.toURI().toURL().toString();
        }catch(MalformedURLException e){
            System.out.println("Invalid image file: "+ name + " " + path);
            e.printStackTrace();
        }

        assets.put(name, new Image(localUrl));
        System.out.println("Loaded item: " + name);
    }

    public Image getImage(String imageName){return assets.get(imageName);}
}
