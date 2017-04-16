package model.Transporters;

import model.Animal;

import model.Managers.LandTransporterManager;

import model.TransporterControlAbilities.AddDonkeyToControlListAbility;
import model.TransporterControlAbilities.TransporterAbilityFactory;
import model.Transporters.Visitor.LandTransporterVisitor;
import model.structures.producers.Visitor.ProductVisitor;


/**
 * Created by hankerins on 4/8/17.
 */
public class Donkey extends LandTransporter implements Animal {

    @Override
    public void produceAbility(TransporterAbilityFactory f) {
        setAbility(f.makeDonkeyAbility(this));
    }
    /*@Override
    public Donkey reproduce() {
       return new Donkey();

    }*/

    @Override
    public void accept(LandTransporterVisitor v){
        v.visitDonkey(this);
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitDonkey(this);
    }
}
