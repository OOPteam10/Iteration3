package model.MapSubsystem;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public class GoSouthWestCommand extends LocationMovementCommand {
    @Override
    public Location executeMovement() {
        getLocation().moveSW();
        return getLocation();
    }
}