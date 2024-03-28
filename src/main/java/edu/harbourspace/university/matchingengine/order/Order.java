package edu.harbourspace.university.matchingengine.order;

public abstract class Order {
    private final String id;
    private final Originator originator;
    private final OrderType orderType;

    public Order(String id, Originator originator, OrderType orderType) {
        this.id = id;
        this.originator = originator;
        this.orderType = orderType;
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
