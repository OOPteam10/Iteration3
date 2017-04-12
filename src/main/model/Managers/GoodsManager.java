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
 * gonna use a generic GoodsManager<Sector, Resource>, <Waterway, Resource>,
 *
 * examples at bottom
 */
public class GoodsManager<Loc, GoodsType> {
    private HashMap<Loc, ArrayList<GoodsType>> managerMap = new HashMap<Loc, ArrayList<GoodsType>>();

    protected HashMap<Loc, ArrayList<GoodsType>> getManagerMap() {
        return managerMap;
    }

    public void add(Loc l, GoodsType r)
            //This method assumes a HashMap entry for every Sector/Transporter,
            // with empty lists for Sectors/Transporters with no resources
    {
        managerMap.get(l).add(r);
    }

    public GoodsType pop(Loc l){
        return managerMap.get(l).remove(managerMap.size()-1);
    }

    public int getQuantityInArea(Loc l){
        return managerMap.get(l).size();
    }



    //GoodsManager<Transporter, Cargo> CargoManager = new GoodsManager<Transporter, Cargo>();
    //GoodsManager<OilRig, Resource> OilRigResourceManager = new GoodsManager<OilRig, Resource>();
    //GoodsManager<Sector, Stone> StoneManager = new GoodsManager<Sector, Stone>();
    //GoodsManager<Sector, Wood> WoodManager = new GoodsManager<Sector, Wood>(); //etc.

}
