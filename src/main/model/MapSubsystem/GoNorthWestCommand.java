package model.MapSubsystem;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public class GoNorthWestCommand extends LocationMovementCommand {
    @Override
    public Location executeMovement() {
        getLocation().moveNW();
        return getLocation();
    }
}