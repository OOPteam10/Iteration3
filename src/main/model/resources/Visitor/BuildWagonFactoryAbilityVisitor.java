package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildWagonFactoryAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;
import model.resources.Stone;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildWagonFactoryAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();
    private BuildWagonFactoryAbility buildWagonFactoryAbility;

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
        if (boardArrayList.size() >= 2 && stoneArrayList.size() >= 1) {
            buildWagonFactoryAbility = new BuildWagonFactoryAbility(
                    boardArrayList.get(0),
                    boardArrayList.get(1),
                    stoneArrayList.get(0)
            );
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildWagonFactoryAbility;
    }
}
