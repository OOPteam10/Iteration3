package model.MapSubsystem;

import model.TileSubsystem.HexSide;

import java.util.*;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public class LocationUtility {

    private static final java.util.HashMap<HexSide, LocationMovementCommand> hexIncrements;
    static {
        hexIncrements = new java.util.HashMap<HexSide, LocationMovementCommand>();
        hexIncrements.put(HexSide.N, new GoNorthCommand());
        hexIncrements.put(HexSide.NE, new GoNorthEastCommand());
        hexIncrements.put(HexSide.NW, new GoNorthWestCommand());
        hexIncrements.put(HexSide.S, new GoSouthCommand());
        hexIncrements.put(HexSide.SE, new GoSouthEastCommand());
        hexIncrements.put(HexSide.SW, new GoSouthWestCommand());
    }
    public static Location getAdjacentLocationFromHexSide(Location thisLocation, HexSide hs) {
        hexIncrements.get(hs).configureLocation(thisLocation);
        return hexIncrements.get(hs).execute();
    }
}
