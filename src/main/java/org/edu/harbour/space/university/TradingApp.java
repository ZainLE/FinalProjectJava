package org.edu.harbour.space.university;

import org.edu.harbour.space.university.message.Message;
import org.edu.harbour.space.university.message.MessageGenerator;
import org.edu.harbour.space.university.order.*;

import java.util.Scanner;

public class TradingApp {
    private final OrderManager orderManager;

    public TradingApp(int maximumPosition) {
        MatchingStrategy matchingStrategy = new MatchingEng();
        OrderRepo orderRepository = new InMemoryrRepo();

        this.orderManager = new OrderManager(maximumPosition, matchingStrategy, orderRepository);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputLine = scanner.nextLine();
            if ("FINISH".equalsIgnoreCase(inputLine)) {
                break;
            }

            try {
                Message message = MessageGenerator.createMessage(inputLine);
                orderManager.processOrder(message);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        ReportGenerator.generateReport(orderManager.getExecutedOrders());
        scanner.close();
    }
}