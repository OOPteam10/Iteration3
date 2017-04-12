package model.Wonder;

/**
 * Created by Kevin on 4/11/17.
 */

public class Brick {

    int playerID;

    Brick(){

        playerID = -1;
    }

    // TODO: ensure this is the correct way we are assigning brick to player
    Brick(int playerID){

        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }
}
