package model.Transporters;

import model.Managers.LandTransporterManager;
import model.TransporterControlAbilities.AddRoadTransporterToControlListAbility;
import model.TransporterControlAbilities.TransporterAbilityFactory;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class RoadTransporter extends LandTransporter {
    @Override
    public void produceAbility(TransporterAbilityFactory f) {
        setAbility(f.makeRoadTransporterAbility(this));
    }
}
