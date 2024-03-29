package org.edu.harbour.space.university.message;

public class MessageGenerator {

    public static Message createMessage(String inputLine) {
        String[] parts = inputLine.trim().split("\\s+");

        if (parts.length == 0) {
            throw new IllegalArgumentException("There is no input.");
        }

        String originator = parts[0];
        String messageId = parts[1];

        if (parts.length == 3 && "cancel".equalsIgnoreCase(parts[2])) {
            return new MessageReject(originator, messageId);
        } else if (parts.length == 6) {
            boolean isBuy = "BUY".equalsIgnoreCase(parts[2]);
            int size = Integer.parseInt(parts[3]);
            double price = Double.parseDouble(parts[4]);
            String productId = parts[5];
            return new OrderMessage(originator, messageId, isBuy, size, price, productId);
        } else {
            throw new IllegalArgumentException("Invalid message format");
        }
    }
}