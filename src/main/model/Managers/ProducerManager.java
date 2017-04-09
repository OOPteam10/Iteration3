package model.Managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class ProducerManager<T1, T2>{
    private HashMap<T1, T2> managerMap = new HashMap<T1, T2>();

    protected HashMap<T1, T2> getManagerMap() {
        return managerMap;
    }

    public boolean add(T1 loc, T2 occupant) //TODO: make this fail when producers exist in other sectors
            //TODO: remove conditional logic when abilities are in place
    {
        if(managerMap.containsKey(loc)){
            return false;
        }
        else{
            managerMap.put(loc, occupant);
        }
        return true;
    }

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
        for(Map.Entry<T1, T2> each: managerMap.entrySet()){
            if(each.getValue() == target){
                return each.getKey();
            }
        }
        return null; //not found
    }
}
