package com.burnitup;

/**
 * The Food class represents a food item that the user logs.
 *
 * Each food has a name, calorie count, and serving size (in ounces).
 * This helps the app calculate total calories consumed throughout the day.
 */
public class Food {
    private String name;        // Name of the food (e.g., "Chicken Breast", "Apple")
    private int calories;       // Calories per serving
    private int servingSize;    // Serving size in ounces

    /**
     * Constructor to create a new Food item.
     *
     * @param name         the name of the food
     * @param calories     the number of calories in the food
     * @param servingSize  the size of the serving (in ounces)
     */
    public Food(String name, int calories, int servingSize) {
        this.name = name;
        this.calories = calories;
        this.servingSize = servingSize;
    }

    // Getter for food name
    public String getName() {
        return name;
    }

    // Getter for calories
    public int getCalories() {
        return calories;
    }

    // Getter for serving size
    public int getServingSize() {
        return servingSize;
    }

    // Setter for food name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for calories
    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Setter for serving size
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    /**
     * Converts the food object into a string format.
     * Helpful for displaying food information or debugging.
     */
    @Override
    public String toString() {
        return "Food{name='" + name + "', calories=" + calories + ", servingSize=" + servingSize + "}";
    }
}
