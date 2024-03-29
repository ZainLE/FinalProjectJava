package org.edu.harbour.space.university;

public class Main {
    public static void main(String[] args) {
        Config config = Config.parseArguments(args);
        if (!config.isValid()) {
            System.err.println("Error: Max position is not invalid.");
            System.exit(1);
        }

        TradingApp app = new TradingApp(config.getMaximumPosition());
        app.run();
    }
}

