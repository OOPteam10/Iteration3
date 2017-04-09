package model.Managers;

import java.util.HashMap;

/**
 * Created by hankerins on 4/9/17.
 */
public abstract class Adjacency<Dir, AdjLoc> {
    private HashMap<Dir, AdjLoc> managerMap = new HashMap<Dir, AdjLoc>();

    protected HashMap<Dir, AdjLoc> getManagerMap() {
        return managerMap;
    }

    public void add(Dir dir, AdjLoc loc)
    {
        managerMap.put(dir, loc);
    }


    public AdjLoc getAdjacent(Dir d)
    {
        return managerMap.get(d);
    }

    public boolean containsKey(Dir d){
        return managerMap.containsKey(d);
    }
}
