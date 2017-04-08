package model.Managers;

import java.util.Map.*;

import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 * TODO: separate list managers and object managers
 */
public abstract class Manager<T1, T2>{
    private HashMap<T1, T2> managerMap;

    protected HashMap<T1, T2> getManagerMap() {
        return managerMap;
    }

    public boolean add(T1 loc, T2 occupant){
        managerMap.put(loc, occupant);
    };

    public void removeOccupant(T2 occupant){
        for(T1 each: managerMap.keySet()){
            managerMap.remove(each, occupant);
        }
    }

    public T2 get(T1 loc)
    {
        return managerMap.get(loc);
    }

    public boolean containsKey(T1 key){
        return managerMap.containsKey(key);
    }

    public T1 findLocationOfOccupant(T2 target){
        for(Entry<T1, T2> each: managerMap.entrySet()){
            if(each.getValue() == target){ //CANT USE LISTS WITH THIS, SEPARATE ENTRY FOR EACH OBJECT IN MANAGER
                return each.getKey();
            }
        }
        return null; //not found
    }

}
