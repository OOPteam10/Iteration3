package model.structures.consumers;

import model.resources.Iron;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface IronConsumer extends Consumer {
    public void addIron(Iron iron);
}
