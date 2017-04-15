package model.resources;

import model.DropOffAbilities.ResourceDropOffAbility;
import model.DropOffAbilities.WaterwayDiscardAbility;
import model.TileSubsystem.Sector;
import model.resources.Visitor.ResourceVisitor;
import model.TileSubsystem.Waterway;

import model.structures.producers.Product;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class Resource implements Product<Sector> {

    ResourceDropOffAbility rdoAbility;
    WaterwayDiscardAbility waterwayDiscardAbility;

    public void setRdoAbility(ResourceDropOffAbility rdoAbility) {
        this.rdoAbility = rdoAbility;
    }

    public void setWaterwayDiscardAbility(WaterwayDiscardAbility waterwayDiscardAbility) {
        this.waterwayDiscardAbility = waterwayDiscardAbility;
    }

    @Override
    public void dropOff(Sector s) {rdoAbility.execute(s);}
    public void dropOff(Waterway w) {
        waterwayDiscardAbility.execute(w);
    }

    public abstract void accept(ResourceVisitor v);
}
