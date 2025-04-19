package com.burnitup;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Handles user input related to logging food or exercise entries.
 * This class is responsible for collecting the necessary information
 * and creating a corresponding LogEntry object for the user.
 */
public class LogEntryHandler {
    private final Scanner scanner;

    // Constructor to initialize the scanner for user input
    public LogEntryHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Handles the logging process for either a food or exercise entry.
     * Based on the 'type' passed in, the function will ask for the appropriate input fields,
     * create a new LogEntry, and add it to the user's log.
     *
     * @param user the user who is logging the entry
     * @param type the type of entry to log ("Food" or "Exercise")
     */
    public void logEntry(User user, String type) {
        System.out.println("\nLogging " + type + ":");

        String description = ""; // This will be either the food name or the exercise name
        int calories = 0;

        if (type.equalsIgnoreCase("Food")) {
            // Prompt user for food-specific info
            System.out.print("Food Name: ");
            description = scanner.nextLine();

            // Repeatedly prompt until valid calorie number is entered
            while (true) {
                System.out.print("Calories: ");
                try {
                    calories = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number for calories.");
                }
            }

            // Prompt for serving size in ounces
            // This will need to be implemented in the database
            int servingSize = 0;
            while (true) {
                System.out.print("Serving Size (in ounces): ");
                try {
                    servingSize = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number for serving size.");
                }
            }

            // Create and log a food entry
            LogEntry foodEntry = new LogEntry(type, description, calories, LocalDateTime.now());
            user.addLogEntry(foodEntry);
            System.out.println("Food logged successfully!");

        } else if (type.equalsIgnoreCase("Exercise")) {
            // Prompt user for exercise-specific info
            System.out.print("Exercise Name: ");
            description = scanner.nextLine();

            // Repeatedly prompt until valid calorie number is entered
            while (true) {
                System.out.print("Calories Burned: ");
                try {
                    calories = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number for calories burned.");
                }
            }

            // Prompt for duration of the exercise
            // This will need to be implemented in the database
            int durationMinutes = 0;
            while (true) {
                System.out.print("Duration (in minutes): ");
                try {
                    durationMinutes = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number for duration in minutes.");
                }
            }

            // Create and log an exercise entry
            LogEntry exerciseEntry = new LogEntry(type, description, calories, LocalDateTime.now());
            user.addLogEntry(exerciseEntry);
            System.out.println("Exercise logged successfully!");
        }
    }
}
