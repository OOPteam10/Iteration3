package model.Transporters;

import model.Animal;

import model.Managers.LandTransporterManager;

import model.Transporters.Visitor.TransporterVisitor;


/**
 * Created by hankerins on 4/8/17.
 */
public class Donkey extends LandTransporter implements Animal {


    /*@Override
    public Donkey reproduce() {
       return new Donkey();

    }*/

    @Override
    public void accept(TransporterVisitor v){
        v.visitDonkey(this);
    }

}
