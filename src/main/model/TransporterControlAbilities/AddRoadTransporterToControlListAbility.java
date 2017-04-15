package model.TransporterControlAbilities;


import controller.MovePhaseControlSubsystem.MovePhaseControl;
import model.Transporters.RoadTransporter;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public class AddRoadTransporterToControlListAbility extends AddTransporterToControlListAbility {
    private RoadTransporter rt;

    public AddRoadTransporterToControlListAbility(MovePhaseControl mpc, RoadTransporter rt) {
        super(mpc);
        this.rt = rt;
    }

//    public AddRoadTransporterToControlListAbility(RoadTransporter rt) {
//        this.rt = rt;
//    }

    @Override
    public void execute() {
        getMovePhaseControl().addToRoadTransporterList(rt);
    }
}
