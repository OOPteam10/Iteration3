package model.Managers;

import java.util.Map.*;
import model.Occupancies.Occupancy;

import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class Manager<T1, T2>{
    private HashMap<T1, Occupancy<T2>> managerMap;
    public void remove(T1 t1)
    {
        managerMap.remove(t1);
    }

    public void add(T1 loc, T2 occupier)
    {

        managerMap.get(loc).add(occupier);
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
