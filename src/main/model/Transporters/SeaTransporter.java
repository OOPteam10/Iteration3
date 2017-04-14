package model.Transporters;

import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.DropOffAbilities.SeaTransporterDropOffAbility;
import model.Managers.LandTransporterManager;
import model.Managers.SeaTransporterManager;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.Transporters.Visitor.SeaTransporterVisitor;

/**
 * Created by hankerins on 4/8/17.
 */
public  abstract class SeaTransporter extends Transporter<Waterway> {
    private SeaTransporterDropOffAbility stdoAbility;

    public void setStdoAbility(SeaTransporterDropOffAbility stdoAbility){
        this.stdoAbility = stdoAbility;
    }

    public void dropOff(Sector s){
        stdoAbility.execute(s);
    }


    public abstract void accept(SeaTransporterVisitor v);

    //public abstract void dropOff(Waterway l);  add later




}
