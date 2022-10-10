package org.example;

import java.util.Arrays;

public class Calculator {
    public String totalWordCount;
    public final double totalReadTime;
    public Calculator(String data) {
        String[] words = data.split("\\s+");
        this.totalWordCount = String.valueOf(words.length/200d);
        this.totalReadTime = 0;
//        System.out.println(Arrays.toString(words));
//        System.out.println(totalWordCount);
//        System.out.println(totalReading());
    }

    public int totalReading() {
        String[] number = this.totalWordCount.split("\\.");
        int total = 0;
        if (number[0].equals("0")) total = Integer.parseInt(number[1]) * 60;
        else total = Integer.parseInt(number[0]);
        return total;
    }
}
