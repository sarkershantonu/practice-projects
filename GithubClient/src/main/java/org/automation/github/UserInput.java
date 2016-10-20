package org.automation.github;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public final class UserInput {

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

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
                throw new RuntimeException(e);
            }
        } else {
            result = JOptionPane.showInputDialog(prompt);
        }

        return result;
    }

}
