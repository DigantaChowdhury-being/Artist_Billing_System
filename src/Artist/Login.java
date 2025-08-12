package Artist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public Login() {
        setTitle("Artist Billing System Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Layout
        setLayout(new GridLayout(3, 2));

        // Components
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        // Add to frame
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(new JLabel());
        add(loginBtn);

        // Center the window on screen
        setLocationRelativeTo(null);

        // Login logic without lambda
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pass = new String(passField.getPassword());

                if (user.equals("Osthirproject") && pass.equals("12345")) {
                    JOptionPane.showMessageDialog(Login.this, "Login successful!");
                    dispose();  // Close login window
                    Main.startConsoleApp();  // Switch to console
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid credentials.");
                }
            }
        });

        setVisible(true);
    }
}
