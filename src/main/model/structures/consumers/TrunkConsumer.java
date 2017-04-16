package model.structures.consumers;

import model.resources.Trunk;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface TrunkConsumer extends Consumer {
    public void addTrunk(Trunk trunk);
}
