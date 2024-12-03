import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignInPage extends JFrame {
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField registrationNoField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton signUpButton;

    public SignInPage() {
        setTitle("Sign In Page");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Reduced margins
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();

        JLabel registrationNoLabel = new JLabel("Registration No:");
        registrationNoField = new JTextField();

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField();

        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String lastName = lastNameField.getText();
                String registrationNo = registrationNoField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match");
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("userData.txt", true))) {
                        writer.write(name + "," + lastName + "," + registrationNo + "," + username + "," + password);
                        writer.newLine();
                        JOptionPane.showMessageDialog(null, "Sign-Up Successful");
                        resetFields();
                        dispose();
                        new LoginPage();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        container.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(registrationNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        container.add(registrationNoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        container.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        container.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        container.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        container.add(confirmPasswordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        container.add(confirmPasswordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        container.add(signUpButton, gbc);

        setVisible(true);
    }

    private void resetFields() {
        nameField.setText("");
        lastNameField.setText("");
        registrationNoField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public static void main(String[] args) {
        new SignInPage();
    }
}
