package com.burnitup.gui;

import java.awt.*;
import javax.swing.*;

public class ExerciseLogPanel extends JPanel {
    public ExerciseLogPanel() {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Exercise Log", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.CENTER);
    }
}
