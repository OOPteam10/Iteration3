package model.structures.consumers;

import model.resources.Stone;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface StoneConsumer extends Consumer {
    public void addStone(Stone stone);
}
