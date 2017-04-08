package model.Managers;

import java.util.Map.*;
import model.Occupancies.Occupancy;

import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class OccupancyManager<T1, T2>{
    private HashMap<T1, Occupancy<T2>> managerMap;
    

    public void add(T1 loc, T2 occupant)
    {

        managerMap.get(loc).add(occupant);
    }
    public void remove(T2 occupant){
        //todo
    }

    public Occupancy<T2> get(T1 loc)
    {
        return managerMap.get(loc);
    }

    public boolean containsKey(T1 key){
        return managerMap.containsKey(key);
    }

    public T1 find(T2 target){
        for(Entry<T1, Occupancy<T2>> each: managerMap.entrySet()){
            if(each.getValue().contains(target)){
                return each.getKey();
            }
        }
        return null; //not found
    }

}
