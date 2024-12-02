import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class StudentWindow extends JFrame {
    private JComboBox<String> ComboBox;
    private JTable JTable;
    private JButton CerrarSesionbtn;

    public StudentWindow() {
    	getContentPane().setBackground(new Color(176, 224, 230));
    	setIconImage(Toolkit.getDefaultToolkit().getImage(StudentWindow.class.getResource("/imagenes/logo.png")));
        setTitle("Vista Alumno");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel moduleLabel = new JLabel("Módulo:");
        moduleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        moduleLabel.setBounds(69, 29, 68, 25);
        getContentPane().add(moduleLabel);

        ComboBox = new JComboBox<>(new String[]{"Desarrollo de Interfaces", "Acceso de Datos", "Programación"});
        ComboBox.setBounds(131, 30, 150, 25);
        getContentPane().add(ComboBox);

        String[] columnNames = {"Asignatura", "Nota"};
        Object[][] data = {
            {"Desarrollo de Interfaces", "6.5"},
            {"Acceso de Datos", "8.0"},
            {"Programación", "9.3"}
        };

        CerrarSesionbtn = new JButton("Cerrar Sesión");
        CerrarSesionbtn.setBounds(130, 200, 120, 25);
        getContentPane().add(CerrarSesionbtn);
        
        JScrollPane JScrollPane = new JScrollPane();
        JScrollPane.setBounds(36, 82, 315, 74);
        getContentPane().add(JScrollPane);
        JTable = new JTable(data, columnNames);
        JTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
        JScrollPane.setViewportView(JTable);

        CerrarSesionbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginWindow().setVisible(true);
                dispose();
            }
        });
    }
}
