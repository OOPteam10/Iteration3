package model.Managers;

import model.TileSubsystem.Sector;
import model.Transporters.Transporter;

/**
 * Created by hankerins on 4/13/17.
 */
public class SectorTransporterManager<T extends Transporter> extends TransporterManager<T, Sector> {
    @Override
    public Sector getLocation(T o) {
        return super.getLocation(o);
    }
}
