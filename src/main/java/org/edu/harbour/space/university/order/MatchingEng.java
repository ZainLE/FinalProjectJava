package org.edu.harbour.space.university.order;

public class MatchingEng implements MatchingStrategy {
    @Override
    public boolean match(Order incomingOrder, OrderRepo orderRepository, CurrentPosition currentPosition) {

        if (!canMatchOrder(incomingOrder, currentPosition)) {
            return false;
        }

        int totalBuyQuantity = incomingOrder.isBuy() ? 0 : calculateTotalBuyQuantity(orderRepository);

        if ("VE".equals(incomingOrder.getOriginator()) && !incomingOrder.isBuy() && totalBuyQuantity < incomingOrder.getSize()) {
            System.out.println("\nNot enough quantity.");
            return false;
        }

        for (Order existingOrder : orderRepository.getAllOrders()) {
            if (isCounterpart(incomingOrder, existingOrder) && canExecuteTrade(incomingOrder, existingOrder, currentPosition)) {
                if (incomingOrder.isBuy() || totalBuyQuantity >= existingOrder.getSize()) {
                    executeTrade(incomingOrder, existingOrder, currentPosition);
                    orderRepository.removeOrder(existingOrder.getOrderId());
                    return true;
                } else {

                    return false;
                }
            }
        }

        if ("DF".equals(incomingOrder.getOriginator())) {
            orderRepository.addOrder(incomingOrder);
        }

        return false;
    }

    private boolean canMatchOrder(Order order, CurrentPosition currentPosition) {
        return (order.isBuy() && currentPosition.canBuy(order.getSize())) ||
                (!order.isBuy() && currentPosition.canSell(order.getSize()));
    }

    private boolean isCounterpart(Order incoming, Order existing) {
        return incoming.isBuy() != existing.isBuy() &&
                incoming.getProductId().equals(existing.getProductId());
    }

    private boolean canExecuteTrade(Order incomingOrder, Order existingOrder, CurrentPosition currentPosition) {
        return true;
    }

    private void executeTrade(Order incomingOrder, Order existingOrder, CurrentPosition currentPosition) {
        Order executedOrder = incomingOrder.isBuy() ? incomingOrder : existingOrder;
        double executionPrice = existingOrder.getPrice();

        if (incomingOrder.isBuy()) {
            currentPosition.buy(executedOrder.getSize());
        } else {
            currentPosition.sell(executedOrder.getSize());
        }
    }

    private int calculateTotalBuyQuantity(OrderRepo orderRepository) {
        int totalBuyQuantity = 0;
        for (Order order : orderRepository.getAllOrders()) {
            if (order.isBuy()) {
                totalBuyQuantity += order.getSize();
            }
        }
        return totalBuyQuantity;
    }
}
