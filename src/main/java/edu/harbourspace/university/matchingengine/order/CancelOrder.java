package edu.harbourspace.university.matchingengine.order;

public class CancelOrder extends Order {

    public CancelOrder(String id) {
        super(id, OrderType.CANCEL);
    }
}
