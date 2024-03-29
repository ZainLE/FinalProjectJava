package org.edu.harbour.space.university.order;

import org.edu.harbour.space.university.message.Message;
import org.edu.harbour.space.university.message.MessageReject;
import org.edu.harbour.space.university.message.OrderMessage;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private final int maximumPosition;
    private final MatchingStrategy matchingStrategy;
    private final OrderRepo orderRepository;
    private final CurrentPosition currentPosition;
    private final List<Order> executedOrders = new ArrayList<>();

    public OrderManager(int maximumPosition, MatchingStrategy matchingStrategy, OrderRepo orderRepository) {
        this.maximumPosition = maximumPosition;
        this.matchingStrategy = matchingStrategy;
        this.orderRepository = orderRepository;
        this.currentPosition = new CurrentPosition(maximumPosition);
    }

    public void processOrder(Message message) {
        if (message instanceof MessageReject) {
            MessageReject cancelMessage = (MessageReject) message;
            orderRepository.removeOrder(cancelMessage.getMessageId());
        } else if (message instanceof OrderMessage) {
            OrderMessage orderMessage = (OrderMessage) message;
            Order order = new Order(orderMessage.getMessageId(), orderMessage.isBuy(),
                    orderMessage.getSize(), orderMessage.getPrice(),
                    orderMessage.getProductId(), orderMessage.getOriginator());

            boolean matched = matchingStrategy.match(order, orderRepository, currentPosition);
            if (matched) {
                executedOrders.add(order);
            } else if ("VE".equals(order.getOriginator())) {
                System.out.println("\nDropping unmatchable VE order: " + order);
            } else {
                orderRepository.addOrder(order);
            }
        }
    }

    public List<Order> getExecutedOrders() {
        return new ArrayList<>(executedOrders);
    }
}
