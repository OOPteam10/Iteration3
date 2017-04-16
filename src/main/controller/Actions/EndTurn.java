package controller.Actions;

import controller.Action;
import controller.ControlHandler;

/**
 * Created by rishabh on 15/04/17.
 */
public class EndTurn extends Action {

    private ControlHandler controlHandler;
    public EndTurn(ControlHandler controlHandler){
        super(controlHandler);
        this.controlHandler = controlHandler;
    }
    @Override
    public void perform() {
        this.controlHandler.endTurn();
    }
}
