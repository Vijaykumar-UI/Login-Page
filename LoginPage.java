import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPage() {
        setTitle("Login Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Reduced margins
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Here, add your login logic
                System.out.println("Login Button Clicked");
                resetFields();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        container.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        container.add(loginButton, gbc);

        setVisible(true);
    }

    private void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
