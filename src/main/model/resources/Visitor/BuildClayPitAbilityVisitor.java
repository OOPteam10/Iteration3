package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildClayPitAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildClayPitAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<Board>();
    private BuildClayPitAbility buildClayPitAbility;

    @Override
    public void consume() {
        // add resources to the ability
        if (boardArrayList.size() >= 3) {
            buildClayPitAbility = new BuildClayPitAbility(
                    boardArrayList.get(0),
                    boardArrayList.get(1),
                    boardArrayList.get(2));
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildClayPitAbility; // null if there are not enough resources
    }

    @Override
    public void visitBoard(Board board) {
        boardArrayList.add(board);
    }
}
