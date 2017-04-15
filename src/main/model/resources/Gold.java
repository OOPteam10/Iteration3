package model.resources;

import model.resources.Visitor.ResourceVisitor;

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
        v.visitGold();
    }
}
