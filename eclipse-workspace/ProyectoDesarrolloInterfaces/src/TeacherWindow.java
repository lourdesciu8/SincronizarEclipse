import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class TeacherWindow extends JFrame {
    private JComboBox<String> moduleDropdown;
    private JList<String> studentList;
    private JTextField gradeField;
    private JButton saveButton;
    private JButton logoutButton;

    // Simulamos datos de alumnos matriculados en diferentes módulos
    private Map<String, String[]> moduleStudentsMap = new HashMap<>();

    public TeacherWindow() {
        // Simulamos la lista de alumnos por módulo (esto debería venir de una base de datos)
        moduleStudentsMap.put("Desarrollo de Interfaces", new String[]{"Alumno1", "Alumno2"});
        moduleStudentsMap.put("Acceso de Datos", new String[]{"Alumno3", "Alumno4"});
        moduleStudentsMap.put("Programación", new String[]{"Alumno5", "Alumno6"});

        setTitle("Gestión de Notas - Profesor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Desplegable para seleccionar el módulo
        JLabel moduleLabel = new JLabel("Módulo:");
        moduleLabel.setBounds(30, 30, 80, 25);
        getContentPane().add(moduleLabel);

        moduleDropdown = new JComboBox<>(new String[]{"Desarrollo de Interfaces", "Acceso de Datos", "Programación"});
        moduleDropdown.setBounds(120, 30, 150, 25);
        getContentPane().add(moduleDropdown);

        // Lista de alumnos que se actualiza según el módulo seleccionado
        JLabel studentLabel = new JLabel("Alumnos:");
        studentLabel.setBounds(30, 70, 80, 25);
        getContentPane().add(studentLabel);

        studentList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(studentList);
        scrollPane.setBounds(120, 70, 150, 100);
        getContentPane().add(scrollPane);

        // Campo de texto para la nota
        JLabel gradeLabel = new JLabel("Nota:");
        gradeLabel.setBounds(30, 190, 80, 25);
        getContentPane().add(gradeLabel);

        gradeField = new JTextField();
        gradeField.setBounds(120, 190, 150, 25);
        getContentPane().add(gradeField);

        // Botón para guardar la nota
        saveButton = new JButton("Guardar");
        saveButton.setBounds(84, 261, 100, 25);
        getContentPane().add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = studentList.getSelectedValue();
                String grade = gradeField.getText();
                if (selectedStudent != null && !grade.isEmpty()) {
                    // Guardar la nota en la base de datos (simulado con un mensaje)
                    JOptionPane.showMessageDialog(null, "Nota guardada para " + selectedStudent + ": " + grade);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un alumno y complete la nota.");
                }
            }
        });

        // Botón para cerrar sesión
        logoutButton = new JButton("Cerrar Sesión");
        logoutButton.setBounds(194, 261, 120, 25);
        getContentPane().add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginWindow().setVisible(true);
                dispose();
            }
        });

        // Actualizamos la lista de alumnos cuando se selecciona un módulo
        moduleDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedModule = (String) moduleDropdown.getSelectedItem();
                if (selectedModule != null) {
                    // Actualizar la lista de alumnos según el módulo seleccionado
                    studentList.setListData(moduleStudentsMap.get(selectedModule));
                }
            }
        });

        // Inicializamos la lista con los alumnos del primer módulo
        moduleDropdown.setSelectedIndex(0);
        studentList.setListData(moduleStudentsMap.get(moduleDropdown.getSelectedItem()));
    }

    public static void main(String[] args) {
        TeacherWindow teacherWindow = new TeacherWindow();
        teacherWindow.setVisible(true);
    }
}
