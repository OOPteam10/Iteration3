package model.resources;

import model.resources.Visitor.ResourceVisitor;

/**
 * Created by cduica on 4/9/17.
 */
public class Stock extends Resource {

    //testing only
    public String toString(){
        return "Stock";
    }

    @Override
    public void accept(ResourceVisitor v) {
        v.visitStock();
    }
}
