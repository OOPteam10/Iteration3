package model.Wonder;

import model.PlayerID;

/**
 * Created by Kevin on 4/11/17.
 */

public abstract class Brick {

    protected PlayerID playerID;

    public PlayerID getPlayerID() {
        return playerID;
    }

    public abstract int getValue();
}
