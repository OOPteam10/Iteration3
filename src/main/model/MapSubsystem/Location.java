package model.MapSubsystem;


import javafx.geometry.Point3D;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by hankerins on 3/26/17.
 * Q4D: Point3d (and many others) use instanceof in their equals(), so can we?
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

    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getZ(){return this.z;}

    public boolean equals(Object o)
    {
        if(!(o instanceof Location))
        {
            return false;
        }

        Location target = (Location)o;
        return x == target.x && y == target.y && z == target.z;
    }

    public int hashCode(){
        return Objects.hash(x, y, z);
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

    //For debugging only
    public String toString(){
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
