package edu.harbourspace.university.matchingengine.input;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readInput() {
        return scanner.nextLine();
    }
}
