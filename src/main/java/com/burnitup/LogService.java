package com.burnitup;

import java.util.HashMap;
import java.util.Map;

public class LogService {
    private Map<String, LogHistory> userLogs;

    public LogService() {
        this.userLogs = new HashMap<>();
    }

    // Adds a log entry for a specific user
    public void addLogEntry(String userName, LogEntry logEntry) {
        userLogs.computeIfAbsent(userName, k -> new LogHistory()).addLogEntry(logEntry);
    }

    // Retrieves the log history for a specific user
    public LogHistory getLogHistory(String userName) {
        return userLogs.get(userName);
    }
}