package utilities.FileManager;

import javafx.stage.FileChooser;
import model.Game;
import model.Managers.Adjacency;
import model.Managers.AdjacencyManager;
import model.Managers.SectorAdjacencyManager;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Rivers.ForkedRiver;
import model.TileSubsystem.Rivers.NormalRiver;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Rivers.SourceRiver;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.*;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileFileVisitor;
import model.TileSubsystem.Waterway;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;
import model.Transporters.Visitor.LandTransporterFileVisitor;
import model.Transporters.Visitor.SeaTransporterFileVisitor;
import model.Transporters.Visitor.SeaTransporterVisitor;
import model.resources.Resource;
import model.resources.Visitor.ResourceFileVisitor;
import model.structures.producers.Producer;
import model.structures.producers.Visitor.PrimaryProducerFileVisitor;
import model.structures.producers.Visitor.SecondaryProducerFileVisitor;
import model.structures.producers.primary.PrimaryProducer;
import model.structures.producers.secondary.SecondaryProducer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by doug0_000 on 4/9/2017.
 */
public class FileManager {


        /*
         |---------------|
         |Save Game Stuff|
         |---------------|
        */


        public static void saveGameManager(Game g) {
            System.out.println("Got to manager");
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Game");
            fileChooser.setInitialDirectory(new File("Assets/Saves"));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files","*.txt"));
            File saveGame = fileChooser.showSaveDialog(null);
            if(saveGame!=null){
                saveGame(saveGame, g);
            }
        }


        public static void saveGame(File saveGame, Game g) {
            try {
                System.out.println("Got to actual");
                BufferedWriter writer = new BufferedWriter(new PrintWriter(saveGame));
                for (Location l: g.getMap().keySet()) {
                    tile_write(l, writer, g);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static void tile_write(Location loc, BufferedWriter writer, Game g) throws IOException {
            System.out.println("Got to tileSaver");
            TileFileVisitor tf = new TileFileVisitor();

            g.getMap().get(loc).accept(tf);
            writer.write(location_print(loc) + " " +  tf.getTileInfo().toFileFormat());
            writer.newLine();
            for (Sector s: g.getMap().get(loc).getSectors()) {
                System.out.println("got to sector");
                writer.write("BEGIN SECTOR " + s.toString());
                writer.newLine();
                landTransporter_write(s, writer, g);
                resource_write(s, writer, g);
                dockedSeaTransporter_write(s, writer, g);
                primaryLandProducer_write(s, writer, g);
                secondaryLandProducer_write(s, writer, g);
                //#TODO: write sea structures (OIL RIGS BOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII)
                //#TODO: write logistical structures on sector
                road_write(s, writer, g);
                //#TODO: write geese
                writer.write("END SECTOR");
                writer.newLine();

            }

            seaTransporter_write(loc, writer, g);

            writer.write("END TILE");
            writer.newLine();
        }

        private static void road_write(Sector s, BufferedWriter writer, Game g) throws IOException {
            SectorAdjacencyManager roadManager = g.getRoadAdjacencyManager();
            Adjacency<CardinalDirection, Sector> adjacents = roadManager.getAdjacency(s);

            if (adjacents != null) {
                int numDirections = adjacents.getDirectionList().size();
                if (numDirections == 0) {
                    //I don't know if this is necessary
                    return;
                }
                writer.write("BEGIN ROAD " + numDirections);
                writer.newLine();
                
                for (CardinalDirection c: adjacents.getDirectionList()) {
                    writer.write(c.name() + " " + adjacents.getAdjacent(c).toString());
                }
            }
        }

        private static void secondaryLandProducer_write(Sector s, BufferedWriter writer, Game g) throws IOException {
            SecondaryProducer producer = g.getLandSecondaryProducerManager().getProducer(s);
            if (producer != null) {
                writer.write("BEGIN PRODUCER");
                writer.newLine();

                SecondaryProducerFileVisitor visitor = new SecondaryProducerFileVisitor();
                producer.accept(visitor);

                writer.write(visitor.getInfo().toFileFormat());
                writer.newLine();
            }
        }

        private static void primaryLandProducer_write(Sector s, BufferedWriter writer, Game g) throws IOException {
            PrimaryProducer producer = g.getLandPrimaryProducerManager().getProducer(s);
            if (producer != null) {
                writer.write("BEGIN PRODUCER");
                writer.newLine();

                PrimaryProducerFileVisitor visitor = new PrimaryProducerFileVisitor();
                producer.accept(visitor);

                writer.write(visitor.getInfo().toFileFormat());
                writer.newLine();
            }
        }

        private static void dockedSeaTransporter_write(Sector s, BufferedWriter writer, Game g) throws IOException {
            ArrayList<SeaTransporter> seaThings = g.getSeaTransporterShoreManager().getContentsOfArea(s);

            if (seaThings.size() == 0) {
                return;
            }

            SeaTransporterFileVisitor visitor = new SeaTransporterFileVisitor(g.getCargoManager());

            writer.write("BEGIN DOCKED SEA TRANSPORTER " + seaThings.size());
            writer.newLine();

            for (SeaTransporter transporter :  seaThings){
                transporter.accept(visitor);
                writer.write(visitor.getInfo().toFileFormat());
                writer.newLine();
            }

        }

        private static void resource_write(Sector s, BufferedWriter writer, Game g) throws IOException {
            ResourceFileVisitor visitor = new ResourceFileVisitor();

            int numResources = g.getResourceManager().get(s).size();

            if (numResources == 0) {
                return;
            }

            writer.write("BEGIN RESOURCE " + numResources);
            writer.newLine();

            for (Resource r: g.getResourceManager().get(s)) {
                r.accept(visitor);
                ResourceFileInfo info = visitor.getInfo();
                writer.write(info.toFileFormat());
                writer.newLine();
            }
        }

        private static void landTransporter_write(Sector s, BufferedWriter bf, Game g) throws IOException {
            LandTransporterFileVisitor visitor = new LandTransporterFileVisitor(g.getCargoManager());

            int numTransporters =  s.getTransporters(g.getLandTransporterManager()).size();

            if (numTransporters == 0) {
                return;
            }

            bf.write("BEGIN LAND TRANSPORTER " + numTransporters);
            bf.newLine();
            for (LandTransporter transporter : g.getLandTransporterManager().getContentsOfArea(s) ) {
                transporter.accept(visitor);
                TransporterFileInfo info = (TransporterFileInfo) visitor.getFileInfo();
                bf.write(info.toFileFormat());
                bf.newLine();
            }
        }

        private static void seaTransporter_write(Location loc, BufferedWriter bf, Game g) throws IOException {
            if (g.getActualMap().getWaterwayMap().getTile(loc).getSeaTransporters(g.getSeaTransporterManager()).size() > 0) {
                SeaTransporterFileVisitor visitor = new SeaTransporterFileVisitor(g.getCargoManager());

                int numSeaTransporters = g.getActualMap().getWaterwayMap().getTile(loc).getSeaTransporters(g.getSeaTransporterManager()).size();

                if (numSeaTransporters == 0) {
                    return;
                }

                bf.write("BEGIN SEA TRANSPORTER " + numSeaTransporters);
                bf.newLine();

                for (SeaTransporter transporter : g.getActualMap().getWaterwayMap().getTile(loc).getSeaTransporters(g.getSeaTransporterManager())) {
                    transporter.accept(visitor);
                    bf.write(visitor.getInfo().toFileFormat());
                    bf.newLine();
                }
            }
        }

        /*
        |--------------|
        |MapMaker Stuff|
        |--------------|
         */

        public static void saveMap(HashMap<Location, Tile> map){
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Map");
            fileChooser.setInitialDirectory(new File("Assets/Maps"));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files","*.txt"));
            File saveMap = fileChooser.showSaveDialog(null);
            if(saveMap!=null){
                saveFile(saveMap, map);
            }
        }

        public static HashMap<Location, Tile> loadMap() throws IOException {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Map");
            fileChooser.setInitialDirectory(new File("Assets/Maps"));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Txt Files", "*.txt"));
            File newMap = fileChooser.showOpenDialog(null);
            if(newMap!= null){
                return readFile(newMap);
            } else {
                return null;
            }
        }

        public static HashMap<Location, Tile> loadDefaultMap() throws IOException{
            File newMap = new File("Assets/Maps/default.txt");
            if(newMap!= null){
                return readFile(newMap);
            } else {
                return null;
            }
        }


        /*
        |----------------|
        |-Save Functions-|
        |----------------|
         */
        private static void saveFile(File saveMap, HashMap<Location, Tile> map){
            BufferedWriter writeMap;
            try{
                writeMap = new BufferedWriter(new PrintWriter(saveMap));
                mapWrite(saveMap, map, writeMap);
                writeMap.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        private static void mapWrite(File mapFile, HashMap<Location, Tile> map, BufferedWriter bf) throws IOException {

            TileFileVisitor fileVisitor = new TileFileVisitor();
            for (Location o: map.keySet()) {
                fileVisitor.refresh();
                map.get(o).accept(fileVisitor);

                TileFileInfo tileInfo = fileVisitor.getTileInfo();

                if (tileInfo.getTerrain() == null) {
                    System.out.println("Map write aborted, null terrain!!!");
                    break;
                }

                String writeLine = location_print(o) + " " + tileInfo.toFileFormat();


                bf.write(writeLine);
                bf.newLine();
            }
        }

        private static String location_print(Location l) {
            return "(" + l.getX() + "," + l.getY() + "," + l.getZ() + ")";
        }

        public static String edge_print(ArrayList<HexSide> edges) {
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

        //TODO

        private static String minePrint(MineFileInfo info) {
            String out = "{";
            String spacer = "";

            for (ResourceFileInfo res: info.getRemainingProduct()) {
                out += spacer + res.getResource();
            }

            return out + ")" ;
        }

         /*
        |----------------|
        |-Load Functions-|
        |----------------|
         */

        private static HashMap<Location,Tile> readFile(File newMap) throws IOException {
            HashMap<Location, Tile> out = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(newMap));

            String in = reader.readLine();

            while (in != null) {
                Location l = parseLocation(in);
                //System.out.println("loaded this location");
                Tile t = parseTile(in);
                //System.out.println("Loaded this tile");
                out.put(l, t);
                in = reader.readLine();
            }

            return out;
        }

        private static Tile parseTile(String in) {
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
                //Now we know its a river tile
                River r;
                cur = cur +2;
                String riverBuf = "";
                String[] riverSplit;
                riverBuf = in.substring(in.indexOf('(')+1, in.length()-1);
                if (riverBuf.length() == 1) {
                    riverSplit = new String[]{riverBuf};
                } else {
                    riverSplit = riverBuf.split(" ");
                }


                switch (riverSplit.length) {
                    case 1:
                        r = new SourceRiver(intSide_to_hexSide(Integer.parseInt(riverBuf)));
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
                buf = in.substring(0,in.indexOf(' '));
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

        private static HexSide intSide_to_hexSide(int intSide) {
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

        private static Location parseLocation(String in) {
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
}
