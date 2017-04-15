package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 11/04/17.
 */
public class MoveSW extends Action {

   public MoveSW(ControlHandler controlHandler){
        super(controlHandler);
    }
    @Override
    public void perform() {
        getControlHandler().moveSW();
    }
}
