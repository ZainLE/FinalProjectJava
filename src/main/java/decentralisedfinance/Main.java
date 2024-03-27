package decentralisedfinance;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxPosition = 0;

        while (true) {
            System.out.println("Enter maximum position:");
            String input = scanner.nextLine();

            try {
                maxPosition = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer value.");
            }
        }

        TradeManager tradeManager = new TradeManager(maxPosition);
        OrderBook orderBook = new OrderBook();

        while (true) {
            System.out.println("Enter trade message (or 'exit' to quit):");
            String inputMessage = scanner.nextLine();

            if (inputMessage.equals("exit")) {
                break;
            }

            String[] messageParts = inputMessage.split("\\s+");
            if (messageParts.length != 5) {
                System.out.println("Invalid trade message format. Please enter a valid trade message.");
                continue;
            }

            String source = messageParts[0];
            String side = messageParts[1];
            int size = Integer.parseInt(messageParts[2]);
            double price = Double.parseDouble(messageParts[3]);
            String productID = messageParts[4];

            Trade trade = new Trade(source, side, size, price, productID);
            tradeManager.processTrade(trade, orderBook);
        }

        System.out.println("Executed Trades:");
        for (Trade executedTrade : tradeManager.getExecutedTrades()) {
            System.out.println(executedTrade.toString());
        }

        scanner.close();
    }
}
