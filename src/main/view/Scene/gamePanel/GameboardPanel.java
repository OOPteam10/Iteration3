package view.Scene.gamePanel;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import model.Game;
import model.Managers.*;
import model.Managers.Visitor.RoadDrawingVisitor;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.Tile;
import model.TileSubsystem.Visitor.TileDrawingVisitor;
import model.Transporters.*;
import model.Transporters.Visitor.LandTransporterDrawingVisitor;
import model.Transporters.Visitor.SeaTransporterDrawingVisitor;
import model.Transporters.Visitor.SeaTransporterShoreDrawingVisitor;
import model.resources.*;
import model.resources.Visitor.ResourceDrawingVisitor;
import model.structures.producers.Producer;
import model.structures.producers.Visitor.PrimaryProducerDrawingVisitor;
import model.structures.producers.Visitor.SecondaryProducerDrawingVisitor;
import model.structures.producers.primary.*;
import model.structures.producers.primary.mine.Mine;
import model.structures.producers.secondary.refinement.*;
import model.structures.producers.secondary.transportation.*;
import utilities.TileEditor;
import view.Camera;
import view.Panel;
import view.PanelManager;
import view.ViewEnum;
import view.assets.AssetManager;

import javax.smartcardio.Card;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by Karth on 4/5/2017.
 */
public class GameboardPanel extends Panel {

    private PanelManager panelManager;
    private Map gameMap;
    private WaterwayMap waterwayMap;
    private LandMap landMap;
    private HashMap<Location, Tile> gameBoard;
    private AssetManager assets;
    private Camera camera;
    private Game game;
    private Group root;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private LandPrimaryProducerManager landPrimaryProducerManager;
    private LandSecondaryProducerManager landSecondaryProducerManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private ResourceManager resourceManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private Transporter currentTransporter;

    public GameboardPanel(Game game, AssetManager assets, ViewEnum gameMode, Group root, Camera camera, PanelManager panelManager){
        super(game, assets, gameMode);
        this.game = game;
        this.assets = assets;
        this.root = root;
        this.camera = camera;
        this.panelManager = panelManager;
        landTransporterManager = game.getLandTransporterManager();
        seaTransporterManager = game.getSeaTransporterManager();
        resourceManager = game.getResourceManager();
        landPrimaryProducerManager = game.getLandPrimaryProducerManager();
        landSecondaryProducerManager = game.getLandSecondaryProducerManager();
        seaTransporterShoreManager = game.getSeaTransporterShoreManager();
        roadAdjacencyManager = game.getRoadAdjacencyManager();
        currentTransporter = game.getCurrentTransporter();
        updateGameMap();
        addEntities();
    }

    //TODO: this is a test function, delete it after
    private void addEntities() {
//        Donkey dq = new Donkey();
//        Location l = new Location(0,0,0);
//        game.getActualMap().formatSurfaceMaps();
//        LandTile lt1 = game.getActualMap().getLandMap().getTile(l);
//        System.out.println(lt1);
//        landTransporterManager.add(dq, lt1.getSectorAtCardinalDirection(CardinalDirection.NE));

        Donkey dq = new Donkey();
        Wagon dq2 = new Wagon();
        Donkey dq3 = new Donkey();
        Donkey dq4 = new Donkey();
        Wagon dq5 = new Wagon();
        Truck dq6 = new Truck();
        Wagon dq7 = new Wagon();
        Truck dq8 = new Truck();
        landTransporterManager.add(dq, gameMap.getTile(new Location(0, 0, 0)).getSectorAtCardinalDirection(CardinalDirection.NE));
        landTransporterManager.add(dq2, gameMap.getTile(new Location(0, 0, 0)).getSectorAtCardinalDirection(CardinalDirection.SSE));
        landTransporterManager.add(dq3, gameMap.getTile(new Location(-1, 0, 1)).getSectorAtCardinalDirection(CardinalDirection.NNE));
        landTransporterManager.add(dq4, gameMap.getTile(new Location(-1, 1, 0)).getSectorAtCardinalDirection(CardinalDirection.SSE));
        landTransporterManager.add(dq5, gameMap.getTile(new Location(-1, 3, -2)).getSectorAtCardinalDirection(CardinalDirection.SSE));
        landTransporterManager.add(dq6, gameMap.getTile(new Location(1, 1, -2)).getSectorAtCardinalDirection(CardinalDirection.NW));
        landTransporterManager.add(dq7, gameMap.getTile(new Location(2, 1, -3)).getSectorAtCardinalDirection(CardinalDirection.SSW));
        landTransporterManager.add(dq8, gameMap.getTile(new Location(2, 1, -3)).getSectorAtCardinalDirection(CardinalDirection.ENE));

        Raft st1 = new Raft();
        Steamship st2 = new Steamship();
        Rowboat st3 = new Rowboat();
        Steamship st4 = new Steamship();
        Steamship st5 = new Steamship();

        seaTransporterManager.add(st1, waterwayMap.getTile(new Location(0,0,0)));
        seaTransporterManager.add(st2, waterwayMap.getTile(new Location(0,1,-1)));
        seaTransporterManager.add(st3, waterwayMap.getTile(new Location(1,1,-2)));
        seaTransporterManager.add(st5, waterwayMap.getTile(new Location(-1,1,0)));
        seaTransporterShoreManager.add(st4, gameMap.getTile(new Location(0,0,0)).getSectorAtCardinalDirection(CardinalDirection.ENE));

        Gold r1 = new Gold();
        Board r2 = new Board();
        Clay r3 = new Clay();
        Coin r4 = new Coin();
        Fuel r5 = new Fuel();

        resourceManager.add(gameMap.getTile(new Location(0,0,0)).getSectorAtCardinalDirection(CardinalDirection.NE), r1);
        resourceManager.add(gameMap.getTile(new Location(0, 0, 0)).getSectorAtCardinalDirection(CardinalDirection.SSE),r2);
        resourceManager.add(gameMap.getTile(new Location(-1, 0, 1)).getSectorAtCardinalDirection(CardinalDirection.NNE),r3);
        resourceManager.add(gameMap.getTile(new Location(-1, 1, 0)).getSectorAtCardinalDirection(CardinalDirection.SSE),r4);
        resourceManager.add(gameMap.getTile(new Location(-1, 3, -2)).getSectorAtCardinalDirection(CardinalDirection.SSE),r5);

        ClayPit pp1 = new ClayPit(resourceManager);
        OilRig pp2 = new OilRig(resourceManager);
        StoneQuarry pp3 = new StoneQuarry(resourceManager);
        WoodCutter pp4 = new WoodCutter(resourceManager);
        //Mine
        landPrimaryProducerManager.add(gameMap.getTile(new Location(1,2,-3)).getSectorAtCardinalDirection(CardinalDirection.NE), pp1);
        landPrimaryProducerManager.add(gameMap.getTile(new Location(0,0,0)).getSectorAtCardinalDirection(CardinalDirection.NE), pp2);
        landPrimaryProducerManager.add(gameMap.getTile(new Location(1,0,-1)).getSectorAtCardinalDirection(CardinalDirection.NE), pp3);
        landPrimaryProducerManager.add(gameMap.getTile(new Location(-1,0,1)).getSectorAtCardinalDirection(CardinalDirection.NE), pp4);



        RaftFactory sp1 = new RaftFactory(resourceManager,seaTransporterShoreManager);
        CoalBurner sp2 = new CoalBurner(resourceManager);
        Mint sp3 = new Mint(resourceManager);
        RowboatFactory sp4 = new RowboatFactory(resourceManager, seaTransporterShoreManager);
        SawMill sp5 = new SawMill(resourceManager);
        SteamerFactory sp6 = new SteamerFactory(resourceManager, seaTransporterShoreManager);
        StockExchange sp7 = new StockExchange(resourceManager);
        StoneFactory sp8 = new StoneFactory(resourceManager);
        TruckFactory sp9 = new TruckFactory(resourceManager, landTransporterManager);
        WagonFactory sp10 = new WagonFactory(resourceManager, landTransporterManager);
        PaperMill sp11 = new PaperMill(resourceManager);


        landSecondaryProducerManager.add(gameMap.getTile(new Location(-1,0,1)).getSectorAtCardinalDirection(CardinalDirection.NE), sp1);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(1,-1,0)).getSectorAtCardinalDirection(CardinalDirection.NE), sp2);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(2,-1,-1)).getSectorAtCardinalDirection(CardinalDirection.NE), sp3);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(3,-1,-2)).getSectorAtCardinalDirection(CardinalDirection.NE), sp4);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(4,-3,-1)).getSectorAtCardinalDirection(CardinalDirection.NE), sp5);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(-3,4,-1)).getSectorAtCardinalDirection(CardinalDirection.NE), sp6);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(-4,4,0)).getSectorAtCardinalDirection(CardinalDirection.NE), sp7);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(-2,4,-2)).getSectorAtCardinalDirection(CardinalDirection.NE), sp8);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(-1,2,-1)).getSectorAtCardinalDirection(CardinalDirection.NE), sp9);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(0,2,-2)).getSectorAtCardinalDirection(CardinalDirection.NE), sp10);
        landSecondaryProducerManager.add(gameMap.getTile(new Location(-2,2,0)).getSectorAtCardinalDirection(CardinalDirection.NE), sp11);

    }

    private void updateGameMap(){
        gameMap = game.getActualMap();
        waterwayMap = gameMap.getWaterwayMap();
        landMap = gameMap.getLandMap();
        gameBoard = gameMap.getMap();
    }

    private void drawBackground(GraphicsContext gc){
        for (int i=-10;i<11;i++){
            for(int j=-10;j<11;j++){
                Point p = new Point(i,j);
                if((i+j)>= - 10 && (i+j)<=10) {
                    gc.drawImage(assets.getImage("EMPTY_HEX_GRID"), camera.offset(p).x, camera.offset(p).y, camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getWidth(),
                            camera.getScale() * assets.getImage("EMPTY_HEX_GRID").getHeight());
                }
            }
        }
    }

    private void drawTileSelector(GraphicsContext gc){
        Point p = new Point();
        p.x = TileEditor.getInstance().getLocation().getX();
        p.y = TileEditor.getInstance().getLocation().getY();
        gc.drawImage(assets.getImage("TILE_SELECTOR"), camera.offset( p).x, camera.offset( p).y,camera.getScale() * assets.getImage("TILE_SELECTOR").getWidth(),
                camera.getScale() * assets.getImage("TILE_SELECTOR").getHeight());
    }

    private void drawGameboard(GraphicsContext gc){
        for(Location loc:gameBoard.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            TileDrawingVisitor tileDrawingVisitor = new TileDrawingVisitor(assets, gc,p,camera);

            /**
             * Draw (Land)Transporters
             */
            gameBoard.get(loc).accept(tileDrawingVisitor);
        }
    }

    private void drawLandTransporters(GraphicsContext gc){
        for(Location loc:gameBoard.keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            for(Sector sector:gameBoard.get(loc).getSectors()){
                for(LandTransporter transporter:sector.getTransporters(landTransporterManager)){
                    LandTransporterDrawingVisitor v = new LandTransporterDrawingVisitor(assets, gc, p, camera, sector);
                    transporter.accept(v);
                }
            }
        }
    }

    private void drawSeaTransporters(GraphicsContext gc){
        for(Location loc:waterwayMap.getSurfaces().keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            for(SeaTransporter transporter: seaTransporterManager.getContentsOfArea(waterwayMap.getTile(loc))){
                SeaTransporterDrawingVisitor v = new SeaTransporterDrawingVisitor(assets, gc, p, camera);
                transporter.accept(v);
            }
        }
    }

    private void drawResources(GraphicsContext gc){
        for(Location loc:landMap.getSurfaces().keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
                for (Sector sector : landMap.getTile(loc).getSectors()) {
                    for (Resource resource : resourceManager.get(sector)) {
                        ResourceDrawingVisitor v = new ResourceDrawingVisitor(assets, gc, p, camera, sector);
                        resource.accept(v);
                    }
                }
        }
    }

    private void drawRoad(GraphicsContext gc){
        for(Location loc:landMap.getSurfaces().keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            for (Sector sector : landMap.getTile(loc).getSectors()) {
                Adjacency<CardinalDirection, Sector> adj = roadAdjacencyManager.getAdjacency(sector);
                if(adj != null){
                    for(CardinalDirection cd: adj.getDirections()){
                        RoadDrawingVisitor v = new RoadDrawingVisitor(assets, gc, p, camera, cd.getDegree());
                        adj.accept(v);
                    }
                }
            }
        }
    }

    private void drawPrimaryProducers(GraphicsContext gc){
        for(Location loc:landMap.getSurfaces().keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            for(Sector sector:landMap.getTile(loc).getSectors()){
                PrimaryProducerDrawingVisitor v = new PrimaryProducerDrawingVisitor(assets, gc, p, camera, sector);
                if(landPrimaryProducerManager.getProducer(sector) != null) {
                    landPrimaryProducerManager.getProducer(sector).accept(v);
                }
            }
        }
    }

    private void drawSeaTransporterOnShore(GraphicsContext gc){
        for(Location loc:landMap.getSurfaces().keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            for(Sector sector:landMap.getTile(loc).getSectors()){
                for(SeaTransporter transporter:seaTransporterShoreManager.getContentsOfArea(sector)){
                    SeaTransporterShoreDrawingVisitor v = new SeaTransporterShoreDrawingVisitor(assets, gc, p, camera, sector);
                    transporter.accept(v);
                }
            }
        }
    }

    private void drawSecondaryProducer(GraphicsContext gc){
        for(Location loc:landMap.getSurfaces().keySet()){
            Point p = new Point();
            p.x = loc.getX();
            p.y = loc.getY();
            for(Sector sector:landMap.getTile(loc).getSectors()){
                SecondaryProducerDrawingVisitor v = new SecondaryProducerDrawingVisitor(assets, gc, p, camera, sector);
                if(landSecondaryProducerManager.getProducer(sector)!=null){
                    landSecondaryProducerManager.getProducer(sector).accept(v);
                }
            }
        }
    }

    public void draw(GraphicsContext gc, Point screenDimension){
        drawBackground(gc);
        drawGameboard(gc);
        drawTileSelector(gc);
        drawRoad(gc);
        drawLandTransporters(gc);
        drawSeaTransporters(gc);
        drawSeaTransporterOnShore(gc);
        drawPrimaryProducers(gc);
        drawSecondaryProducer(gc);
        drawResources(gc);
        updateGameMap();
    }

    public void showGUIElements(){

    }

    public void hideGUIElements(){

    }
}
