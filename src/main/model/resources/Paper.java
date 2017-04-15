package model.resources;

import model.resources.Visitor.ResourceVisitor;

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
}
