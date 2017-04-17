package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildStoneQuarryAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildQuarryAbilityVisitor extends  LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<Board>();
    private BuildStoneQuarryAbility buildQuarryAbility;

    @Override
    public void visitBoard(Board board) {
        boardArrayList.add(board);
    }

    @Override
    public void consume() {
        if (boardArrayList.size() >= 2) {
            buildQuarryAbility = new BuildStoneQuarryAbility(boardArrayList.get(0), boardArrayList.get(1));
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildQuarryAbility;
    }
}
