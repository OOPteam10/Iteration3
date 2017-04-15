package model.TransporterControlAbilities;

import model.Transporters.Donkey;
import model.Transporters.RoadTransporter;
import model.Transporters.Transporter;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public abstract class TransporterAbilityFactory {
    public TransporterAbility makeDonkeyAbility(Donkey d) {
        return null;
    }
    public TransporterAbility makeRoadTransporterAbility(RoadTransporter d) {
        return null;
    }
    public TransporterAbility makeTransporterAbility(Transporter d) {
        return null;
    }
}
