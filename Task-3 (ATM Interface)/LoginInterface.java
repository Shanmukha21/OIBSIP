import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginInterface extends JFrame implements ActionListener {
    
    private JLabel title;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton, exitButton;
    
    public LoginInterface() {
        setTitle("ATM Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 10));
        
        title = new JLabel("Enter your login information:");
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        
        
        panel.add(title);
        panel.add(new JLabel(""));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(loginButton);
        panel.add(new JLabel(""));
        panel.add(exitButton);
        
        add(panel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        
        String correctUsername = "user";
        String correctPassword = "pass";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Login successful!");
            MainInterface atm = new MainInterface();
            atm.setVisible(true);
            dispose();
        } 
        else {
            JOptionPane.showMessageDialog(null, "Invalid usernam or password. Please try again :(");
            
        }
    }
    
    public static void main(String[] args) {
        LoginInterface loginInterface = new LoginInterface();
        loginInterface.setVisible(true);
    }
}
