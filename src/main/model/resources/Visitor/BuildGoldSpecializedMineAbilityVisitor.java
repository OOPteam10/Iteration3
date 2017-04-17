package model.resources.Visitor;


import model.Abilities.buildAbilities.BuildGoldSpecializedMineAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;
import model.resources.Stone;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildGoldSpecializedMineAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();
    private BuildGoldSpecializedMineAbility buildSpecialtyMineBuildAbility;

    @Override
    public void visitBoard(Board board) {
        boardArrayList.add(board);
    }

    @Override
    public void visitStone(Stone stone) {
        stoneArrayList.add(stone);
    }

    @Override
    public void consume() {
        if (boardArrayList.size() >= 3 && stoneArrayList.size() >= 1) {
            buildSpecialtyMineBuildAbility = new BuildGoldSpecializedMineAbility(
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
        return buildSpecialtyMineBuildAbility;
    }
}
