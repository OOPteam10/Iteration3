package model.resources;

import model.resources.Visitor.ResourceVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by cduica on 4/9/17.
*/
public class Coin extends Resource {


    //testing only
    public String toString(){
        return "Coins";
    }

    @Override
    public void accept(ResourceVisitor v) {
        v.visitCoin();
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitCoin();
    }
}
