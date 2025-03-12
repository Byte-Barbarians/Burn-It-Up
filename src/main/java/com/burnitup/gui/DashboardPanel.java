package com.burnitup.gui;

import java.awt.*;
import javax.swing.*;

public class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.CENTER);
    }
}
