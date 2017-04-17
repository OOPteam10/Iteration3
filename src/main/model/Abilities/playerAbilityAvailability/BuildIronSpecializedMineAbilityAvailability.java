package model.Abilities.playerAbilityAvailability;

import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;

/**
 * Created by allisonaguirre on 4/16/17.
 */
public class BuildIronSpecializedMineAbilityAvailability extends PlayerAbilityAvailabilityDecorator {
    public BuildIronSpecializedMineAbilityAvailability(PlayerAbilityAvailability child) {
        super(child);
    }

    @Override
    public void addIronSpecializedMine(LandProducerBuildAbility buildAbility) {
        addToBuildAbilities(buildAbility);
    }
}
