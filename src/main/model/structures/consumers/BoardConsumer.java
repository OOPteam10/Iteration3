package model.structures.consumers;

import model.resources.Board;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface BoardConsumer extends Consumer {
    public void addBoard(Board board);
}
