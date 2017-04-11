package model.TileSubsystem;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/8/17.
 */
public interface Waterway {
    public abstract ArrayList<HexSide> getWaterwaySides();
    public abstract boolean contains(HexSide hs);
}
