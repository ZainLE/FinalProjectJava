package edu.harbourspace.university.matchingengine;

import edu.harbourspace.university.matchingengine.input.InputParser;
import edu.harbourspace.university.matchingengine.input.InputReader;
import edu.harbourspace.university.matchingengine.order.CancelOrder;
import edu.harbourspace.university.matchingengine.order.CreateOrder;
import edu.harbourspace.university.matchingengine.order.Order;

import java.util.ArrayList;
import java.util.List;

public class MatchingEngine {

    private final InputReader inputReader;
    private final InputParser inputParser;
    private final OrderManager orderManager;

    public MatchingEngine(InputReader inputReader, InputParser inputParser, edu.harbourspace.university.matchingengine.OrderManager orderManager) {
        this.inputReader = inputReader;
        this.inputParser = inputParser;
        this.orderManager = orderManager;
    }

    public List<Trade> run(long maxPosition) {
        List<Trade> trades = new ArrayList<>();
        while (true) {
            String input = inputReader.readInput();
            Order order = inputParser.parseInput(input);
            switch (order.getOrderType()) {
                case CREATE -> trades.addAll(orderManager.processOrder((CreateOrder) order));
                case CANCEL ->orderManager.processCancelOrder((CancelOrder) order);
            }
            // Somehow break here
        }
        return trades;
    }
}
