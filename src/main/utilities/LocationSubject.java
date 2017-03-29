package utilities;

import model.MapSubsystem.Location;

/**
 * Created by allisonaguirre on 3/28/17.
 */
public interface LocationSubject {
    void attach(MapObserver ob);
    void detach(MapObserver ob);
    void notifyLocationChange(Location loc);
}
