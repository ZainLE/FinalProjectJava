package org.edu.harbour.space.university.message;

public class OrderMessage extends Message {
    public OrderMessage(String originator, String messageId, boolean isBuy, int size, double price, String productId) {
        super(originator, messageId, isBuy, false, size, price, productId);
    }
}
