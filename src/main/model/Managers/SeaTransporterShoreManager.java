package model.Managers;

import model.TileSubsystem.Sector;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/8/17.
 */
public class SeaTransporterShoreManager extends ListManager<Sector, ArrayList<SeaTransporter>> {

    @Override
    public boolean add(Sector loc, ArrayList<SeaTransporter> occupant) {

        return false;
    }
}
