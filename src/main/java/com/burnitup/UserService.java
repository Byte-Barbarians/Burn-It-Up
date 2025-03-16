package com.burnitup;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    // Adds a new user to the collection
    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    // Retrieves a user by their name
    public User getUser(String name) {
        return users.get(name);
    }
}