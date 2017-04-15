package model.resources;

import model.resources.Visitor.ResourceVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by cduica on 4/9/17.
 */
public class Paper extends Resource {


    //testing only
    public String toString(){
        return "Paper";
    }

    @Override
    public void accept(ResourceVisitor v) {
        v.visitPaper();
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitPaper();
    }
}
