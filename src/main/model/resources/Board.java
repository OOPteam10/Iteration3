package model.resources;

import model.resources.Visitor.ResourceVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by cduica on 4/9/17.
 */

public class Board extends Resource implements PaperMillResource, CoalBurnerResource {

    //testing only
    public String toString(){
        return "Board";
    }

    @Override
    public void accept(ResourceVisitor v) {
        v.visitBoard();
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitBoard();
    }
}
