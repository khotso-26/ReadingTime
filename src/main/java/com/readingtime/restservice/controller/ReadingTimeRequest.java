package com.readingtime.restservice.controller;

public record ReadingTimeRequest(String body, String title, int speed) {
}
