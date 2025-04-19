package com.burnitup;

import java.util.Scanner;

/**
 * The UserInputHandler class is responsible for managing the user's input for selecting or creating users.
 * It provides methods for reading input in a validated and controlled manner.
 */
public class UserInputHandler {
    private final Scanner scanner;
    private final UserService userService;

    /**
     * Constructor to initialize the scanner and user service.
     * 
     * @param scanner the scanner to read input
     * @param userService the user service for managing user data
     */
    public UserInputHandler(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
    }

    /**
     * This method allows the user to select an existing user or create a new one.
     * It will keep asking the user until a valid choice is made.
     * 
     * @return the selected or created user
     */
    public User selectOrCreateUser() {
        User user = null;

        while (user == null) {
            System.out.println("Select a user or create a new one:");
            System.out.println("1. Select existing user");
            System.out.println("2. Create new user");

            int choice = readInt(); // Read the user's choice

            if (choice == 1) {
                user = selectUser(); // Try to select an existing user
                if (user == null) {
                    System.out.println("User not found. Please create a new user.");
                }
            } else if (choice == 2) {
                user = createUser(); // If choice is 2, create a new user
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }

        return user; // Return the selected or created user
    }

    /**
     * Prompts the user to enter the name of an existing user.
     * If the user is found, returns that user.
     * 
     * @return the selected user, or null if not found
     */
    private User selectUser() {
        System.out.print("Enter the name of the existing user: ");
        String name = scanner.nextLine();
        return userService.getUser(name); // Try to fetch the user from the service
    }

    /**
     * Prompts the user to enter details for creating a new user.
     * Validates the input before proceeding.
     * 
     * @return the newly created user
     */
    private User createUser() {
        System.out.println("\nCreating a New User:");

        // Collect and validate the user's details one by one
        String name = readValidatedString("Name", "[a-zA-Z]+", "Use letters only, e.g., 'John'");
        String gender = readValidatedString("Gender", "Male|Female", "Use 'Male' or 'Female'");
        double weight = readDouble("Current Weight (pounds)");
        double goalWeight = readDouble("Goal Weight (pounds)");
        int height = readInt("Height (inches)");
        int age = readInt("Age");

        // Create the user and add them to the user service
        User user = new User(name, gender, weight, goalWeight, height, age);
        userService.addUser(user);
        return user;
    }

    /**
     * Reads a validated string input based on a regex pattern.
     * Repeats the prompt until the input is valid.
     * 
     * @param prompt the message to show the user
     * @param regex the regex pattern to match against
     * @param errorMessage the error message if validation fails
     * @return the validated string
     */
    private String readValidatedString(String prompt, String regex, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt + ": ");
            input = scanner.nextLine();
            if (input.matches(regex)) break; // Check if the input matches the pattern
            System.out.println("Invalid input. " + errorMessage); // If not, show an error message
        }
        return input;
    }

    /**
     * Reads a double input, ensuring it's a valid number.
     * Repeats the prompt until the input is valid.
     * 
     * @param prompt the message to show the user
     * @return the validated double value
     */
    private double readDouble(String prompt) {
        double value = 0;
        while (true) {
            System.out.print(prompt + ": ");
            try {
                value = Double.parseDouble(scanner.nextLine()); // Attempt to parse the input as a double
                break; // If successful, exit the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again."); // If parsing fails, show an error message
            }
        }
        return value;
    }

    /**
     * Reads an integer input, ensuring it's a valid number.
     * Repeats the prompt until the input is valid.
     * 
     * @param prompt the message to show the user
     * @return the validated integer value
     */
    private int readInt(String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt + ": ");
            try {
                value = Integer.parseInt(scanner.nextLine()); // Attempt to parse the input as an integer
                break; // If successful, exit the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again."); // If parsing fails, show an error message
            }
        }
        return value;
    }

    // Helper method to read an integer without a prompt message
    private int readInt() {
        return readInt(""); // Default empty string for the prompt
    }
}
