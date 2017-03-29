package model.MapSubsystem;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public class GoSouthEastCommand extends LocationMovementCommand {
    @Override
    public Location executeMovement() {
        getLocation().moveSE();
        return getLocation();
    }
}