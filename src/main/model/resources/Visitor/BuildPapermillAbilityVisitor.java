package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildPapermillAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;
import model.resources.Stone;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildPapermillAbilityVisitor extends  LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();
    private BuildPapermillAbility buildPapermillAbility;

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
        if (boardArrayList.size() >= 1 && stoneArrayList.size() >= 1) {
            buildPapermillAbility = new BuildPapermillAbility(
                    boardArrayList.get(0),
                    stoneArrayList.get(0)
            );
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildPapermillAbility;
    }
}
