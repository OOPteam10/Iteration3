package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 07/04/17.
 */
public class CycleLeft extends Action {

  public CycleLeft(ControlHandler controlHandler){
       super(controlHandler);
   }
    @Override
    public void perform() {
        getControlHandler().left();
    }
}
