package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 14/04/17.
 */
public class Up extends Action {

    public Up(ControlHandler controlHandler){
        super(controlHandler);
    }
    @Override
    public void perform() {
        getControlHandler().up();
    }
}
