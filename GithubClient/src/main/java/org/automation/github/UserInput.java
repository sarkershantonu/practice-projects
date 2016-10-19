package org.automation.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public final class UserInput {
    private static final Logger log = LoggerFactory.getLogger(UserInput.class);
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            log.error("Failed to set Look and Feel to system look and feel", e);
        }
    }

    public static final String getStringOption(String optionName) {
        final String prompt = "Enter " + optionName + ": ";
        String result = null;

        if (GraphicsEnvironment.isHeadless()) {
            System.out.print(prompt);
            try {
                result = new BufferedReader(new InputStreamReader(System.in)).readLine();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("Error reading user input [" + optionName + "]", e);
                throw new RuntimeException(e);
            }
        } else {
            result = JOptionPane.showInputDialog(prompt);
        }

        return result;
    }

}
