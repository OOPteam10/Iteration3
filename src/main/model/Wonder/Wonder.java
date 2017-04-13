package model.Wonder;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Kevin on 4/11/17.
 */

public class Wonder {

    private final int BRICK_PRICE_INCREASE_INDEX = 17;
    private final int IRRIGATION_MARK_INDEX = 44;

    private LinkedList<WonderLevel> levels = new LinkedList<>();
    private WonderLevel currentLevel;
    ListIterator<WonderLevel> levelIterator;

    private int count;
    private int brickPrice;

    public Wonder(){

        levels.add(new WonderLevel(4,3));
        levels.add(new WonderLevel(5,4));
        levels.add(new WonderLevel(6,5));
        levels.add(new WonderLevel(7,3));

        levelIterator = levels.listIterator(0);

        count = 0;
        brickPrice = 1;
        currentLevel = levelIterator.next();
    }

    // TODO: ensure the playerID is how we are checking this shizz
    public int calculateScore(int playerID){

        int totalScore = 0;



        return totalScore;
    }

    // TODO: ensure the playerID is how we want to assign a brick (is it an int?)
    // Runs after bricks are bought, runs once for each brick bought
    private void addPlayerBrick(PlayerID playerID){

        currentLevel.addBrick(new PlayerBrick(playerID));

        count++;
        checkForUpdate();
    }

    private void addNeutralBrick(){

        currentLevel.addBrick(new NeutralBrick());

        count++;
        checkForUpdate();
    }

    private void checkForUpdate() {

        if(currentLevel.isFull()){            // Advance to second level

            currentLevel = levelIterator.next();

        }

        if(count == BRICK_PRICE_INCREASE_INDEX){      // First 4 rows complete so increase brick price

            increaseBrickPrice();

        }

        if(count == IRRIGATION_MARK_INDEX){      // Irrigation now active, update desert to pasture

            makeIrrigationActive();

        }

    }

    // Brick price starts at 2 after first 4 rows complete
    private void increaseBrickPrice(){

        brickPrice = 2;
    }

    // After placing 44 bricks desert turn to pasture, this initializes that
    // TODO
    private void makeIrrigationActive(){

    }
}
