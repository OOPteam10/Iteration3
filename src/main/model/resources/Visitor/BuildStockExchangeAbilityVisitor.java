package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildStockExchangeAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Stone;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildStockExchangeAbilityVisitor extends LandProducerBuildAbilityVisitor {
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();
    private BuildStockExchangeAbility buildStockExchangeAbility;

    @Override
    public void visitStone(Stone stone) {
        stoneArrayList.add(stone);
    }

    @Override
    public void consume() {
        if (stoneArrayList.size() >= 3) {
            buildStockExchangeAbility = new BuildStockExchangeAbility(
                    stoneArrayList.get(0),
                    stoneArrayList.get(1),
                    stoneArrayList.get(2)
            );
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildStockExchangeAbility;
    }
}
