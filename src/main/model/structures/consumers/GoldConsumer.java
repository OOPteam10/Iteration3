package model.structures.consumers;

import model.resources.Gold;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface GoldConsumer extends Consumer {
    public void addGold(Gold gold);
}
