package model.TileSubsystem;

import model.Managers.SeaTransporterManager;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/8/17.
 */
public interface Waterway {
    ArrayList<HexSide> getWaterwaySides();
    boolean contains(HexSide hs);
    ArrayList<SeaTransporter> getSeaTransporters(SeaTransporterManager stm);
}
