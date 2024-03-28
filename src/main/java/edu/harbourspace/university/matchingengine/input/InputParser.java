package edu.harbourspace.university.matchingengine.input;

import edu.harbourspace.university.matchingengine.order.CancelOrder;
import edu.harbourspace.university.matchingengine.order.CreateOrder;
import edu.harbourspace.university.matchingengine.order.Order;

public class InputParser {

    public Order parseInput(String input) {
        // You should return CreateOrder or CancelOrder
//        return new CancelOrder("id");
        return new CreateOrder("id");
    }
}
