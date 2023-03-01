package com.readingtime.restservice.model;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "reaingtime", schema = "USER_APP")
public class ReadingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

    public ReadingTime() {
    }

    public ReadingTime(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingTime that = (ReadingTime) o;
        return id == that.id && content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return "ReadingTime{" +
                "id=" + id +
                ", content=" + content +
                '}';
    }
}
