package com.burnitup.gui;

import java.awt.*;
import javax.swing.*;

public class FoodLogPanel extends JPanel {
    public FoodLogPanel() {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Food Log", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.CENTER);
    }
}
