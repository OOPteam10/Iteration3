package model.Managers;

import model.TileSubsystem.Sector;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 * for a SectorResourceManager, Loc = Sector or OilRig, GoodsType is a Resource
 * for CargoManager, Loc = Transporter, GoodsType = cargo
 * this works best if a player has to drop their resources before building,
 * otherwise we need a cargo manager for every resource type (doable)
 *
 * this version requires a GoodsManager for each resource type.  I think
 *
 * gonna use a generic GoodsManager<Sector, Resource>,
 *
 * examples at bottom
 */
public class GoodsManager<Loc, GoodsType> {
    private HashMap<Loc, ArrayList<GoodsType>> managerMap = new HashMap<Loc, ArrayList<GoodsType>>();

    public HashMap<Loc, ArrayList<GoodsType>> getManagerMap() {
        return managerMap;
    }

    protected void add(Loc l) {
        managerMap.put(l, new ArrayList<GoodsType>());
    }

    public void add(Loc l, GoodsType r) {
        if(managerMap.get(l) == null)
            add(l);
        managerMap.get(l).add(r);
    }

    public void remove(Loc l, GoodsType g){

            managerMap.get(l).remove(g);

    }

    public ArrayList<GoodsType> get(Loc l){
        return managerMap.get(l);
    }

    public GoodsType pop(Loc l){
        return managerMap.get(l).remove(managerMap.size()-1);
    }

    public int getQuantityInArea(Loc l){
        if(managerMap.get(l) != null){
            return managerMap.get(l).size();
        }
        else return 0;
    }



    //GoodsManager<Transporter, Cargo> CargoManager = new GoodsManager<Transporter, Product>();
    //GoodsManager<OilRig, Resource> OilRigResourceManager = new GoodsManager<OilRig, Resource>();
    //GoodsManager<Sector, Stone> StoneManager = new GoodsManager<Sector, Stone>();
    //GoodsManager<Sector, Wood> WoodManager = new GoodsManager<Sector, Wood>(); //etc.

}
