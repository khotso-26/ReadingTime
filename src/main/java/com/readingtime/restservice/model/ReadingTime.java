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

    public ReadingTime() {
    }

    public ReadingTime(long id, int seconds, int minutes) {
        this.id = id;
        this.seconds = seconds;
        this.minutes = minutes;
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

    @Override
    public String toString() {
        return "ReadingTime{" +
                "id=" + id +
                ", seconds=" + seconds +
                ", minutes=" + minutes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingTime that = (ReadingTime) o;
        return id == that.id && seconds == that.seconds && minutes == that.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seconds, minutes);
    }



}
