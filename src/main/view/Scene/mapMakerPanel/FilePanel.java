package view.Scene.mapMakerPanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.Game;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileFileVisitor;
import view.*;
import view.Panel;
import view.Scene.mapMakerPanel.filePanel.TileFileInfo;
import view.assets.AssetManager;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class FilePanel extends view.Panel {

    private AnchorPane filePanelLayout = new AnchorPane();
    private Button newMapButton = new Button();
    private Button fileSaveButton = new Button();
    private Button fileLoadButton = new Button();
    private Button startGameButton = new Button();
    private HashMap<Location, Tile> gameMap = new HashMap<>();
    private Group root;

    public FilePanel(Game game, AssetManager assets, ViewEnum gameMode, Group root){
        super(game, assets, gameMode);

        this.root = root;
        setUpButton(newMapButton, getAssets().getImage("NEW_MAP_BUTTON"));
        newMapButton.setOnAction(event-> restartMap());
        setUpButton(fileSaveButton, getAssets().getImage("FILE_SAVE_BUTTON"));
        fileSaveButton.setOnAction(event -> saveMap());
        setUpButton(fileLoadButton, getAssets().getImage("FILE_LOAD_BUTTON"));
        fileLoadButton.setOnAction(event -> {
            try {
                loadMap();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        setUpButton(startGameButton, getAssets().getImage("START_GAME_BUTTON"));
        //TODO Bind the start game button to StartGame function

    }

    public void draw(GraphicsContext gc, Point screenDimension){
        setPositions(screenDimension);
    }

    private void setUpButton(Button button, Image image){
        button.setGraphic(new ImageView(image));
        filePanelLayout.getChildren().add(button);
    }

    private void setPositions(Point screenDimension){
        int x = screenDimension.x/8;
        int y = screenDimension.y - 125;


        newMapButton.setTranslateX(0);
        newMapButton.setTranslateY(y);

        fileSaveButton.setTranslateX(1*x);
        fileSaveButton.setTranslateY(y);

        fileLoadButton.setTranslateX(2*x);
        fileLoadButton.setTranslateY(y);

        startGameButton.setTranslateX(screenDimension.x - 120);
        startGameButton.setTranslateY(y);

    }

    private void restartMap(){

    }

    private void saveMap(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Map");
        fileChooser.setInitialDirectory(new File("Assets/Maps"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files","*.txt"));
        File saveMap = fileChooser.showSaveDialog(null);
        if(saveMap!=null){
            saveFile(saveMap);
        }
    }


    public String location_print(Location l) {
        return "(" + l.getX() + "," + l.getY() + "," + l.getZ() + ")";
    }

    public String edge_print(ArrayList<HexSide> edges) {
        if (edges == null) {
            System.out.println("Null edge list, aborting edge_print");
        }
        String spacer = "";
        String out = "";

        for (HexSide c: edges) {
            out += spacer;
            switch(c) {
                case N:
                    out += "1";
                    break;
                case NE:
                    out += "2";
                    break;
                case SE:
                    out += "3";
                    break;
                case S:
                    out += "4";
                    break;
                case SW:
                    out += "5";
                    break;
                case NW:
                    out += "6";
                    break;
            }

            spacer = " ";
        }

        return out;
    }

    public void mapWrite(File mapFile, BufferedWriter bf) throws IOException {
        //TODO hardcoded to test the method, replace with logic that gets the actual game board
        HashMap<Location, Tile> map = new HashMap<>();

        TileFileVisitor fileVisitor = new TileFileVisitor();
        for (Location o: map.keySet()) {
            fileVisitor.refresh();
            map.get(o).accept(fileVisitor);

            TileFileInfo tileInfo = fileVisitor.getTileInfo();

            if (tileInfo.getTerrain() == null) {
                System.out.println("Map write aborted, null terrain!!!");
                break;
            }

            String writeLine = location_print(o) + " " + tileInfo.getTerrain();

            if (!tileInfo.getRiverEdges().isEmpty()) {
                writeLine += " (" + edge_print(tileInfo.getRiverEdges()) + ")";
            }

            bf.write(writeLine);
            bf.newLine();
        }
    }

    private void saveFile(File saveMap){
        BufferedWriter writeMap;
        try{
            writeMap = new BufferedWriter(new PrintWriter(saveMap));
            writeMap.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void loadMap() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Map");
        fileChooser.setInitialDirectory(new File("Assets/Maps"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files", "*.txt"));
        File newMap = fileChooser.showOpenDialog(null);
        if(newMap!= null){
            HashMap<Location, Tile> newMapObject = readFile(newMap);
            //this.gameMap = newMapObject;
        }
    }

    private HashMap<Location,Tile> readFile(File newMap) throws IOException {
        HashMap<Location, Tile> out = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(newMap));

        String in = reader.readLine();

        while (in != null) {
            Location l = parseLocation(in);
            Tile t = parseTile(in);

            out.put(l, t);
        }

        return out;
    }

    private Tile parseTile(String in) {
        Tile t;
        int cur = in.indexOf(')') + 2;
        String buf = "";
        in = in.substring(cur);

        if (in.indexOf('(') == -1) {
            buf = in;

            switch(buf) {
                case "rock":
                    t = new LandTile(Rock.getInstance());
                    break;
                case "pasture":
                    t = new LandTile(Pasture.getInstance());
                    break;
                case "mountains":
                    t = new LandTile(Mountains.getInstance());
                    break;
                case "sea":
                    t = new SeaTile(Sea.getInstance());
                    break;
                case "woods":
                    t = new LandTile(Woods.getInstance());
                    break;
                case "desert":
                    t = new LandTile(Desert.getInstance());
                    break;
                default:
                    System.out.println("somethings screwed up boi. invalid terrain when trying to make a non river tile");
                    t = null;
            }
        } else {
            while (in.charAt(cur) != ' ') {
                //System.out.println("Checking index " + cur + " of " + in);
                buf += in.charAt(cur);
                cur++;
            }

            //Now we know its a river tile
            River r;
            cur = cur +2;
            String riverBuf = "";
            while (in.charAt(cur) != ')') {
                riverBuf += in.charAt(cur);
                cur++;
            }

            String[] riverSplit = riverBuf.split(" ");

            switch (riverSplit.length) {
                case 1:
                    r = new SourceRiver(intSide_to_hexSide(Integer.parseInt(riverSplit[0])));
                    break;
                case 2:
                    r = new NormalRiver(intSide_to_hexSide(Integer.parseInt(riverSplit[0])), intSide_to_hexSide(Integer.parseInt(riverSplit[1])));
                    break;
                case 3:
                    r = new ForkedRiver(intSide_to_hexSide(Integer.parseInt(riverSplit[0])), intSide_to_hexSide(Integer.parseInt(riverSplit[1])),
                            intSide_to_hexSide(Integer.parseInt(riverSplit[2])));
                    break;
                default:
                    System.out.println("what r u doing son theres no such river");
                    r = null;
            }
            Terrain terrain;
            switch(buf) {
                case "rock":
                    terrain = Rock.getInstance();
                    break;
                case "pasture":
                    terrain = Pasture.getInstance();
                    break;
                case "mountains":
                    terrain = Mountains.getInstance();
                    break;
                case "sea":
                    terrain = Sea.getInstance();
                    break;
                case "woods":
                    terrain = Woods.getInstance();
                    break;
                case "desert":
                    terrain = Desert.getInstance();
                    break;
                default:
                    System.out.println("When trying to find a tile for this river tile something is broke");
                    terrain = null;
            }

            t = new RiverTile(terrain, r);
        }

        return t;
    }

    private HexSide intSide_to_hexSide(int intSide) {
        switch (intSide) {
            case 1:
                return HexSide.N;
            case 2:
                return HexSide.NE;
            case 3:
                return HexSide.SE;
            case 4:
                return HexSide.S;
            case 5:
                return HexSide.SW;
            case 6:
                return HexSide.NW;
            default:
                System.out.println("what are u tryin to pull here, you can't convert " + intSide + " to a hexside, loser");
                return null;
        }
    }

    private Location parseLocation(String in) {
        String buf = "";
        int cur = 0;

        while (in.charAt(cur) != ')') {
            buf += in.charAt(cur);
            cur++;
        }

        String[] splited = buf.split(",");

        String x = splited[0].substring(1);
        String y = splited[1];
        String z = splited[2];

        Location l = new Location(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z));
        return l;
    }

    public void hideGUIElements(){root.getChildren().remove(filePanelLayout);}
    public void showGUIElements(){root.getChildren().add(filePanelLayout);}

    public HashMap<Location, Tile> getGameMap() {
        return gameMap;
    }
}
