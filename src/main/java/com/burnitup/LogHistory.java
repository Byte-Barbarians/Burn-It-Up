package com.burnitup;

import java.util.ArrayList;
import java.util.List;

public class LogHistory {
    private List<LogEntry> logEntries;

    public LogHistory() {
        this.logEntries = new ArrayList<>();
    }

    public void addLogEntry(LogEntry logEntry) {
        logEntries.add(logEntry);
    }

    public List<LogEntry> getLogEntries() {
        return logEntries;
    }
}