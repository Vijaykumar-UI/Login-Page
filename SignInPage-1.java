import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SignInPage {
    private static Map<String, String[]> userData = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign In");
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(150, 20, 165, 25);
        panel.add(nameText);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 50, 80, 25);
        panel.add(lastNameLabel);

        JTextField lastNameText = new JTextField(20);
        lastNameText.setBounds(150, 50, 165, 25);
        panel.add(lastNameText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 80, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(150, 80, 165, 25);
        panel.add(emailText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 110, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 110, 165, 25);
        panel.add(passwordText);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(10, 140, 150, 25);
        panel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordText = new JPasswordField(20);
        confirmPasswordText.setBounds(150, 140, 165, 25);
        panel.add(confirmPasswordText);

        JButton signInButton = new JButton("Sign In");
        signInButton.setBounds(10, 180, 120, 25);
        panel.add(signInButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String lastName = lastNameText.getText();
                String email = emailText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmPasswordText.getPassword());

                if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "All fields are required!");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(panel, "Passwords do not match!");
                    return;
                }

                userData.put(email, new String[]{name, lastName, password});
                JOptionPane.showMessageDialog(panel, "Sign-In Successful!");
                
                // Close current frame
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                topFrame.dispose();

                // Open login page
                LoginPage loginPage = new LoginPage();
                loginPage.main(null);
            }
        });
    }

    public static Map<String, String[]> getUserData() {
        return userData;
    }
}
