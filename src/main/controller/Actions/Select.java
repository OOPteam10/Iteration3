package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 07/04/17.
 */
public class Select extends Action {
    public Select(ControlHandler controlHandler){
        super(controlHandler);
    }

    @Override
    public void perform() {
        getControlHandler().select();
    }
}
