package model.Transporters;

import model.Managers.LandTransporterManager;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class RoadTransporter extends LandTransporter{
    public RoadTransporter(LandTransporterManager landTransporterManager){
        super(landTransporterManager);
    }
}
