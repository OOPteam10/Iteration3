package model.Wonder;

import java.util.ArrayList;

/**
 * Created by Kevin on 4/11/17.
 */

public class Wonder {

    private ArrayList<Brick> level1 = new ArrayList<>();
    private ArrayList<Brick> level2 = new ArrayList<>();
    private ArrayList<Brick> level3 = new ArrayList<>();
    private ArrayList<Brick> level4 = new ArrayList<>();
    private ArrayList<Brick> currentLevel;

    private int count;
    private int brickPrice;

    public Wonder(){

        count = 0;
        brickPrice = 1;
        currentLevel = level1;
    }

    // TODO: ensure the playerID is how we are checking this shizz
    public int calculateScore(int playerID){

        int totalScore = 0;

        totalScore += getLevel1Score(playerID);
        totalScore += getLevel2Score(playerID);
        totalScore += getLevel3Score(playerID);
        totalScore += getLevel4Score(playerID);

        return totalScore;
    }

    private int getLevel1Score(int playerID){

        int levelScore = 0;
        int rowCount = 0;

        for(int i = 0; i < 12; i++){

            Brick currentBrick = level1.get(i);

            if(currentBrick.getPlayerID() == playerID){

                rowCount++;
            }

            if(i % 4 == 3){

            }
        }

        return levelScore;
    }

    private int getLevel2Score(int playerID){

        int levelScore = 0;
        int rowCount = 0;

        for(int i = 0; i < 20; i++){


        }

        return levelScore;
    }

    private int getLevel3Score(int playerID){

        int levelScore = 0;
        int rowCount = 0;

        for(int i = 0; i < 30; i++){


        }

        return levelScore;
    }

    private int getLevel4Score(int playerID){

        int levelScore = 0;
        int rowCount = 0;

        for(int i = 0; i < 21; i++){


        }

        return levelScore;
    }

    // TODO: ensure the playerID is how we want to assign a brick (is it an int?)
    // Runs after bricks are bought, runs once for each brick bought
    private void addPlayerBrick(int playerID){

        currentLevel.add(new Brick(playerID));

        count++;
        checkForUpdate();
    }

    private void addNeutralBrick(){

        currentLevel.add(new Brick());  // note the constructor is empty, thus asking for a neutral brick

        count++;
        checkForUpdate();
    }

    private void checkForUpdate() {

        if(count == 12){            // Advance to second level

            currentLevel = level2;

        }else if(count == 17){      // First 4 rows complete so increase brick price

            increaseBrickPrice();

        }else if(count == 32){      // Advance to third level

            currentLevel = level3;

        }else if(count == 44){      // Irrigation now active, update desert to pasture

            makeIrrigationActive();

        }else if(count == 62){      // Advance to fourth level

            currentLevel = level4;
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
