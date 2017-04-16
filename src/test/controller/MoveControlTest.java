package controller;

import controller.MovePhaseControlSubsystem.MovePhaseControl;
import model.Game;
import model.Managers.*;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Waterway;
import model.Transporters.*;
import model.resources.Board;
import model.resources.Resource;
import model.resources.Stone;
import model.structures.producers.Product;
<<<<<<< 49c7b91b3661b97d773e1b87d844ea4c6b719ad5
=======
import org.junit.Test;
import view.Camera;
>>>>>>> movement control hooked ,only test left to debug

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by hankerins on 4/13/17.
 */
public class MoveControlTest {
    public static void main(String args[]){


        Game game = new Game();
        Map map = game.getActualMap();

        Camera camera = new Camera(new Point(1600,900), 1600,900);
        SectorAdjacencyManager sam = game.getSectorAdjacencyManager();
        WaterwayAdjacencyManager wam = game.getWaterwayAdjacencyManager();
        LandTransporterManager ltm = game.getLandTransporterManager();
        SeaTransporterManager stm = game.getSeaTransporterManager();
        SeaTransporterShoreManager stsm = game.getSeaTransporterShoreManager();
        ResourceManager rm = game.getResourceManager();

        SectorAdjacencyManager roadAdjacencyManager = game.getRoadAdjacencyManager();

        WaterwayToSectorManager wtsm = map.generateWaterwayToSectorManager();
        SectorToWaterwayManager stwm = map.generateSectorToWaterwayManager();



        Location SDesert = new Location(0,0,0);
        Location SMountain = new Location(0,-1,1);
        Location NEOfDesert = new Location(1, 0, -1);


        //map.formatSurfaceMaps();    //for whatever reason, if this isn't here, then the tile objects in
                                    //the landMap and waterwayMap are different than the ones in the map
        LandMap lm = map.getLandMap();
        WaterwayMap wm = map.getWaterwayMap();


        LandTile lt1 = lm.getTile(SDesert);
        LandTile lt2 = lm.getTile(SMountain);
        LandTile lt1RoadTarget = lm.getTile(NEOfDesert);
        Waterway wy1 = wm.getTile(SDesert);
        ArrayList<Donkey> donkeys = new ArrayList<Donkey>();
        donkeys.add(new Donkey());
        donkeys.add(new Donkey());

        ArrayList<RoadTransporter> roadTransporters = new ArrayList<RoadTransporter>();
        roadTransporters.add(new Truck());

        Raft raft1 = new Raft(); //on land

        ArrayList<SeaTransporter> seaTransportersAtSea = new ArrayList<SeaTransporter>();
        Raft raft2 = new Raft();
        Raft raft3 = new Raft();
        seaTransportersAtSea.add(raft2);
        seaTransportersAtSea.add(raft3);
        seaTransportersAtSea.add(raft1);

        ltm.add(donkeys.get(0), lt1.getSectorAtCardinalDirection(CardinalDirection.NNE));
        ltm.add(donkeys.get(1), lt1.getSectorAtCardinalDirection(CardinalDirection.NNE));
        rm.add(lt1.getSectorAtCardinalDirection(CardinalDirection.NNE), new Stone());
        rm.add(lt1.getSectorAtCardinalDirection(CardinalDirection.NNE), new Board());

        ltm.add(roadTransporters.get(0), lt1.getSectorAtCardinalDirection(CardinalDirection.NNE));

        stsm.add(raft1, lt1.getSectorAtCardinalDirection(CardinalDirection.NNE));

        stm.add(seaTransportersAtSea.get(0), wy1);
        stm.add(seaTransportersAtSea.get(1), wy1);

        //making a road
        SectorAdjacency road1 = new SectorAdjacency();
        CardinalDirection roadCD1 = CardinalDirection.NE;
        road1.add(roadCD1, lt1RoadTarget.getSectorAtCardinalDirection(roadCD1.getOppositeSide()));
        roadAdjacencyManager.add(lt1.getSectorAtCardinalDirection(CardinalDirection.NE), road1);
        




        MovePhaseControl mpc = new MovePhaseControl(game);
        mpc.addDonkeyMPCMode();
        mpc.addRoadTransporterMPCMode();
        mpc.addSeaTransporterMPCMode();

     



        while(true){
            debugMenu(mpc, game);
        }
    }

    static void debugMenu(MovePhaseControl mpc, Game game){
        Map map = game.getActualMap();
        Scanner in = new Scanner(System.in);
        int input = 0;
        System.out.println("0: prevMode    1: nextMode    2: select\n" +
                "3: Instruction/Target Left    4: Instruction/Target Right\n" +
                "5: prevTransporter    6: nextTransporter    7: Print\n");
        input = in.nextInt();
        switch(input){
            case 0:
                mpc.left();
                break;
            case 1:
                mpc.right();
                break;
            case 2:
                mpc.select();
                break;
            case 3:
                mpc.moveNW();
                break;
            case 4:
                mpc.moveN();
                break;
            case 5:
                mpc.moveSW();
                break;
            case 6:
                mpc.moveS();
                break;
            case 7:
                for(Location l: map.getMap().keySet()){
                    for(Sector s: map.getMap().get(l).getSectors()){
                        ArrayList<LandTransporter> landTransporters = game.getLandTransporterManager().getContentsOfArea(s);
                        ArrayList<SeaTransporter> seaTransporters = game.getSeaTransporterShoreManager().getContentsOfArea(s);
                        if(landTransporters.size() > 0){
                            System.out.println(l.toString() + " " + s.toString() + " " + landTransporters.size() + " transporters on land");
                        }
                        if(seaTransporters.size() > 0){
                            System.out.println(l.toString() + " " + s.toString() + " " + seaTransporters.size() + " boats on land");
                        }

                        if(game.getResourceManager().get(s).size() > 0){
                            System.out.print(l.toString() + " " + s.toString() + " ");
                            for(Resource r: game.getResourceManager().get(s)){
                                System.out.print(r.toString() + " ");
                            }
                            System.out.print("\n");
                        }
                    }
                }
                System.out.println("Cargo:");
                for(Transporter t: game.getCargoManager().getManagerMap().keySet()){
                    ArrayList<Product> cargo = game.getCargoManager().get(t);
                    System.out.print(t.toString() + " has ");
                    for(Product p: cargo){
                        System.out.print(p.toString() + " ");
                    }
                    System.out.print("\n");
                }
                break;

        }
        System.out.println(mpc.toString());

    }
}
