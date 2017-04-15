package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 11/04/17.
 */
public class MoveNE extends Action {

    public MoveNE(ControlHandler controlHandler){
        super(controlHandler);
    }
    @Override
    public void perform() {
        getControlHandler().moveNE();
    }
}
