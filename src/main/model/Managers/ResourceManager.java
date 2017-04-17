package model.Managers;

import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.DropOffAbilities.ResourceDropOffAbility;
import model.DropOffAbilities.WaterwayDiscardAbility;
import model.TileSubsystem.Sector;
import model.resources.Resource;
import model.resources.Visitor.*;
import model.structures.producers.secondary.SecondaryProducer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hankerins on 4/12/17.
 */
public class ResourceManager extends ListManager<Sector, Resource> {
    ArrayList<LandProducerBuildAbility> landProducerBuildAbilities = new ArrayList<>();

    @Override
    public void add(Sector l, Resource r) {
        r.setRdoAbility(new ResourceDropOffAbility(r, this));
        r.setWaterwayDiscardAbility(new WaterwayDiscardAbility());
        super.add(l, r);
    }

    private void determineLandProducerBuildAbilities(Sector s) {
        ArrayList<LandProducerBuildAbilityVisitor> visitors = new ArrayList<>();
        populateProducerAbilityVisitors(visitors);

        for (LandProducerBuildAbilityVisitor v : visitors) {
            addVisitorBuildAbility(v, s);
        }
    }

    private void addVisitorBuildAbility(LandProducerBuildAbilityVisitor v, Sector s) {

        for (Resource r : get(s)) {
            r.accept(v);
        }
        LandProducerBuildAbility landProducerBuildAbility = v.makeAbility();
        if (landProducerBuildAbility != null) {
            landProducerBuildAbilities.add(landProducerBuildAbility);
        }
    }


    public void addProducerResourceVisitor(SecondaryProducer v, Sector s){
        if(getManagerMap().get(s)!=null) {
            for (Resource r : getManagerMap().get(s)) {
                r.accept(v);
            }
        }
    }
    
    public ArrayList<LandProducerBuildAbility> getLandProducerBuildAbilities(Sector s, PlayerAbilityAvailability playerAbilityAvailability) {
        landProducerBuildAbilities.clear();
        determineLandProducerBuildAbilities(s);
        for (BuildAbility b : landProducerBuildAbilities) {
            b.addToPlayerAbilityAvailabilityList(playerAbilityAvailability);
        }
        ArrayList<LandProducerBuildAbility> abilities = new ArrayList<>();

        for (LandProducerBuildAbility ability : playerAbilityAvailability.getBuildAbilities()) {
            abilities.add(ability);
        }

        playerAbilityAvailability.clearBuildAbilities();
        return abilities;
    }

    public ArrayList<LandProducerBuildAbilityVisitor> populateProducerAbilityVisitors(ArrayList<LandProducerBuildAbilityVisitor> visitors) {
        visitors.add(new BuildBigMineAbilityVisitor());
        visitors.add(new BuildClayPitAbilityVisitor());
        visitors.add(new BuildCoalBurnerAbilityVisitor());
        visitors.add(new BuildNormalMineAbilityVisitor());
        visitors.add(new BuildMintAbilityVisitor());
        visitors.add(new BuildPapermillAbilityVisitor());
        visitors.add(new BuildQuarryAbilityVisitor());
        visitors.add(new BuildSawmillAbilityVisitor());
        visitors.add(new BuildIronSpecializedMineAbilityVisitor());
        visitors.add(new BuildGoldSpecializedMineAbilityVisitor());
        visitors.add(new BuildStockExchangeAbilityVisitor());
        visitors.add(new BuildStoneFactoryAbilityVisitor());
        visitors.add(new BuildTruckFactoryAbilityVisitor());
        visitors.add(new BuildWagonFactoryAbilityVisitor());
        visitors.add(new BuildWoodcutterAbilityVisitor());
        return visitors;
    }

}
