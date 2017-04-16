package controller.BuildPhaseControlSubsystem;

import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandBuildAbility;

/**
 * Created by hankerins on 4/16/17.
 */
public interface BPCAbilityStrategy<T extends LandBuildAbility> {
    void execute();
}
