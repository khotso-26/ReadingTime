package org.example;

import static java.lang.Math.*;

public class Calculator {

    public String totalWordCount;
    private String seconds;
    private String minutes;
    private int totalReadingTime;

    public void getSeconds() {

        seconds = String.valueOf(Integer.parseInt(seconds.substring(0,2)));
        if (Integer.parseInt(seconds) > 50) 
            this.minutes = String.valueOf(Integer.parseInt(minutes) + 1);
    }

    public Calculator(String[] data) {

        this.totalWordCount = String.valueOf(data.length/200d);
        String[] total = this.totalWordCount.split("\\.");
        this.seconds = String.valueOf(Integer.parseInt(total[1]) * 60);
        this.minutes = total[0];
    }

    public void calculateTotalReadingTime() {

        if (minutes.equals("0")) 
            getSeconds();
        else {
            getSeconds();
            String readingTime;
            readingTime = minutes + "." + seconds;
            totalReadingTime = round(Float.parseFloat(readingTime));
        }
    }

    public String toString() {

        if (totalReadingTime == 1)
            return "Total reading time [ " + totalReadingTime + " minute ]";
        else if (minutes.equals("0"))
            return "Total reading time [ " + totalReadingTime + " seconds ]";
        else if (!minutes.isEmpty() & Integer.parseInt(seconds) < 50)
            return "Total reading time [ " + totalReadingTime + " minutes : " + seconds + " seconds ]";
        return "Total reading time [ " + totalReadingTime + " minutes ]";
    }

  
}
