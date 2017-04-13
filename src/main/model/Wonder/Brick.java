package model.Wonder;

/**
 * Created by Kevin on 4/11/17.
 */

public abstract class Brick {

    protected int playerID;

    public int getPlayerID() {
        return playerID;
    }

    public abstract int getValue();
}
