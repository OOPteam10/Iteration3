package controller;

import model.MapSubsystem.Map;

import java.util.Scanner;

/**
 * Created by hankerins on 3/27/17.
 */
public class CommandLineControl {
    public static void main(String args[]){

        Map map = new Map();
        MapMakerControl mmc = new MapMakerControl(map);

        while(true){
            debugMenu(mmc);
        }


    }

    static void debugMenu(MapMakerControl mmc){
        Scanner in = new Scanner(System.in);
        int input = 0;
        System.out.println("0: left    1: right    2: select\n" +
                "3: NW    4: N   5: NE\n" +
                "6: SE    7: S    8: SW\n");
        input = in.nextInt();
        switch(input){
            case 0:
                mmc.left();
                break;
            case 1:
                mmc.right();
                break;
            case 2:
                mmc.select();
                break;
            case 3:
                mmc.moveNW();
                break;
            case 4:
                mmc.moveN();
                break;
            case 5:
                mmc.moveNE();
                break;
            case 6:
                mmc.moveSE();
                break;
            case 7:
                mmc.moveS();
                break;
            case 8:
                mmc.moveSW();
                break;
        }
        mmc.printState();
    }
}
