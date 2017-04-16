package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildStoneFactoryAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildStoneFactoryAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<Board>();
    private BuildStoneFactoryAbility buildStoneFactoryAbility;

    @Override
    public void visitBoard(Board board) {
        boardArrayList.add(board);
    }

    @Override
    public void consume() {
        if (boardArrayList.size() >= 2) {
            buildStoneFactoryAbility = new BuildStoneFactoryAbility(boardArrayList.get(0), boardArrayList.get(1));
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildStoneFactoryAbility;
    }
}
