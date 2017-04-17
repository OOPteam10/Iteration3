package model.Wonder;

import model.PlayerID;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Kevin on 4/11/17.
 */

/**
 * TODO: LIST
 *
 * - activate irrigation
 * - add buy method for player
 * - ensure we consume player goods upon buying
 *
 */

public class Wonder {

    private final int BRICK_PRICE_INCREASE_INDEX = 17;
    private final int IRRIGATION_MARK_INDEX = 44;

    private LinkedList<WonderLevel> levels = new LinkedList<>();
    private WonderLevel currentLevel;
    ListIterator<WonderLevel> levelIterator;

    private int count;
    private int brickPrice;
    private int capacity;

    public Wonder(){

        levels.add(new WonderLevel(4,3));
        levels.add(new WonderLevel(5,4));
        levels.add(new WonderLevel(6,5));
        levels.add(new WonderLevel(7,3));

        levelIterator = levels.listIterator(0);

        count = 0;
        brickPrice = 1;

        capacity = 0;
        for(WonderLevel level : levels){

            capacity += level.getCapacity();
        }

        currentLevel = levelIterator.next();
    }

    public void buyBricks(int num, PlayerID playerID){

        for(int i = 0; i < num; i++){

            addPlayerBrick(playerID);
        }
    }

    public int calculateScore(PlayerID playerID){

        int totalScore = 0;

        for( WonderLevel level : levels){

            totalScore += level.getScore(playerID);
        }

        return totalScore;
    }

    // Runs after bricks are bought, runs once for each brick bought
    public boolean addPlayerBrick(PlayerID playerID){

        if( count < capacity ){

            currentLevel.addBrick(new PlayerBrick(playerID));

            count++;
            checkForUpdate();

            return true;
        }

        return false;
    }

    public boolean addNeutralBrick(){

        if( count < capacity ){

            currentLevel.addBrick(new NeutralBrick());

            count++;
            checkForUpdate();

            return true;
        }

        return false;
    }

    private void checkForUpdate() {

        if(currentLevel.isFull() && levelIterator.hasNext()){            // Advance to second level

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

    public int getBrickPrice(){
        return brickPrice;
    }
}
