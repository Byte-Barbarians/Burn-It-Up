package com.burnitup;

import java.time.LocalDateTime;

public class LogEntry {
    private String type;
    private String description;
    private int calories;
    private LocalDateTime timestamp;

    public LogEntry(String type, String description, int calories, LocalDateTime timestamp) {
        this.type = type;
        this.description = description;
        this.calories = calories;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}