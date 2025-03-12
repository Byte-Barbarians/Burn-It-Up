package com.burnitup.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainFrame() {
        setTitle("Burn It Up - Calorie Tracker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add Panels
        DashboardPanel dashboard = new DashboardPanel();
        FoodLogPanel foodLog = new FoodLogPanel();
        ExerciseLogPanel exerciseLog = new ExerciseLogPanel();

        mainPanel.add(dashboard, "Dashboard");
        mainPanel.add(foodLog, "FoodLog");
        mainPanel.add(exerciseLog, "ExerciseLog");

        // Navigation Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Navigate");
        
        JMenuItem dashboardItem = new JMenuItem("Dashboard");
        dashboardItem.addActionListener(e -> cardLayout.show(mainPanel, "Dashboard"));

        JMenuItem foodLogItem = new JMenuItem("Food Log");
        foodLogItem.addActionListener(e -> cardLayout.show(mainPanel, "FoodLog"));

        JMenuItem exerciseLogItem = new JMenuItem("Exercise Log");
        exerciseLogItem.addActionListener(e -> cardLayout.show(mainPanel, "ExerciseLog"));

        menu.add(dashboardItem);
        menu.add(foodLogItem);
        menu.add(exerciseLogItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
