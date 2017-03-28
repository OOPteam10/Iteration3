package controller;

import java.applet.Applet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import model.MapSubsystem.Map;

import javax.swing.*;

/**
 * Created by cduica on 3/22/17.
 */
public class Controller {

    //represents the top level state of Controller
    private ControlHandler controlHandler;



    public Controller(){

        //init with the MapMakerControl state
        controlHandler = MapMakerControl.getInstance();

    }


    public ControlHandler getControlHandler() {
        return controlHandler;
    }

    public void setControlHandler(ControlHandler controlHandler) {
        this.controlHandler = controlHandler;
    }



    public void right(){

        controlHandler.right();
    }
    public void left(){

        controlHandler.left();
    }
    public void select(){

        controlHandler.select();

    }
    public void moveN(){

        controlHandler.moveN();
    }
    public void moveNE(){

        controlHandler.moveNE();
    }
    public void moveNW(){

        controlHandler.moveNW();
    }
    public void moveS(){

        controlHandler.moveS();
    }
    public void moveSE(){

        controlHandler.moveSE();
    }
    public void moveSW() {

        controlHandler.moveSW();
    }



}
