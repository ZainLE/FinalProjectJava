package org.edu.harbour.space.university.order;

public interface MatchingStrategy {
    boolean match(Order order, OrderRepo orderRepository, CurrentPosition currentPosition);
}
