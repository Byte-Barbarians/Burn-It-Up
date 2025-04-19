package com.burnitup;

/**
 * The Exercise class represents a physical activity that the user logs.
 *
 * Each exercise has a name, the number of calories it burns, and how long it lasted (in minutes).
 * This data helps the app update the user's remaining daily calories.
 */
public class Exercise {
    private String name;     // Name of the exercise (e.g., "Running", "Cycling")
    private int calories;    // Calories burned from the exercise
    private int time;        // Time spent exercising in minutes

    /**
     * Constructor to create a new Exercise.
     *
     * @param name     the name of the exercise
     * @param calories the number of calories burned
     * @param time     the time spent doing the exercise (in minutes)
     */
    public Exercise(String name, int calories, int time) {
        this.name = name;
        this.calories = calories;
        this.time = time;
    }

    // Getter for the exercise name
    public String getName() {
        return name;
    }

    // Getter for calories burned
    public int getCalories() {
        return calories;
    }

    // Getter for time spent exercising
    public int getTime() {
        return time;
    }

    // Setter for exercise name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for calories burned
    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Setter for time spent
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Nicely formats the exercise data as a string.
     * Useful for debugging or displaying to the user.
     */
    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", time=" + time +
                '}';
    }
}
