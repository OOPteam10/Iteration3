package model.MapSubsystem;

import java.util.HashMap;

/**
 * Created by hankerins on 4/10/17.
 */
public abstract class SurfaceMap<T> {
    private HashMap<Location, T> surfaces = new HashMap<Location, T>();

    public void add(Location l, T t){
        surfaces.put(l, t);
    }

    protected HashMap<Location, T> getSurfaces(){
        return surfaces;
    }

    public T getTile(Location l){
        return surfaces.get(l);
    }


    public String toString(){
        String s = "";
        for(Location l: surfaces.keySet()){
            s += (l.toString() + ": " + surfaces.get(l).toString() + "\n");
        }
        return s;
    }
}
