package edu.harbourspace.university.matchingengine.order;

public class CreateOrder extends Order {
    // All info about price, qty...

    private final long qty;
    private final double price;
    //....

    public CreateOrder(String id, OrderType orderType) {
        super(id, orderType);
    }
}
