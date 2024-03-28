package edu.harbourspace.university.matchingengine;

import edu.harbourspace.university.matchingengine.order.CancelOrder;
import edu.harbourspace.university.matchingengine.order.CreateOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private final Map<String, OrderBook> orderBook;
    private int maxPosition;
    private List<Trade> executedTrades;

    public OrderManager(int maxPosition) {
        this.maxPosition = maxPosition;
        this.executedTrades = new ArrayList<>();
    }

    public List<Trade> processOrder(CreateOrder order) {
        if (order.getSource().equals("DF")) {
            if (canExecuteTrade(order, orderBook)) {
                executeTrade(order, orderBook);
            }
        } else {
            acceptOrRejectTrade(order, orderBook);
        }
    }

    public List<Trade> processCancelOrder(CancelOrder order) {
       // Process Cancel order
    }

    private boolean canExecuteTrade(Trade trade, OrderBook orderBook) {
        int currentPosition = orderBook.getCurrentPosition(trade.getProductID());
        if (trade.getSide().equals("BUY") && currentPosition + trade.getSize() > maxPosition) {
            System.out.println("Cannot execute trade: Maximum position reached for " + trade.getProductID());
            return false;
        }
        return true;
    }

    private void executeTrade(Trade trade, OrderBook orderBook) {
        orderBook.updatePosition(trade);
        executedTrades.add(trade);
    }

    private void acceptOrRejectTrade(Trade trade, OrderBook orderBook) {
        System.out.println("Trade accepted from external venue: " + trade.toString());
        orderBook.updatePosition(trade);
    }

    public List<Trade> getExecutedTrades() {
        return executedTrades;
    }
}
