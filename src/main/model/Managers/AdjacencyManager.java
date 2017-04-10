package model.Managers;

import java.util.HashMap;

/**
 * Created by hankerins on 4/9/17.
 */
public abstract class AdjacencyManager<Loc, Dir, AdjLoc> {

    private HashMap<Loc, Adjacency<Dir, AdjLoc>> managerMap = new HashMap<Loc, Adjacency<Dir, AdjLoc>>();

    protected HashMap<Loc, Adjacency<Dir, AdjLoc>> getManagerMap() {
        return managerMap;
    }

    public void add(Loc loc, Adjacency<Dir, AdjLoc> newAdjacency){
        managerMap.put(loc, newAdjacency);
    }

    //TESTING ONLY

    public String toString(){
        String s = "";
        for(Loc l: managerMap.keySet()){
            s += ("Starting Sector: " + l.toString() + ": " + managerMap.get(l).toString() + "\n----------\n");
        }
        return s;
    }
}
