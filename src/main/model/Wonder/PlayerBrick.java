package model.Wonder;

/**
 * Created by Kevin on 4/13/17.
 */

public class PlayerBrick extends Brick{

    PlayerBrick(int playerID){

        this.playerID = playerID;
    }

    @Override
    public int getValue() {
        return 1;
    }
}
