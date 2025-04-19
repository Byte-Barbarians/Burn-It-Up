package com.burnitup;

import java.util.ArrayList;
import java.util.List;

/**
 * The User class represents a user of the BurnItUp app. It holds personal information,
 * calorie logging data, and methods to calculate and update the user's daily calorie goal.
 */
public class User {
    private String name;
    private String gender;
    private double weight; // in pounds
    private double goalWeight; // in pounds
    private int height; // in inches
    private int age;
    private final List<LogEntry> logEntries = new ArrayList<>(); // List to hold the user's log entries (food/exercise)

    private double foodCaloriesLogged = 0; // Tracks the total calories logged for food (will eventually come from food logger)

    /**
     * Constructor for creating a new User object with the necessary details.
     * 
     * @param name the user's name
     * @param gender the user's gender (Male/Female)
     * @param weight the user's current weight in pounds
     * @param goalWeight the user's goal weight in pounds
     * @param height the user's height in inches
     * @param age the user's age in years
     */
    public User(String name, String gender, double weight, double goalWeight, int height, int age) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.goalWeight = goalWeight;
        this.height = height;
        this.age = age;
    }

    // Getters for retrieving the user's information
    public String getName() { return name; }
    public String getGender() { return gender; }
    public double getWeight() { return weight; }
    public double getGoalWeight() { return goalWeight; }
    public int getHeight() { return height; }
    public int getAge() { return age; }

    // Setters for modifying the user's information
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setGoalWeight(double goalWeight) { this.goalWeight = goalWeight; }
    public void setHeight(int height) { this.height = height; }
    public void setAge(int age) { this.age = age; }

    /**
     * Logs the calories of food consumed by the user.
     * This will be called when food is logged through the app.
     * 
     * @param calories the number of calories in the food consumed
     */
    public void logFoodCalories(double calories) {
        foodCaloriesLogged += calories; // Add the logged calories to the total
    }

    /**
     * Calculates how many calories are remaining in the user's daily calorie goal.
     * 
     * @return the remaining calories for the day
     */
    public double getCaloriesRemaining() {
        return getDailyCalorieGoal() - getTotalFoodCalories() + getTotalExerciseCalories();
    }

    /**
     * Calculates the user's daily calorie goal based on their Basal Metabolic Rate (BMR)
     * and their weight change goal.
     * 
     * @return the user's daily calorie goal
     */
    public double getDailyCalorieGoal() {
        double bmr = calculateBMR(); // Calculate the user's BMR (calories needed to maintain weight)
        double diff = goalWeight - weight; // Difference between goal weight and current weight

        if (Math.abs(diff) < 1) {
            return bmr; // If the user is already at their goal weight, their calorie goal is to maintain
        } else if (diff < 0) {
            return bmr - 500; // If the goal weight is lower, set the goal for weight loss (500 calorie deficit)
        } else {
            return bmr + 300; // If the goal weight is higher, set the goal for weight gain (300 calorie surplus)
        }
    }

    /**
     * Calculates the Basal Metabolic Rate (BMR) for the user, which is the number of calories
     * their body needs to maintain basic functions at rest.
     * 
     * BMR is calculated differently for males and females.
     * 
     * @return the user's BMR
     */
    private double calculateBMR() {
        double weightKg = weight * 0.453592; // Convert weight from pounds to kilograms
        double heightCm = height * 2.54; // Convert height from inches to centimeters

        if (gender.equalsIgnoreCase("Male")) {
            return 10 * weightKg + 6.25 * heightCm - 5 * age + 5; // BMR formula for men
        } else {
            return 10 * weightKg + 6.25 * heightCm - 5 * age - 161; // BMR formula for women
        }
    }

    /**
     * Adds a log entry (for either food or exercise) to the user's log entries.
     * 
     * @param entry the LogEntry object containing details of the food or exercise logged
     */
    public void addLogEntry(LogEntry entry) {
        logEntries.add(entry); // Add the new log entry to the list of log entries
    }

    /**
     * Gets all the log entries for the user, including both food and exercise logs.
     * 
     * @return the list of log entries
     */
    public List<LogEntry> getLogEntries() {
        return logEntries;
    }

    /**
     * Calculates the total number of calories consumed from food logs.
     * 
     * @return the total calories from food
     */
    public int getTotalFoodCalories() {
        return logEntries.stream()
                .filter(entry -> entry.getType().equalsIgnoreCase("Food")) // Filter food entries
                .mapToInt(LogEntry::getCalories) // Map the calories for each food entry
                .sum(); // Sum up the calories
    }

    /**
     * Calculates the total number of calories burned from exercise logs.
     * 
     * @return the total calories from exercise
     */
    public int getTotalExerciseCalories() {
        return logEntries.stream()
                .filter(entry -> entry.getType().equalsIgnoreCase("Exercise")) // Filter exercise entries
                .mapToInt(LogEntry::getCalories) // Map the calories for each exercise entry
                .sum(); // Sum up the calories
    }
}
