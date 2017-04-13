package model.Transporters;

import model.Managers.LandTransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.Visitor.RoadTransporterVisitor;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class RoadTransporter extends Transporter<Sector>{
    public void dropOff(Sector s){
        
    }
    public abstract void accept(RoadTransporterVisitor v);

}
