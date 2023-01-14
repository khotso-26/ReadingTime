package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Page {
    private final StringBuilder words;
    private final File myObject;

    public Page(String fileName) {
        this.words = new StringBuilder();
        this.myObject = new File(fileName);
    }

    public String[] scanPage() {
        Scanner scanner;
        try {
            scanner = new Scanner(myObject);
            while(scanner.hasNextLine()) {
                words.append(scanner.nextLine());
            }
            scanner.close();
            return words.toString().split("\\s+");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
