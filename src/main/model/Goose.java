package model;

import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by doug0_000 on 4/9/2017.
 */
public class Goose implements Animal {


    /*public Goose reproduce() {
        return new Goose();
    }*/

    public void accept(ProductVisitor visitor) {
        visitor.visitGoose();
    }
}
