package model.resources;

import model.resources.Visitor.ResourceVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by cduica on 4/9/17.
 */
public class Clay extends Resource {

    //testing only
    public String toString() {
        return "Clay";
    }

    @Override
    public void accept(ResourceVisitor v) {
        v.visitClay(this);
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitClay();
    }
}
