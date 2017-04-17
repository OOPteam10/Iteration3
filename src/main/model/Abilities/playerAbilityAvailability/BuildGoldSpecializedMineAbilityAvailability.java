package model.Abilities.playerAbilityAvailability;

import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildGoldSpecializedMineAbilityAvailability extends PlayerAbilityAvailabilityDecorator {
    public BuildGoldSpecializedMineAbilityAvailability(PlayerAbilityAvailability child) {
        super(child);
    }

    @Override
    public void addGoldSpecializedMine(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }
}
