package model.Managers;

import model.Cargo;
import model.Transporters.Transporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/8/17.
 */
public class CargoManager extends Manager<Transporter, ArrayList<Cargo>> {

    public boolean add(Transporter loc, Cargo occupant)
    {
        if(getManagerMap().containsKey(loc)){
            getManagerMap().get(loc).add(occupant);
        }
        else{
            ArrayList<Cargo> newList = new ArrayList<Cargo>();
            newList.add(occupant);
            getManagerMap().put(loc, newList);
        }
        return true;
    }
}
