package model;

/**
 * Created by Kevin on 4/13/17.
 */

import model.Wonder.Wonder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WonderTest {

    @Test
    public void WonderScoringTest(){

        Wonder wonder = new Wonder();
        PlayerID player1 = new PlayerID();
        PlayerID player2 = new PlayerID();

        // LEVEL 1

        // row 1, 10 points to player1
        for(int i = 0; i < 4; i++) {
            wonder.addPlayerBrick(player1);
        }

        assertEquals(10, wonder.calculateScore(player1));
        assertEquals(0, wonder.calculateScore(player2));

        // row 2, 10 points to player2
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addPlayerBrick(player2);

        assertEquals(10, wonder.calculateScore(player1));
        assertEquals(10, wonder.calculateScore(player2));

        // row 3, 5 points to each player
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(15, wonder.calculateScore(player1));
        assertEquals(15, wonder.calculateScore(player2));

        // brick price should still be 1
        assertEquals(1, wonder.getBrickPrice());

        // LEVEL 2

        // row 4, 5 points to each player
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addNeutralBrick();
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(20, wonder.calculateScore(player1));
        assertEquals(20, wonder.calculateScore(player2));

        // brick price should now be increased
        assertEquals(2, wonder.getBrickPrice());

        // row 5, 6 points to player2 and 4 to player1
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(24, wonder.calculateScore(player1));
        assertEquals(26, wonder.calculateScore(player2));

        // row 6, 7 points to player1 and 2 points to player2
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addNeutralBrick();

        assertEquals(31, wonder.calculateScore(player1));
        assertEquals(28, wonder.calculateScore(player2));

        // row 7, 0 points for players
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();

        assertEquals(31, wonder.calculateScore(player1));
        assertEquals(28, wonder.calculateScore(player2));

        // LEVEL 3

        // row 8, 5 points for each player
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(36, wonder.calculateScore(player1));
        assertEquals(33, wonder.calculateScore(player2));

        // row 9,  player2: 6, player1: 4
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addNeutralBrick();
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(40, wonder.calculateScore(player1));
        assertEquals(39, wonder.calculateScore(player2));

        // row 10,  player2: 1, player1: 8
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(48, wonder.calculateScore(player1));
        assertEquals(40, wonder.calculateScore(player2));

        // row 11,  player2: 6, player1: 3
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(51, wonder.calculateScore(player1));
        assertEquals(46, wonder.calculateScore(player2));

        // row 12,  player2: 6, player1: 3
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addPlayerBrick(player1);

        assertEquals(54, wonder.calculateScore(player1));
        assertEquals(52, wonder.calculateScore(player2));

        // LEVEL 4

        // row 13,  player2: 5, player1: 5
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addNeutralBrick();
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(59, wonder.calculateScore(player1));
        assertEquals(57, wonder.calculateScore(player2));

        // row 14,  player2: 7, player1: 2
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(61, wonder.calculateScore(player1));
        assertEquals(64, wonder.calculateScore(player2));

        // row 15,  player2: 3, player1: 6
        wonder.addPlayerBrick(player2);
        wonder.addPlayerBrick(player2);
        wonder.addNeutralBrick();
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);
        wonder.addPlayerBrick(player1);

        assertEquals(67, wonder.calculateScore(player1));
        assertEquals(67, wonder.calculateScore(player2));

        // wonder is full, can't add anymore bricks
        assertEquals(false, wonder.addNeutralBrick());
    }
}
