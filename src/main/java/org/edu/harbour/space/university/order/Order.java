package org.edu.harbour.space.university.order;

public class Order {
    private final String orderId;
    private final boolean isBuy;
    private final int size;
    private final double price;
    private final String productId;
    private final String originator;


    public Order(String orderId, boolean isBuy, int size, double price, String productId, String originator) {
        this.orderId = orderId;
        this.isBuy = isBuy;
        this.size = size;
        this.price = price;
        this.productId = productId;
        this.originator = originator;
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }
    public String getOriginator() {
        return originator;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", isBuy=" + isBuy +
                ", size=" + size +
                ", price=" + price +
                ", productId='" + productId + '\'' +
                '}';
    }
}
