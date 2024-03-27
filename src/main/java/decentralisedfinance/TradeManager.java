package decentralisedfinance;
import java.util.ArrayList;
import java.util.List;

public class TradeManager {
    private int maxPosition;
    private List<Trade> executedTrades;

    public TradeManager(int maxPosition) {
        this.maxPosition = maxPosition;
        this.executedTrades = new ArrayList<>();
    }

    public void processTrade(Trade trade, OrderBook orderBook) {
        if (trade.getSource().equals("DF")) {
            if (canExecuteTrade(trade, orderBook)) {
                executeTrade(trade, orderBook);
            }
        } else {
            acceptOrRejectTrade(trade, orderBook);
        }
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
