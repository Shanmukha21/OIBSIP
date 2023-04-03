import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainInterface extends JFrame implements ActionListener {
    
    private JLabel balanceLabel, inputLabel;
    private JButton withdrawButton;
    private JTextField inputField;
    private JButton depositButton;
    private JButton logoutButton, transactionHistory, transferButton;
    private JPanel buttonPanel;
    private int balance = 1000;
    
    public MainInterface() {
        setTitle("ATM");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        balanceLabel = new JLabel("Current balance: $" + balance);
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        inputLabel = new JLabel("Enter amount:");
        inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputField = new JTextField(10);
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputField.setMaximumSize(inputField.getPreferredSize());

        withdrawButton = new JButton("Withdraw");
        // withdrawButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        withdrawButton.setMaximumSize(getMaximumSize());
        withdrawButton.addActionListener(this);
        
        depositButton = new JButton("Deposit");
        depositButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        depositButton.addActionListener(this);
        
        logoutButton = new JButton("Logout");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.addActionListener(this);

        transactionHistory = new JButton("Transaction History");
        transactionHistory.setAlignmentX(Component.CENTER_ALIGNMENT);
        transactionHistory.addActionListener(this);

        transferButton = new JButton("Transfer");
        transferButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        transferButton.addActionListener(this);


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(logoutButton);
        buttonPanel.add(transactionHistory);
        buttonPanel.add(transferButton);
        
        panel.add(Box.createVerticalGlue());
        panel.add(balanceLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());
        
        add(panel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            try {
                int amount = Integer.parseInt(inputField.getText());
                if (amount > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient funds!");
                } else {
                    balance -= amount;
                    balanceLabel.setText("Current Balance: $" + balance);
                    inputField.setText("");
                }
            } 
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            }
        } 
        else if (e.getSource() == depositButton) {
            try {
                int amount = Integer.parseInt(inputField.getText());
                balance += amount;
                balanceLabel.setText("Current Balance: $" + balance);
                inputField.setText("");
            } 
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            }
        
        } 
        else if (e.getSource() == logoutButton) {
            // Return to login interface
            LoginInterface loginInterface = new LoginInterface();
            loginInterface.setVisible(true);
            dispose(); // close main interface
        }
    }
}
