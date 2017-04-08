package model.Occupancies;

import model.Transporters.LandTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/8/17.
 */
public class LandTransporterOccupancy extends Occupancy<LandTransporter> {
    ArrayList<LandTransporter> occupyingTransporters;

    public LandTransporterOccupancy(){
        occupyingTransporters = new ArrayList<LandTransporter>();
    }

    public LandTransporterOccupancy(LandTransporter lt){
        occupyingTransporters = new ArrayList<LandTransporter>();
        occupyingTransporters.add(lt);
    }
    public boolean removeTransporter(LandTransporter t){
        return occupyingTransporters.remove(t);
    }

    public void add(LandTransporter t){
        occupyingTransporters.add(t);
    }

    public boolean contains(LandTransporter target){
        return  occupyingTransporters.contains(target);
    }
}
