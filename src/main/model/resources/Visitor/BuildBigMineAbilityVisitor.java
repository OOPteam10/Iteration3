package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildBigMineAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;
import model.resources.Stone;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildBigMineAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();
    private BuildBigMineAbility buildBigMineAbility;

    @Override
    public void consume() {
        if (boardArrayList.size() >= 3 && stoneArrayList.size() >= 1) {
            buildBigMineAbility = new BuildBigMineAbility(
                    boardArrayList.get(0),
                    boardArrayList.get(1),
                    boardArrayList.get(2),
                    stoneArrayList.get(0)
            );
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildBigMineAbility;
    }

    @Override
    public void visitBoard(Board board) {
        boardArrayList.add(board);
    }

    @Override
    public void visitStone(Stone stone) {
        stoneArrayList.add(stone);
    }
}
