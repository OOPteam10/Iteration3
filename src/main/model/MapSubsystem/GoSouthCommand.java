package model.MapSubsystem;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public class GoSouthCommand extends LocationMovementCommand {
    @Override
    public Location executeMovement() {
        getLocation().moveS();
        return getLocation();
    }
}
