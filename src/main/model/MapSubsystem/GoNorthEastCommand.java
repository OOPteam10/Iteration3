package model.MapSubsystem;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public class GoNorthEastCommand extends LocationMovementCommand {
    @Override
    public Location executeMovement() {
        getLocation().moveNE();
        return getLocation();
    }
}