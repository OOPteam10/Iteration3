package model.Managers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class TransporterManager<Obj, Loc>{
    private HashMap<Obj, Loc> managerMap = new HashMap<Obj, Loc>();

    public HashMap<Obj, Loc> getManagerMap() {
        return managerMap;
    }

    public void add(Obj o, Loc loc) {
        managerMap.put(o, loc);
    }

    public void removeOccupant(Obj o){
        managerMap.remove(o);
    }

    public Loc getLocation(Obj o)
    {
        return managerMap.get(o);
    }

    public boolean containsKey(Obj o){
        return managerMap.containsKey(o);
    }

    public ArrayList<Obj> getContentsOfArea(Loc l){
        ArrayList<Obj> contents = new ArrayList<Obj>();
        for (Obj o: managerMap.keySet()){
            if(managerMap.get(o) == l){
                contents.add(o);
            }
        }
        return contents;
    }

    public void move(Obj o, Loc newLoc){
        removeOccupant(o);
        add(o, newLoc);
    }


}
