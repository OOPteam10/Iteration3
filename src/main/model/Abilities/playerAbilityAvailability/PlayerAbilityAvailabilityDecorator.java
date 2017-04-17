package model.Abilities.playerAbilityAvailability;

import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public abstract class PlayerAbilityAvailabilityDecorator extends PlayerAbilityAvailability {
    private PlayerAbilityAvailability child;

    public PlayerAbilityAvailabilityDecorator(PlayerAbilityAvailability child) {
        this.child = child;
    }

    @Override
    public ArrayList<LandProducerBuildAbility> getBuildAbilities() {
        for (LandProducerBuildAbility ability : child.getBuildAbilities()) {
            if (!super.getBuildAbilities().contains(ability)) {
                addToBuildAbilities(ability);
            }
        }
        return super.getBuildAbilities();
    }

    @Override
    public void addBuildClayPit(LandProducerBuildAbility buildAbility) {
        child.addBuildClayPit(buildAbility);
    }

    @Override
    public void addBuildStoneQuarry(LandProducerBuildAbility buildAbility) {
        child.addBuildStoneQuarry(buildAbility);
    }

    @Override
    public void addBuildWoodCutter(LandProducerBuildAbility buildAbility) {
        child.addBuildWoodCutter(buildAbility);
    }

    @Override
    public void addBuildCoalBurner(LandProducerBuildAbility buildAbility) {
        child.addBuildCoalBurner(buildAbility);
    }

    @Override
    public void addBuildNormalMine(LandProducerBuildAbility buildAbility) {
        child.addBuildCoalBurner(buildAbility);
    }

    @Override
    public void addBigMine(LandProducerBuildAbility buildAbility) {
        child.addBigMine(buildAbility);
    }

    @Override
    public void addGoldSpecializedMine(LandProducerBuildAbility buildAbility) {
        child.addGoldSpecializedMine(buildAbility);
    }

    @Override
    public void addIronSpecializedMine(LandProducerBuildAbility buildAbility) {
        child.addIronSpecializedMine(buildAbility);
    }

    @Override
    public void addBuildMint(LandProducerBuildAbility buildAbility) {
        child.addBuildMint(buildAbility);
    }

    @Override
    public void addBuildPaperMill(LandProducerBuildAbility buildAbility) {
        child.addBuildPaperMill(buildAbility);
    }

    @Override
    public void addBuildSawMill(LandProducerBuildAbility buildAbility) {
        child.addBuildSawMill(buildAbility);
    }

    @Override
    public void addBuildStockExchange(LandProducerBuildAbility buildAbility) {
        child.addBuildStockExchange(buildAbility);
    }

    @Override
    public void addBuildStoneFactory(LandProducerBuildAbility buildAbility) {
        child.addBuildStoneFactory(buildAbility);
    }

    @Override
    public void addTruckFactory(LandProducerBuildAbility buildAbility) {
        child.addTruckFactory(buildAbility);
    }

    @Override
    public void addWagonFactory(LandProducerBuildAbility buildAbility) {
        child.addWagonFactory(buildAbility);
    }
}
