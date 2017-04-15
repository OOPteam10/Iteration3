package model.TransporterControlAbilities;

import controller.MovePhaseControlSubsystem.MovePhaseControl;
import model.Transporters.Donkey;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public class AddDonkeyToControlListAbility extends AddTransporterToControlListAbility {
    private Donkey donkey;

    public AddDonkeyToControlListAbility(MovePhaseControl mpc, Donkey d) {
        super(mpc);
        this.donkey = d;
    }

//    public AddDonkeyToControlListAbility(Donkey donkey) {
//        this.donkey = donkey;
//    }

    @Override
    public void execute() {
        getMovePhaseControl().addToDonkeyList(donkey);
    }
}
