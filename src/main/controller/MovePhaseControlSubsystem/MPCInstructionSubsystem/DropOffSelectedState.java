package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.resources.Resource;
import model.structures.producers.Product;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/13/17.
 */
public class DropOffSelectedState implements MPCInstructionState {

    public ArrayList<Product> products;
    Product currentProduct;

    public DropOffSelectedState(MovePhaseControlMode context) {
        products = context.getCargoManager().get(context.getCurrentTransporter());
        currentProduct = products.get(0);
    }

    @Override
    public void cycleLeft(MovePhaseControlMode context) {
        int previous = (products.indexOf(currentProduct)-1 + products.size()) % products.size();
        currentProduct = products.get(previous);
    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {
        int next = (products.indexOf(currentProduct)+1) % products.size();
        currentProduct = products.get(next);
    }

    @Override
    public void select(MovePhaseControlMode context) {
        context.dropOff(currentProduct);
        context.resetCurrentMPCInstructionState();
    }

    //testing only
    public String toString(){
        return ("Drop Off " + currentProduct.toString());
    }
}
