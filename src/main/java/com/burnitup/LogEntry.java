package com.burnitup;

import java.time.LocalDateTime;

/**
 * The LogEntry class represents a single logged event in the app.
 * This can be either a food item the user ate or an exercise they performed.
 * Each entry tracks what it was, how many calories were involved, and when it happened.
 */
public class LogEntry {
    private String type;              // Either "Food" or "Exercise"
    private String description;      // Name or description of the entry (e.g., "Banana" or "Running")
    private int calories;            // Calories consumed (food) or burned (exercise)
    private LocalDateTime timestamp; // The date and time the entry was logged

    /**
     * Constructor to create a new log entry.
     *
     * @param type        the type of log ("Food" or "Exercise")
     * @param description the description of the food or exercise
     * @param calories    the number of calories
     * @param timestamp   when the entry was created
     */
    public LogEntry(String type, String description, int calories, LocalDateTime timestamp) {
        this.type = type;
        this.description = description;
        this.calories = calories;
        this.timestamp = timestamp;
    }

    // Getter for the type of log
    public String getType() {
        return type;
    }

    // Setter for the type of log
    public void setType(String type) {
        this.type = type;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for calories
    public int getCalories() {
        return calories;
    }

    // Setter for calories
    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Getter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter for timestamp
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
