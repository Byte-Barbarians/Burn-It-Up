package com.burnitup;

import java.util.Scanner;

/**
 * This class is responsible for displaying the main menu options to the user
 * and handling their choices. It acts as the main interaction layer between
 * the user and the features like logging food, exercise, switching users,
 * or updating personal information.
 */
public class MenuService {
    private final Scanner scanner;

    // Constructor to initialize the scanner used for user input
    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Displays the main menu to the user and handles their selection.
     * Options include logging food or exercise, switching users, updating user info,
     * or quitting the app.
     *
     * @param user the currently active user interacting with the app
     */
    public void handleMainMenu(User user) {
        LogEntryHandler logEntryHandler = new LogEntryHandler(scanner); // handles food/exercise logging

        while (true) {
            // Display greeting and calorie summary
            System.out.println("\nHello " + user.getName() + "!");
            System.out.println("Calorie Summary: " + (int) user.getCaloriesRemaining() + " Calories Remaining");
            System.out.println("\nSelect one of the following options:");
            System.out.println("1. Log Food");
            System.out.println("2. Log Exercise");
            System.out.println("3. Switch User");
            System.out.println("4. Update User Information");
            System.out.println("5. Quit BurnItUp");

            int choice = readInt();

            switch (choice) {
                case 1:
                    logEntryHandler.logEntry(user, "Food"); // Let user log food
                    break;
                case 2:
                    logEntryHandler.logEntry(user, "Exercise"); // Let user log exercise
                    break;
                case 3:
                    return; // Go back to user selection (handled in AppController)
                case 4:
                    updateUserInfo(user); // Allow user to edit personal info
                    break;
                case 5:
                    System.out.println("Thanks for using BurnItUp!");
                    System.exit(0); // Close the app
                default:
                    System.out.println("Invalid choice. Try again."); // Catch invalid input
            }
        }
    }

    /**
     * Helper method to safely read an integer from user input.
     * Continues prompting until a valid number is entered.
     */
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Lets the user update any part of their personal profile (name, gender, weight, etc.).
     * Each field is optional—if the user hits enter without typing anything, it will be skipped.
     *
     * @param user the user whose data is being updated
     */
    private void updateUserInfo(User user) {
        System.out.println("\nUpdating user information...");

        // Name
        System.out.print("New Name (Leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            user.setName(newName);
        }

        // Gender
        System.out.print("New Gender (Male/Female, Leave blank to keep current): ");
        String newGender = scanner.nextLine();
        if (!newGender.isEmpty()) {
            user.setGender(newGender);
        }

        // Weight
        System.out.print("New Weight (pounds, Leave blank to keep current): ");
        String newWeight = scanner.nextLine();
        if (!newWeight.isEmpty()) {
            try {
                user.setWeight(Double.parseDouble(newWeight));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for weight.");
            }
        }

        // Height
        System.out.print("New Height (inches, Leave blank to keep current): ");
        String newHeight = scanner.nextLine();
        if (!newHeight.isEmpty()) {
            try {
                user.setHeight(Integer.parseInt(newHeight));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for height.");
            }
        }

        // Age
        System.out.print("New Age (Leave blank to keep current): ");
        String newAge = scanner.nextLine();
        if (!newAge.isEmpty()) {
            try {
                user.setAge(Integer.parseInt(newAge));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for age.");
            }
        }

        // Goal Weight
        System.out.print("New Goal Weight (Leave blank to keep current): ");
        String newGoalWeight = scanner.nextLine();
        if (!newGoalWeight.isEmpty()) {
            try {
                user.setGoalWeight(Double.parseDouble(newGoalWeight));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for goal weight.");
            }
        }

        System.out.println("\nUser information updated successfully!");
    }
}
