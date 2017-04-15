package model.Transporters;

import model.Animal;
import model.Transporters.Visitor.LandTransporterVisitor;


/**
 * Created by hankerins on 4/8/17.
 */
public class Donkey extends LandTransporter implements Animal {


    /*@Override
    public Donkey reproduce() {
       return new Donkey();

    }*/

    @Override
    public void accept(LandTransporterVisitor v){
        v.visitDonkey(this);
    }

}
