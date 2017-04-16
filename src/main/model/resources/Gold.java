package model.resources;

import model.resources.Visitor.ResourceVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by cduica on 4/9/17.
 */
public class Gold extends Resource {

    //testing only
    public String toString(){
        return "Gold";
    }

    @Override
    public void accept(ResourceVisitor v) {
        v.visitGold(this);
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitGold();
    }
}
