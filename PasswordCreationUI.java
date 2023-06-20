import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordCreationUI extends JFrame {
    private final JLabel passwordLabel;
    private final JPasswordField passwordField;
    private final JButton createButton;
    private final JLabel resultLabel;

    public PasswordCreationUI() {
        setTitle("Password Creation");
        setSize(950, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        passwordLabel = new JLabel("Create password:");
        passwordField = new JPasswordField(15);
        createButton = new JButton("Create");
        resultLabel = new JLabel("");


        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                String passwordString = new String(password);

                boolean passwordCheck = true;

                int symbolCount = 0;
                int capitalCount = 0;
                int numberCount = 0;
                int lowerCount = 0;
                boolean passwordLength = false;

                for (int i = 0; i < passwordString.length(); i++) {
                    if (!Character.isDigit(passwordString.charAt(i))
                            && !Character.isLetter(passwordString.charAt(i))
                            && !Character.isWhitespace(passwordString.charAt(i))) {
                        symbolCount++;
                    }
                    if (Character.isUpperCase(passwordString.charAt(i))) {
                        capitalCount++;
                    }
                    if (Character.isLowerCase(passwordString.charAt(i))) {
                        lowerCount++;
                    }
                    if (Character.isDigit(passwordString.charAt(i))) {
                        numberCount++;
                    }
                    if (passwordString.length() >= 8) {
                        passwordLength = true;
                    }
                }

                if (symbolCount >= 1 && capitalCount >= 1 && numberCount >= 1 && lowerCount >= 1 && passwordLength) {
                    resultLabel.setText("                                                                                   Valid Password                                                                                   ");
                    System.out.println("Password Created: " + passwordString);
                    passwordCheck = false;
                } else {
                    StringBuilder errorMessage = new StringBuilder("                                                                                           Invalid Password: ");

                    if (symbolCount < 1) {
                        errorMessage.append("No Symbols Found, ");

                    }
                    if (capitalCount < 1) {
                        errorMessage.append("No Capital Letter Found, ");
                    }
                    if (numberCount < 1) {
                        errorMessage.append("No Number Found, ");
                    }
                    if (lowerCount < 1) {
                        errorMessage.append("No Lower Case Letter Found, ");
                    }
                    if (!passwordLength) {
                        errorMessage.append("Password not 8 characters long, ");
                    }
                    errorMessage.append("Try Again.                                                                                           ");
                    resultLabel.setText(errorMessage.toString());
                }
            }
        });

        add(passwordLabel);
        add(passwordField);
        add(createButton);
        add(resultLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordCreationUI().setVisible(true);
            }
        });
    }
}