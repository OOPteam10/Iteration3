package model.Managers;

import java.util.ArrayList;
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

    public Adjacency<Dir, AdjLoc> getAdjacency(Loc l){
        return managerMap.get(l);
    }
    public ArrayList<AdjLoc> getAdjacencyList(Loc l){
        if(managerMap.get(l) != null){
            return managerMap.get(l).getAdjacencyList();

        }
        else return new ArrayList<AdjLoc>();
    }

    public Dir getDirectionOfAdjacentLoc(Loc l, AdjLoc al){

        return managerMap.get(l).getDirectionOfAdjacentLoc(al);

    }

    //TESTING ONLY

    public String toString(){
        String s = "";
        for(Loc l: managerMap.keySet()){
            s += ("Starting Loc: " + l.toString() + ": " + managerMap.get(l).toString() + "\n----------\n");
        }
        return s;
    }
}
