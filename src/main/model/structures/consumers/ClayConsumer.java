package model.structures.consumers;

import model.resources.Clay;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface ClayConsumer extends Consumer {
    public void addClay(Clay clay);
}
