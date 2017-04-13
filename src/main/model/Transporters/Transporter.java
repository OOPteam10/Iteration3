package model.Transporters;


import model.structures.producers.Product;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class Transporter<L> implements Product<L> {


    public abstract void dropOff(L l);
}
