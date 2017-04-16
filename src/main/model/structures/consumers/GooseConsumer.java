package model.structures.consumers;

import model.Goose;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface GooseConsumer extends Consumer {
    public void addGoose(Goose goose);
}
