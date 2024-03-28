package edu.harbourspace.university.matchingengine;
import edu.harbourspace.university.matchingengine.input.InputParser;
import edu.harbourspace.university.matchingengine.input.InputReader;
import edu.harbourspace.university.matchingengine.output.TradePrinter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if ("FINISH".equals(scanner.nextLine())) {
            // Add log message
            return;
        }
        long maxPosition = scanner.nextLong();

        InputReader inputReader = new InputReader(scanner);
        InputParser inputParser = new InputParser();
        OrderManager orderManager = new OrderManager(...);
        TradePrinter tradePrinter = new TradePrinter();
        MatchingEngine matchingEngine = new MatchingEngine(inputReader, inputParser, orderManager);
        tradePrinter.printTrades(matchingEngine.run(maxPosition));
    }
}
