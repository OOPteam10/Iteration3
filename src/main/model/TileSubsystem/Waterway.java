package model.TileSubsystem;

import model.Managers.SeaTransporterManager;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/8/17.
 */
public interface Waterway {
    public abstract ArrayList<HexSide> getWaterwaySides();
    public abstract boolean contains(HexSide hs);
    public ArrayList<SeaTransporter> getSeaTransporters(SeaTransporterManager stm);
}
