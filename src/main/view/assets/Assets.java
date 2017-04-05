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
        loadItem("NEW_MAP_BUTTON", "Assets/NewFileButton.png");
        loadItem("FILE_SAVE_BUTTON", "Assets/SaveFileButton.png");
        loadItem("FILE_LOAD_BUTTON", "Assets/LoadFileButton.png");
        loadItem("START_GAME_BUTTON", "Assets/StartGameButton.png");
        loadItem("NORMAL_RIVER_180", "Assets/NormalRiver180.png");
        loadItem("NORMAL_RIVER_60", "Assets/NormalRiver60.png");
        loadItem("NORMAL_RIVER_120", "Assets/NormalRiver120.png");
        loadItem("SOURCE_RIVER", "Assets/SourceRiver.png");
        loadItem("FORKED_RIVER", "Assets/ForkedRiver.png");
        loadItem("EMPTY_HEX_GRID","Assets/EmptyHexGrid.png");
        loadItem("BOTTOM_PANEL", "Assets/BottomPanel.png");
        loadItem("TILE_SELECTOR", "Assets/TileSelector.png");
        loadItem("DESERT_TILE", "Assets/DesertTile.png");
        loadItem("WOOD_TILE", "Assets/WoodTile.png");
        loadItem("TERRAIN_SELECTED","Assets/TerrainSelected.png");
        loadItem("RIVER_SELECTED","Assets/RiverSelected.png");
        loadItem("FINAL_SELECTED","Assets/FinalSelected.png");
        loadItem("BUTTON_MOVE","Assets/ButtonMove.png" );
        loadItem("START_GAME_BUTTON_TEXT", "Assets/StartGameButtonText.png");
        loadItem("OPTION_BUTTON","Assets/OptionButton.png");
        loadItem("MAP_MAKER_BUTTON", "Assets/MapMakerButton.png");
        loadItem("INTRO_BACKGROUND_IMAGE", "Assets/IntroBackground.png");
        loadItem("GAME_BORDER","Assets/GameBorder.png");
        loadItem("SIDE_PANEL_BACKGROUND", "Assets/SidePanelBackground.png");
        loadItem("WONDER_BOARD", "Assets/WonderBoard.png");
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
