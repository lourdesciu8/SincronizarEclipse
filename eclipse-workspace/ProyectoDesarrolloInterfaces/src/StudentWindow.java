import javax.swing.*;
import java.awt.event.*;

public class StudentWindow extends JFrame {
    private JComboBox<String> moduleDropdown;
    private JTable gradesTable;
    private JButton logoutButton;

    public StudentWindow() {
        setTitle("Vista Alumno");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel moduleLabel = new JLabel("Módulo:");
        moduleLabel.setBounds(30, 30, 80, 25);
        add(moduleLabel);

        moduleDropdown = new JComboBox<>(new String[]{"Desarrollo de Interfaces", "Acceso de Datos", "Programación"});
        moduleDropdown.setBounds(120, 30, 150, 25);
        add(moduleDropdown);

        String[] columnNames = {"Asignatura", "Nota"};
        Object[][] data = {
            {"Desarrollo de Interfaces", "6.5"},
            {"Acceso de Datos", "8.0"},
            {"Programación", "9.3"}
        };
        gradesTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(gradesTable);
        scrollPane.setBounds(30, 80, 300, 100);
        add(scrollPane);

        logoutButton = new JButton("Cerrar Sesión");
        logoutButton.setBounds(130, 200, 120, 25);
        add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginWindow().setVisible(true);
                dispose();
            }
        });
    }
}
