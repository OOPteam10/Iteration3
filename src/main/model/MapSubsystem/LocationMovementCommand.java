package model.MapSubsystem;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public abstract class LocationMovementCommand {
    private Location location;

    public void configureLocation(Location loc) {
        location = new Location(loc);
    }

    protected Location getLocation() {
        return location;
    }

    public Location execute() {
        if (location != null) {
            return executeMovement();
        } else {
            return null;
        }
    }

    public abstract Location executeMovement();
}
