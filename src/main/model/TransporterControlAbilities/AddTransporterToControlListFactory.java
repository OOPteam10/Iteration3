package model.TransporterControlAbilities;

import controller.MovePhaseControlSubsystem.MovePhaseControl;
import model.Transporters.Donkey;
import model.Transporters.RoadTransporter;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public class AddTransporterToControlListFactory extends TransporterAbilityFactory {
    private MovePhaseControl mpc;

    public AddTransporterToControlListFactory(MovePhaseControl mpc) {
        this.mpc = mpc;
    }

    @Override
    public TransporterAbility makeDonkeyAbility(Donkey d) {
        return new AddDonkeyToControlListAbility(mpc, d);
    }

    @Override
    public TransporterAbility makeRoadTransporterAbility(RoadTransporter r) {
        return new AddRoadTransporterToControlListAbility(mpc, r);
    }
}
