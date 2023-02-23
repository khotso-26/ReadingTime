package com.readingtime.restservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class ReadingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Calculator content;

    public ReadingTime(long id, Calculator content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public Calculator getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(Calculator content) {
        this.content = content;
    }
}
