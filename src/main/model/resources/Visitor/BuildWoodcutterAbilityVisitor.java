package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildWoodcutterAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildWoodcutterAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<Board>();
    private BuildWoodcutterAbility buildWoodcutterAbility;

    @Override
    public void visitBoard(Board board) {
        boardArrayList.add(board);
    }

    @Override
    public void consume() {
        if (boardArrayList.size() >= 1) {
            buildWoodcutterAbility = new BuildWoodcutterAbility(boardArrayList.get(0));
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildWoodcutterAbility;
    }
}
