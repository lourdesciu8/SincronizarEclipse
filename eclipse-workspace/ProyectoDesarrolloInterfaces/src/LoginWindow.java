import javax.swing.*;
import java.awt.event.*;

public class LoginWindow extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginWindow() {
        setTitle("Login");
        setSize(325, 202);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(30, 30, 80, 25);
        getContentPane().add(userLabel);

        userField = new JTextField();
        userField.setBounds(120, 30, 150, 25);
        getContentPane().add(userField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(30, 70, 80, 25);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 150, 25);
        getContentPane().add(passwordField);

        loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(100, 120, 120, 25);
        getContentPane().add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica de autenticación aquí
                String user = userField.getText();
                String password = new String(passwordField.getPassword());

                if (user.equals("profesor")) {
                    new TeacherWindow().setVisible(true);
                } else {
                    new StudentWindow().setVisible(true);
                }
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
    }
}
