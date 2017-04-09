package model.Managers;

import java.util.ArrayList;
import java.util.Map.*;

import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 * TODO: separate list managers and object managers
 */
public abstract class ListManager<T1, T2>{
    private HashMap<T1, ArrayList<T2>> managerMap = new HashMap<T1, ArrayList<T2>>();

    protected HashMap<T1, ArrayList<T2>> getManagerMap() {
        return managerMap;
    }

    public boolean add(T1 loc, T2 occupant)
    {
        if(managerMap.containsKey(loc)){
            managerMap.get(loc).add(occupant);
        }
        else{
            ArrayList<T2> newList = new ArrayList<T2>();
            newList.add(occupant);
            managerMap.put(loc, newList);
        }
        return true;
    }

    public void removeOccupant(T2 occupant){
        for(ArrayList<T2> each: managerMap.values()){
            each.remove(occupant);
            //TODO: do we need to delete empty lists? probably
        }
    }

    public ArrayList<T2> get(T1 loc)
    {
        return managerMap.get(loc);
    }

    public boolean containsKey(T1 key){
        return managerMap.containsKey(key);
    }

    public T1 findLocationOfOccupant(T2 target){
        for(Entry<T1, ArrayList<T2>> each: managerMap.entrySet()){
            if(each.getValue().contains(target)){
                return each.getKey();
            }
        }
        return null; //not found
    }

}
