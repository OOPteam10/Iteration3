package controller;

import controller.MapMakerControlSubsystem.ControlAction.*;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

/**
 * Created by Kevin on 3/29/17.
 */


public class KeyMapControls {

    HashMap<KeyCode, ControlAction> actionMap;

    public KeyMapControls(){

        actionMap = new HashMap<>();

        actionMap.put(KeyCode.W, new MoveNAction());
        actionMap.put(KeyCode.Q, new MoveNWAction());
        actionMap.put(KeyCode.E, new MoveNEAction());
        actionMap.put(KeyCode.A, new MoveSWAction());
        actionMap.put(KeyCode.S, new MoveSAction());
        actionMap.put(KeyCode.D, new MoveSEAction());
        actionMap.put(KeyCode.ENTER, new SelectAction());
        actionMap.put(KeyCode.J, new LeftAction());
        actionMap.put(KeyCode.K, new RightAction());
        actionMap.put(KeyCode.Z, new ResetAction());
        actionMap.put(KeyCode.X, new DeleteAction());
        actionMap.put(KeyCode.C, new CenterGravityAction());
    }

    public HashMap<KeyCode, ControlAction> getActionMap(){

        return actionMap;
    }
}
