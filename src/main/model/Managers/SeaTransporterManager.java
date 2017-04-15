package model.Managers;


import model.DropOffAbilities.WaterwayDropOffAbility;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/8/17.
 */
public class SeaTransporterManager extends TransporterManager<SeaTransporter, Waterway> {

    @Override
    public void add(SeaTransporter o, Waterway w) {
        o.setWaterwayDropOffAbility(new WaterwayDropOffAbility(o, this));
        super.add(o, w);
    }

}
