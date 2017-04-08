package model.Managers;

import model.Occupancies.LandTransporterOccupancy;
import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;

/**
 * Created by hankerins on 4/8/17.
 * if we have an empty Occupancy object for each sector it fixes OOP problems here,
 * but it could make building the controls harder
 */
public class LandTransporterOccupancyManager extends OccupancyManager<Sector, LandTransporter> {

    public boolean removeTransporter(LandTransporter t, Sector s){
        return get(s).removeTransporter(t);  //get(s) may return null, how to avoid?
    }

}
