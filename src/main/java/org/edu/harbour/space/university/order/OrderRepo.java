package org.edu.harbour.space.university.order;

import java.util.Collection;

public interface OrderRepo {
    void addOrder(Order order);
    Order getOrder(String orderId);
    void removeOrder(String orderId);
    Collection<Order> getAllOrders();
}



