package model.structures.consumers;

import model.resources.Fuel;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface FuelConsumer extends Consumer {
    public void addFuel(Fuel fuel);
}
