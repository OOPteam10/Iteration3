package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildCoalBurnerAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Board;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildCoalBurnerAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Board> boardArrayList = new ArrayList<Board>();
    private BuildCoalBurnerAbility buildCoalBurnerAbility;

    @Override
    public void visitBoard(Board board) {
        boardArrayList.add(board);
    }

    @Override
    public void consume() {
        // add resources to the ability
        if (boardArrayList.size() >= 3) {
            buildCoalBurnerAbility = new BuildCoalBurnerAbility(
                    boardArrayList.get(0),
                    boardArrayList.get(1),
                    boardArrayList.get(2));
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildCoalBurnerAbility; // null if there are not enough resources
    }
}
