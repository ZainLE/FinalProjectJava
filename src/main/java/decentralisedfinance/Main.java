package decentralisedfinance;
import java.util.InputMismatchException;
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

