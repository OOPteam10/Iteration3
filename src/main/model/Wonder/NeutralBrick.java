package model.Wonder;

/**
 * Created by Kevin on 4/13/17.
 */

public class NeutralBrick extends Brick{

    NeutralBrick(){

        playerID = -1;
    }

    @Override
    public int getValue() {
        return 0;
    }
}
