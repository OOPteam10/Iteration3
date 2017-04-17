package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import model.structures.producers.Product;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/13/17.
 */
public class DropOffSelectedState implements MPCInstructionState<MovePhaseControlMode> {

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

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.highlightCurrentProduct(currentProduct);
        }
    }

    //testing only
    public String toString(){
        return ("Drop Off " + currentProduct.toString());
    }
}
