package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import controller.MovePhaseControlSubsystem.SeaTransporterMPCMode;
import model.structures.producers.Product;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/16/17.
 */
public class WaterwayDropOffSelectedState implements SeaTransporterMPCIState {

    public ArrayList<Product> products;
    Product currentProduct;

    public WaterwayDropOffSelectedState(SeaTransporterMPCMode context) {
        products = context.getCargoManager().get(context.getCurrentTransporter());
        currentProduct = products.get(0);
    }

    @Override
    public void cycleLeft(SeaTransporterMPCMode context) {
        int previous = (products.indexOf(currentProduct)-1 + products.size()) % products.size();
        currentProduct = products.get(previous);
    }

    @Override
    public void cycleRight(SeaTransporterMPCMode context) {
        int next = (products.indexOf(currentProduct)+1) % products.size();
        currentProduct = products.get(next);
    }

    @Override
    public void select(SeaTransporterMPCMode context) {
        context.waterwayDropOff(currentProduct);
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
        return ("Waterway Drop Off " + currentProduct.toString());
    }
}
