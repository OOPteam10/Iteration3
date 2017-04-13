package model.Transporters;


import model.DropOffAbilities.LandTransporterDropOffAbility;
import model.Managers.LandTransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.Visitor.TransporterVisitor;


/**
 * Created by hankerins on 4/8/17.
 */

public abstract class LandTransporter extends Transporter<Sector> {
    private LandTransporterDropOffAbility ltdoAbility;

    public LandTransporter(LandTransporterManager landTransporterManager){
        ltdoAbility = new LandTransporterDropOffAbility(this, landTransporterManager);
    }

    public void dropOff(Sector s){
        ltdoAbility.execute(s);


    @Override
    public void accept(TransporterVisitor v){
        v.visitLandTransporter(this);

    }
}
