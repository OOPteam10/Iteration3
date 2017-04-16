package model.resources.Visitor;

import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.*;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public abstract class LandProducerBuildAbilityVisitor implements ResourceVisitor {
    public abstract void consume();
    public abstract LandProducerBuildAbility makeAbility();

    public void visitBoard(Board board) {

    }
    public void visitClay(Clay clay) {

    }
    public void visitCoin(Coin coin) {

    }
    public void visitFuel(Fuel fuel) {

    }
    public void visitGold(Gold gold) {

    }
    public void visitIron(Iron iron) {

    }
    public void visitPaper(Paper paper) {

    }
    public void visitStock(Stock stock) {

    }
    public void visitStone(Stone stone) {

    }
    public void visitTrunk(Trunk trunk) {

    }

}
