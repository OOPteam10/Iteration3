package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 11/04/17.
 */
public class Delete extends Action {

    public Delete(ControlHandler controlHandler){
        super(controlHandler);
    }
    @Override
    public void perform() {
        getControlHandler().delete();
    }
}
