package model.phases;

import model.Game;
import model.PlayerID;

/**
 * Created by cduica on 4/14/17.
 */
public interface Phase {
    void execute(PlayerID p1, PlayerID p2);
    void execute(PlayerID playerID);
}
