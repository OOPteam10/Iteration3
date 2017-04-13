package model.Wonder;

/**
 * Created by Kevin on 4/13/17.
 */

public class NeutralBrick extends Brick{

    NeutralBrick(){

        playerID = null;
    }

    @Override
    public int getValue() {
        return 0;
    }
}
