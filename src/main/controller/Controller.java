package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import model.MapSubsystem.Map;

/**
 * Created by cduica on 3/22/17.
 */
public class Controller extends KeyAdapter{

    //represents the top level state of Controller
    private ControlHandler controlHandler;

    private Vector<Integer> activeKeys;
    private Map map;

    public Controller(){
        //init with the MapMakerControl state
        controlHandler = new MapMakerControl(map);
    }


    public ControlHandler getControlHandler() {
        return controlHandler;
    }

    public void setControlHandler(ControlHandler controlHandler) {
        this.controlHandler = controlHandler;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(!activeKeys.contains(e.getKeyCode()))
            activeKeys.add(new Integer(e.getKeyCode()));

        //functionality on keypresses
        keyPressDispatch();

    }

    /*
     MAC SYSTEM DEFAULT KEY PRESSES

    left: 37, right: 39,  down: 40,  up: 38

     */


    public void keyPressDispatch(){

        if(activeKeys.contains(new Integer(39))){
            //right
            controlHandler.right();
        }
        if(activeKeys.contains(new Integer(37))){
            //left
            controlHandler.left();
        }
        if(activeKeys.contains(KeyEvent.VK_ENTER)){
            //enter
            controlHandler.select(this);
        }
        if(activeKeys.contains(KeyEvent.VK_W)){
            //W maps to north
            controlHandler.moveN();
        }
        if(activeKeys.contains(KeyEvent.VK_E)){
            //E maps to north east
            controlHandler.moveNE();
        }
        if(activeKeys.contains(KeyEvent.VK_Q)){
            //Q maps to north west
            controlHandler.moveNW();
        }
        if(activeKeys.contains(KeyEvent.VK_S)){
            //S maps to south
            controlHandler.moveS();
        }
        if(activeKeys.contains(KeyEvent.VK_D)) {
            //D maps to south east
            controlHandler.moveSE();
        }
        if(activeKeys.contains(KeyEvent.VK_A)) {
            //A maps to south west
            controlHandler.moveSW();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        activeKeys.remove(new Integer(e.getKeyCode()));

    }
}
