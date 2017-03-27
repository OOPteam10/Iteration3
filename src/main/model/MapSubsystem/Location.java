package model.MapSubsystem;


import javafx.geometry.Point3D;

import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public class Location {
    private int x, y, z;

    public Location(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void addX(int i){
        x += i;
    }
    public void addY(int i){
        y += i;
    }
    public void addZ(int i){
        z += i;
    }

    ArrayList<Location> getAdjacentLocations(){
        ArrayList<Location> adjacents = new ArrayList<Location>();
        adjacents.add(new Location(x+1, y, z));
        adjacents.add(new Location(x-1, y, z));
        adjacents.add(new Location(x, y+1, z));
        adjacents.add(new Location(x, y-1, z));
        adjacents.add(new Location(x, y, z+1));
        adjacents.add(new Location(x, y, z-1));
    return adjacents;
    }
}
