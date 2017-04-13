package controller;

import controller.MovePhaseControlSubsystem.MovePhaseControl;
import model.Game;
import model.Managers.*;
import model.MapSubsystem.LandMap;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.MapSubsystem.WaterwayMap;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Waterway;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.Transporter;
import model.resources.Board;
import model.resources.Resource;
import model.resources.Stone;
import model.structures.producers.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by hankerins on 4/13/17.
 */
public class MoveControlTest {
    public static void main(String args[]){


        Game game = new Game();
        Map map = game.getActualMap();


        SectorAdjacencyManager sam = game.getSectorAdjacencyManager();
        LandTransporterManager ltm = game.getLandTransporterManager();
        ResourceManager rm = game.getResourceManager();


        Location SDesert = new Location(0,0,0);
        Location SMountain = new Location(0,-1,1);


        //map.formatSurfaceMaps();    //for whatever reason, if this isn't here, then the tile objects in
                                    //the landMap and waterwayMap are different than the ones in the map
        LandMap lm = map.getLandMap();
        WaterwayMap wm = map.getWaterwayMap();


        LandTile lt1 = lm.getTile(SDesert);
        LandTile lt2 = lm.getTile(SMountain);

        ArrayList<Donkey> donkeys = new ArrayList<Donkey>();
        donkeys.add(new Donkey());
        donkeys.add(new Donkey());

        ltm.add(donkeys.get(0), lt1.getSectorAtCardinalDirection(CardinalDirection.NNE));
        ltm.add(donkeys.get(1), lt1.getSectorAtCardinalDirection(CardinalDirection.NNE));
        rm.add(lt1.getSectorAtCardinalDirection(CardinalDirection.NNE), new Stone());
        rm.add(lt1.getSectorAtCardinalDirection(CardinalDirection.NNE), new Board());




        MovePhaseControl mpc = new MovePhaseControl(ltm,  game.getSeaTransporterManager(),
                 sam,  game.getRoadAdjacencyManager(), rm,  game.getCargoManager(), donkeys);

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
                        if(landTransporters.size() > 0){
                            System.out.println(l.toString() + " " + s.toString() + " " + landTransporters.size() + " transporters on land");
                        }
                        if(game.getResourceManager().get(s) != null){
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