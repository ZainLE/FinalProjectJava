package org.edu.harbour.space.university.order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryrRepo implements OrderRepo {
    private final Map<String, Order> orders = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    @Override
    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public void removeOrder(String orderId) {
        orders.remove(orderId);
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orders.values();
    }
}