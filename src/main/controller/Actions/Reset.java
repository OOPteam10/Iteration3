package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 11/04/17.
 */
public class Reset extends Action {
    public Reset(ControlHandler controlHandler){
        super(controlHandler);
    }

    @Override
    public void perform() {
        getControlHandler().reset();
    }
}
