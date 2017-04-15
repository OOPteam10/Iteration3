package model.TransporterControlAbilities;

import controller.MovePhaseControlSubsystem.MovePhaseControl;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public abstract class AddTransporterToControlListAbility implements TransporterAbility {
    private MovePhaseControl mpc;

    public AddTransporterToControlListAbility(MovePhaseControl mpc) {
        this.mpc = mpc;
    }

    protected MovePhaseControl getMovePhaseControl() {
        return mpc;
    }
}
