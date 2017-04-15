package model.Transporters;


import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.TileSubsystem.Sector;
import model.DropOffAbilities.WaterwayDiscardAbility;

import model.TileSubsystem.Waterway;
import model.Transporters.Visitor.LandTransporterVisitor;


/**
 * Created by hankerins on 4/8/17.
 */

public abstract class LandTransporter extends Transporter<Sector> {
    private LandTransporterDropOffAbility ltdoAbility;
    private WaterwayDiscardAbility waterwayDiscardAbility;

    public void setWaterwayDiscardAbility(WaterwayDiscardAbility waterwayDiscardAbility) {this.waterwayDiscardAbility = waterwayDiscardAbility;}
    public void dropOff(Waterway w) {
        waterwayDiscardAbility.execute(w);
    }
    public void setLtdoAbility(LandTransporterDropOffAbility ltdoAbility){
        this.ltdoAbility = ltdoAbility;
    }

    public void dropOff(Sector s) {
        ltdoAbility.execute(s);
    }

    public abstract void accept(LandTransporterVisitor v);
}
