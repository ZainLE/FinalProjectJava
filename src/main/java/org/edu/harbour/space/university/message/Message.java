package org.edu.harbour.space.university.message;

public class Message {
    private String originator;
    private String messageId;
    private boolean isBuy;
    private int size;
    private double price;
    private String productId;
    private boolean isCancel;

    public Message(String originator, String messageId, boolean isBuy, boolean isCancel,  int size, double price, String productId) {
        this.originator = originator;
        this.messageId = messageId;
        this.isBuy = isBuy;
        this.size = size;
        this.price = price;
        this.productId = productId;
        this.isCancel = isCancel;
    }

    public String getOriginator() { return originator; }
    public String getMessageId() { return messageId; }
    public boolean isBuy() { return isBuy; }
    public boolean isCancel() { return  isCancel; }
    public int getSize() { return size; }

    public void setSize(int _size) { size = _size; }
    public double getPrice() { return price; }
    public String getProductId() { return productId; }
}
