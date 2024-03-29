package org.edu.harbour.space.university;

import org.edu.harbour.space.university.message.Message;
import org.edu.harbour.space.university.order.Order;

import java.util.List;

public class ReportGenerator {
    public static void generateReport(List<Order> executedOrders) {
        for (Order order : executedOrders) {
            System.out.printf("%s\t%d\t%.2f\t%s\n",
                    "BUY",
                    order.getSize(),
                    order.getPrice(),
                    order.getProductId());
        }
    }
}

