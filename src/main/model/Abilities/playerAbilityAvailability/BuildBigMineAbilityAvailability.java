package model.Abilities.playerAbilityAvailability;

import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildBigMineAbilityAvailability extends PlayerAbilityAvailabilityDecorator {
    public BuildBigMineAbilityAvailability(PlayerAbilityAvailability child) {
        super(child);
    }

    @Override
    public void addBigMine(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }
}
