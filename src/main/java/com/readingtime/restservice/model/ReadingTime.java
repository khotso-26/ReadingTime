package com.readingtime.restservice.model;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "readingtime", schema = "READING")
public class ReadingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int seconds;
    private int minutes;
    private String title;
    private String body;

    public ReadingTime() {
    }


    public ReadingTime(long id, int seconds, int minutes, String title, String body) {
        this.id = id;
        this.seconds = seconds;
        this.minutes = minutes;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "ReadingTime{" +
                "id=" + id +
                ", seconds=" + seconds +
                ", minutes=" + minutes +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingTime that = (ReadingTime) o;
        return id == that.id && seconds == that.seconds && minutes == that.minutes && Objects.equals(title, that.title) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seconds, minutes, title, body);
    }



}
