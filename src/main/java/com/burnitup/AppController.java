package com.burnitup;

import java.util.Scanner;

/**
 * AppController handles the overall flow of the BurnItUp app.
 *
 * It manages the initial greeting, user selection or creation,
 * and navigating through the main menu. This class ties everything together
 * and keeps the app running until the user decides to quit.
 */
public class AppController {
    // Scanner to read user input from the console
    private final Scanner scanner = new Scanner(System.in);

    // Handles storing and retrieving users
    private final UserService userService = new UserService();

    // Responsible for all user input steps like creating or selecting a user
    private final UserInputHandler inputHandler = new UserInputHandler(scanner, userService);

    // Displays and handles the main menu options (log food, exercise, etc.)
    private final MenuService menuService = new MenuService(scanner);

    /**
     * Starts the app experience. This is where the app flow begins.
     */
    public void run() {
        greetUser(); // Print a friendly welcome message

        // Keep the app running while the user wants to interact
        while (true) {
            // Ask the user to either select an existing user or create a new one
            User user = inputHandler.selectOrCreateUser();
            if (user == null) break; // If no user is returned, exit

            // Enter the main part of the app for this user (log food, view calories, etc.)
            menuService.handleMainMenu(user);

            // After finishing with one user, ask if they want to switch to another user
            System.out.println("\nDo you want to switch users? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) break; // Exit if they don’t want to switch
        }

        // Say goodbye and close out the app
        System.out.println("\nExiting Burn It Up App. Goodbye!\n");
        scanner.close();
    }

    /**
     * Greets the user with a welcome message when they launch the app.
     */
    private void greetUser() {
        System.out.println("\nWelcome to Burn It Up App!\n");
    }
}
