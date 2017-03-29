package model.MapSubsystem;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public class GoNorthCommand extends LocationMovementCommand {
    @Override
    public Location executeMovement() {
        getLocation().moveN();
        return getLocation();
    }
}
