package org.edu.harbour.space.university.order;

public class CurrentPosition {
    private int currentPosition = 0;
    private final int maximumPosition;

    public CurrentPosition(int maximumPosition) {
        this.maximumPosition = maximumPosition;
    }

    public synchronized boolean canBuy(int size) {
        return currentPosition + size <= maximumPosition;
    }

    public synchronized boolean canSell(int size) {
        return currentPosition - size >= -maximumPosition;
    }

    public synchronized void buy(int size) {
        if (canBuy(size)) {
            currentPosition += size;
        } else {
            throw new IllegalStateException("It is more than Max position.");
        }
    }

    public synchronized void sell(int size) {
        if (canSell(size)) {
            currentPosition -= size;
        } else {
            throw new IllegalStateException("Attempt to sell exceeds maximum position limit.");
        }
    }

    public synchronized int getCurrentPosition() {
        return currentPosition;
    }
}
