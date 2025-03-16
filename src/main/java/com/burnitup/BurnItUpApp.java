package com.burnitup;

import java.util.Scanner;

public class BurnItUpApp {
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        greetUser(); // begin program by greeting user
        Scanner scanner = new Scanner(System.in);

        // loop to select or create user
        while (true) {
            // select or create user by calling selectOrCreateUser() method
            User user = selectOrCreateUser(scanner);

            // display user information for selected user
            System.out.println("\nSelected User: " + user.getName());
            System.out.println(user.getAge() + " years old, " + user.getGender() + ", " + user.getWeight() + " pounds, " + user.getHeight() + " inches\n");

            // reprompt user selection/creation
            System.out.println("Do you want to select or create another user? (yes/no)");
            String response = scanner.nextLine();
            // if yes, reprompt user selection/creation, if no or other response, exit program
            if (response.equalsIgnoreCase("yes")) {
                continue;
            } else if (response.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Invalid response.");
                break;
            }
        }
        // exit program
        scanner.close();
        System.out.println("\nExiting Burn It Up App. Goodbye!\n");
    }

    // greet user method
    private static void greetUser() {
        System.out.println("\nWelcome to Burn It Up App!\n");
    }

    // select or create user method
    private static User selectOrCreateUser(Scanner scanner) {
        User user = null;
        while (user == null) {
            System.out.println("Select a user or create a new one:");
            System.out.println("1. Select existing user");
            System.out.println("2. Create new user");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // if 1, then select user. if user does not exist, create new user
            // if 2, then create new user
            if (choice == 1) {
                user = selectUser(scanner);
                // if user does not exist, create new user
                if (user == null) {
                    System.out.println("Please create a new user.");
                    user = createUser(scanner);
                }
            } else if (choice == 2) {
                user = createUser(scanner);
            } else {
                System.out.println("Invalid choice.");
            }
        }
        return user;
    }

    // select user method
    private static User selectUser(Scanner scanner) {
        System.out.println("\nEnter the name of the existing user:");
        String userName = scanner.nextLine();
        // get user by name, if user does not exist, return null
        User user = userService.getUser(userName);
        if (user != null) {
            return user;
        } else {
            System.out.println("\nUser not found.\n");
            return null;
        }
    }

    // create user method
    private static User createUser(Scanner scanner) {
        System.out.println("\nPlease fill out the following fields to Create a New User:");

        // get the user's name, if not a string then reprompt user
        String name = "";
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine();
            if (name.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Invalid field type, try again using a name like 'John' or 'Adam'");
            }
        }

        // get the user's gender, if not Male or Female then reprompt user
        String gender = "";
        while (true) {
            System.out.print("Gender: ");
            gender = scanner.nextLine();
            if (gender.matches("Male|Female")) {
                break;
            } else {
                System.out.println("Invalid field type, try again using 'Male' or 'Female'");
            }
        }

        // get the user's weight, if not a double then reprompt user
        double weight = 0;
        while (true) {
            System.out.print("Weight (pounds): ");
            try {
                weight = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Invalid field type, try again using a number like '150' or '200.4'");
                scanner.nextLine(); // Consume newline
            }
        }

        // get the user's height, if not an int then reprompt user
        int height = 0;
        while (true) {
            System.out.print("Height (inches): ");
            try {
                height = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid field type, try again using a number like '60' or '72'");
                scanner.nextLine(); // Consume newline
            }
        }

        // get the user's age, if not an int then reprompt user
        int age = 0;
        while (true) {
            System.out.print("Age: ");
            try {
                age = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid field type, try again using a number like '25' or '30'");
                scanner.nextLine(); // Consume newline
            }
        }

        scanner.nextLine(); // Consume newline after reading int

        User user = new User(name, gender, weight, height, age); // create new user object with inputted fields
        userService.addUser(user); // add user to the collection
        return user;
    }
}