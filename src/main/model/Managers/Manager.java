package model.Managers;

import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class Manager<Obj, Loc>{
    private HashMap<Obj, Loc> managerMap = new HashMap<Obj, Loc>();

    protected HashMap<Obj, Loc> getManagerMap() {
        return managerMap;
    }

    public void add(Obj o, Loc loc) //TODO: make this fail when producers exist in other sectors
            //TODO: remove conditional logic when abilities are in place
    {
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

}
