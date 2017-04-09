package model.Managers;

import model.Cargo;
import model.TileSubsystem.Sector;
import model.Transporters.Transporter;
import model.producers.primary.OilRig;
import model.resources.Resource;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hankerins on 4/8/17.
 * for a SectorResourceManager, Loc = Sector or OilRig, ResourceType is a Resource
 * for CargoManager, Loc = Transporter, ResourceType = cargo
 * this works best if a player has to drop their resources before building,
 * otherwise we need a cargo manager for every resource type (doable)
 *
 * this version requires a GoodsManager for each resource type.
 *
 * examples at bottom
 */
public class GoodsManager<Loc, ResourceType> {
    private HashMap<Loc, ArrayList<ResourceType>> managerMap = new HashMap<Loc, ArrayList<ResourceType>>();

    protected HashMap<Loc, ArrayList<ResourceType>> getManagerMap() {
        return managerMap;
    }

    public void add(Loc l, ResourceType r)
            //This method assumes a HashMap entry for every Sector/Transporter,
            // with empty lists for Sectors/Transporters with no resources
    {
        managerMap.get(l).add(r);
    }

    public int getQuantityInSector(Sector s){
        return managerMap.get(s).size();
    }

    public void removeResourceFromSector(ResourceType r, Sector s){  //This removes a particular Resource object
        managerMap.remove(s, r);
    }

    //GoodsManager<Transporter, Cargo> CargoManager = new GoodsManager<Transporter, Cargo>();
    //GoodsManager<OilRig, Resource> OilRigResourceManager = new GoodsManager<OilRig, Resource>();
    //GoodsManager<Sector, Stone> StoneManager = new GoodsManager<Sector, Stone>();
    //GoodsManager<Sector, Wood> WoodManager = new GoodsManager<Sector, Wood>(); //etc.

}
