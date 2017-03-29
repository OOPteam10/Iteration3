package utilities;

import model.MapSubsystem.Location;

/**
 * Created by allisonaguirre on 3/29/17.
 */
public abstract class TileCreationCommand {
    private Location location;

    public void configureLocation(Location loc) {
        this.location = loc;
    }

    protected Location getLocation() {
        return location;
    }

    public boolean execute() {
        if (location != null) {
           return executeCreation();
        } else {
            return false;
        }
    }

    public abstract boolean executeCreation();
}
