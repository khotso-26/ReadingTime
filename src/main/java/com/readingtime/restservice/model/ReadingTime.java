package com.readingtime.restservice.model;

import jakarta.persistence.*;


@Entity
@Table
public class ReadingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

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
    public String toString() {
        return "ReadingTime{" +
                "id=" + id +
                ", content=" + content +
                '}';
    }
}
