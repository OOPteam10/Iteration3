package model.Managers;

import model.Managers.Visitor.RoadDrawingVisitor;
import model.Managers.Visitor.RoadVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by hankerins on 4/9/17.
 */
public abstract class Adjacency<Dir, AdjLoc> {
    private HashMap<Dir, AdjLoc> managerMap = new HashMap<Dir, AdjLoc>();

    public Set<Dir> getDirections(){
        return managerMap.keySet();
    }

    protected HashMap<Dir, AdjLoc> getManagerMap() {
        return managerMap;
    }

    public void add(Dir dir, AdjLoc loc)
    {
        managerMap.put(dir, loc);
    }

    public void accept(RoadVisitor v){
        v.visitRoad();
    }

    public AdjLoc getAdjacent(Dir d)
    {
        return managerMap.get(d);
    }

    public ArrayList<AdjLoc> getAdjacencyList(){
        ArrayList<AdjLoc> arr = new ArrayList<AdjLoc>();
        for(AdjLoc a: managerMap.values()){
            arr.add(a);
        }
        return arr;
    }

    public ArrayList<Dir> getDirectionList(){

        ArrayList<Dir> arr = new ArrayList<Dir>();

        for(Dir d: managerMap.keySet()){
            arr.add(d);
        }

        return arr;
    }

    public Dir getDirectionOfAdjacentLoc(AdjLoc al){

        for(Dir d: managerMap.keySet()){
            if(managerMap.get(d) == al){

                return d;
            }
        }

        return null;
    }

    public boolean containsKey(Dir d){
        return managerMap.containsKey(d);
    }

    //Testing

    public String toString(){
        String s = "";
        for(Dir d: managerMap.keySet()){
            s += (d.toString() + ": " + managerMap.get(d).toString() + "\n");
        }
        return s;
    }

}
