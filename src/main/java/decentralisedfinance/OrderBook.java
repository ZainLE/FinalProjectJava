package decentralisedfinance;

import java.util.HashMap;
import java.util.Map;

public class OrderBook {
    private Map<String, Integer> currentPositionMap;

    public OrderBook() {
        this.currentPositionMap = new HashMap<>();
    }

    public int getCurrentPosition(String productID) {
        return currentPositionMap.getOrDefault(productID, 0);
    }

    public void updatePosition(Trade trade) {
        String productID = trade.getProductID();
        int currentPosition = currentPositionMap.getOrDefault(productID, 0);

        if (trade.getSide().equals("BUY")) {
            currentPosition += trade.getSize();
        } else {
            currentPosition -= trade.getSize();
        }

        currentPositionMap.put(productID, currentPosition);
        System.out.println("Position updated for " + productID + ": " + currentPosition);
    }
}
