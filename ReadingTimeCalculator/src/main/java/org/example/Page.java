package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Page {
    File myObject;
    Scanner scanner;

    public Page(String fileName){
        this.myObject = new File(fileName);
    }

    public String data(){
        try {
            String string = null;
            scanner = new Scanner(myObject);
            while(scanner.hasNextLine()){
                string = scanner.nextLine();
            }
            scanner.close();
            return string;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
