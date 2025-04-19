package com.burnitup;

/**
 * BurnItUpApp is the main entry point of the application.
 *
 * This class contains the main method, which Java looks for when starting the program.
 * It simply creates an instance of AppController and tells it to run the app.
 */
public class BurnItUpApp {
    public static void main(String[] args) {
        // Create the controller that manages the flow of the app
        AppController controller = new AppController();

        // Start the app!
        controller.run();
    }
}
