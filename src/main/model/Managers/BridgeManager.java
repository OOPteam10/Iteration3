package model.Managers;

import model.TileSubsystem.Sector;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kevin on 4/16/17.
 */

public class BridgeManager {

    private HashMap<Sector, Sector> bridgedSectors = new HashMap<>();
    private HashMap<Sector, Sector> doubleBridgedSectors = new HashMap<>();

    public void addBridge(Sector sector1, Sector sector2){

        Sector sector3 = null;

        if(bridgedSectors.containsKey(sector1)){

            sector3 = bridgedSectors.get(sector1);

            bridgedSectors.put(sector2, sector1);

            doubleBridgedSectors.put(sector1, sector2);
            doubleBridgedSectors.put(sector2, sector3);
            doubleBridgedSectors.put(sector3, sector2);

        }else if(bridgedSectors.containsKey(sector2)){

            sector3 = bridgedSectors.get(sector2);

            bridgedSectors.put(sector1, sector2);

            doubleBridgedSectors.put(sector1, sector3);
            doubleBridgedSectors.put(sector2, sector1);
            doubleBridgedSectors.put(sector3, sector1);

        }else{

            bridgedSectors.put(sector1, sector2);
            bridgedSectors.put(sector2, sector1);
        }

    }

    public ArrayList<Sector> getConnectedSectors(Sector s){

        ArrayList<Sector> arr = new ArrayList<>();

        arr.add(s);

        if(bridgedSectors.containsKey(s)){

            arr.add(bridgedSectors.get(s));
        }

        if(doubleBridgedSectors.containsKey(s)){

            arr.add(bridgedSectors.get(s));
        }

        return arr;
    }

}
