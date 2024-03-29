package org.edu.harbour.space.university;

public class Config {
    private int maximumPosition;
    private boolean valid = false;

    private Config(int maximumPosition) {
        this.maximumPosition = maximumPosition;
        this.valid = true;
    }

    public static Config parseArguments(String[] args) {
        int maxPos = -1;

        for (String arg : args) {
            if (arg.startsWith("maximum-position=")) {
                try {
                    maxPos = Integer.parseInt(arg.substring("maximum-position=".length()));
                    if (maxPos < 0 || maxPos > 100000) {
                        throw new IllegalArgumentException("Max position cant be more than 100000");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format " + e.getMessage());
                    System.exit(1);
                }
            }
        }

        return maxPos >= 0 ? new Config(maxPos) : new Config(-1);
    }

    public boolean isValid() {
        return valid;
    }

    public int getMaximumPosition() {
        return maximumPosition;
    }
}