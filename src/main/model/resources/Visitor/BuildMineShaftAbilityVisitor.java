package model.resources.Visitor;

import model.Abilities.buildAbilities.BuildMineShaftAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.resources.Fuel;
import model.resources.Iron;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildMineShaftAbilityVisitor extends LandProducerBuildAbilityVisitor{
    private ArrayList<Iron> irons = new ArrayList<Iron>();
    private ArrayList<Fuel> fuels = new ArrayList<Fuel>();
    private BuildMineShaftAbility buildMineShaftAbility;

    @Override
    public void visitFuel(Fuel fuel) {
        fuels.add(fuel);
    }

    @Override
    public void visitIron(Iron iron) {
        irons.add(iron);
    }

    @Override
    public void consume() {
        if (irons.size() >= 1 && fuels.size() >= 1) {
            buildMineShaftAbility = new BuildMineShaftAbility(irons.get(0), fuels.get(0));
        }
    }

    @Override
    public LandProducerBuildAbility makeAbility() {
        consume();
        return buildMineShaftAbility;
    }
}
