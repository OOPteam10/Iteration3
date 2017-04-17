package model.Abilities.playerAbilityAvailability;

import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.PlayerID;

import java.util.ArrayList;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public class PlayerAbilityAvailability {
    private PlayerID player;
    private ArrayList<LandProducerBuildAbility> buildAbilities = new ArrayList<>();

    protected void addToBuildAbilities(LandProducerBuildAbility buildAbility) {
        buildAbilities.add(buildAbility);
    }

    public void clearBuildAbilities() {
        buildAbilities.clear();
    }

    public ArrayList<LandProducerBuildAbility> getBuildAbilities() {
        return buildAbilities;
    }

    public void addBuildClayPit(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildStoneQuarry(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildWoodCutter(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildCoalBurner(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildNormalMine(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBigMine(LandProducerBuildAbility buildAbility) {}

    public void addGoldSpecializedMine(LandProducerBuildAbility buildAbility) {}

    public void addIronSpecializedMine(LandProducerBuildAbility buildAbility) {}

    public void addBuildMint(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildPaperMill(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildSawMill(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildStockExchange(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addBuildStoneFactory(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addTruckFactory(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }

    public void addWagonFactory(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }
}
