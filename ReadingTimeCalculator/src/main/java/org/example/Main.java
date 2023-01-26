package org.example;

public class Main {
    public static void main(String[] args) {

        Page page = new Page("ReadingTimeCalculator/article.txt");
        Calculator calculator = new Calculator(page.scanPage());
        calculator.calculateTotalReadingTime();
        System.out.println(calculator);

    }
}