package model.Managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hankerins on 4/8/17.
 * for a SectorResourceManager, Loc = Sector or OilRig, GoodsType is a Resource
 * for CargoManager, Loc = Transporter, GoodsType = cargo
 * this works best if a player has to drop their resources before building,
 * otherwise we need a cargo manager for every resource type (doable)
 *
 * this version requires a ListManager for each resource type.  I think
 *
 * gonna use a generic ListManager<Sector, Resource>,
 *
 * examples at bottom
 */
public class ListManager<Loc, GoodsType> {
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

    public void add(Loc l, ArrayList<GoodsType> r) {
        for(GoodsType goodsType: r){
            add(l, goodsType);
        }
    }

    public void remove(Loc l, GoodsType g){
        managerMap.get(l).remove(g);
    }

    public void remove(GoodsType g){
        for(Map.Entry<Loc, ArrayList<GoodsType>> e : managerMap.entrySet()){

            managerMap.get(e.getKey()).remove(g);

        }
    }

    public ArrayList<GoodsType> get(Loc l){
        if(managerMap.get(l) != null){
            return managerMap.get(l);
        }else {
            return new ArrayList<GoodsType>();
        }
    }

    public int getQuantityInArea(Loc l){
        if(managerMap.get(l) != null){
            return managerMap.get(l).size();
        }
        else return 0;
    }



    //ListManager<Transporter, Cargo> CargoManager = new ListManager<Transporter, Product>();
    //ListManager<OilRig, Resource> OilRigResourceManager = new ListManager<OilRig, Resource>();
    //ListManager<Sector, Stone> StoneManager = new ListManager<Sector, Stone>();
    //ListManager<Sector, Wood> WoodManager = new ListManager<Sector, Wood>(); //etc.

}
