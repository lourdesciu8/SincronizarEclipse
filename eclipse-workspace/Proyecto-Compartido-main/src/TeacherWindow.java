import javax.swing.*;
import model.Alumno;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class TeacherWindow extends JFrame {
    private JComboBox<String> ModulosComboBox;
    private JComboBox<String> AlumnosComboBox; // Nueva JComboBox para seleccionar el alumno
    private JTextField NotaTextField;
    private JButton Guardarbtn;
    private JButton CerrarSesionbtn;

    // Array de alumnos
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public TeacherWindow() {
        listaAlumnos.add(new Alumno("Pepe Perez"));
        listaAlumnos.add(new Alumno("Ana Gómez"));
        listaAlumnos.add(new Alumno("Juan Martínez"));
        listaAlumnos.add(new Alumno("María López"));
        listaAlumnos.add(new Alumno("Luis García"));
        listaAlumnos.add(new Alumno("Laura Torres"));

        getContentPane().setBackground(new Color(176, 224, 230));
        setIconImage(Toolkit.getDefaultToolkit().getImage(TeacherWindow.class.getResource("/imagenes/logo.png")));
        setTitle("Gestión de Notas - Profesor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Desplegable para seleccionar el módulo
        JLabel moduloLabel = new JLabel("Módulo:");
        moduloLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        moduloLabel.setBounds(30, 30, 80, 25);
        getContentPane().add(moduloLabel);

        ModulosComboBox = new JComboBox<>(new String[]{"Desarrollo de Interfaces", "Acceso de Datos", "Programación"});
        ModulosComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ModulosComboBox.setBounds(105, 30, 180, 25);
        getContentPane().add(ModulosComboBox);

        // Desplegable para seleccionar el alumno
        JLabel AlumnosLabel = new JLabel("Alumno:");
        AlumnosLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        AlumnosLabel.setBounds(30, 70, 80, 25);
        getContentPane().add(AlumnosLabel);

        AlumnosComboBox = new JComboBox<>();
        AlumnosComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        AlumnosComboBox.setBounds(105, 70, 180, 25);
        getContentPane().add(AlumnosComboBox);

        // Campo de texto para la nota
        JLabel NotaLabel = new JLabel("Nota:");
        NotaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        NotaLabel.setBounds(90, 120, 43, 25);
        getContentPane().add(NotaLabel);

        NotaTextField = new JTextField();
        NotaTextField.setBounds(143, 120, 106, 25);
        getContentPane().add(NotaTextField);

        // Botón para guardar la nota (Falta asociar el alumno al que pertenece la nota)
        Guardarbtn = new JButton("Guardar");
        Guardarbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Guardarbtn.setBounds(84, 180, 100, 25);
        getContentPane().add(Guardarbtn);

        Guardarbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // La idea es que aquí ya está seleccionado el módulo y getSelectedItem() nos devuelve el elemento seleccionado en el ComboBox
                String moduloSelec = (String) ModulosComboBox.getSelectedItem();
                String alumnoSelec = (String) AlumnosComboBox.getSelectedItem();
                String notaIngresada = NotaTextField.getText();

                double nota;
                try {
                    nota = Double.parseDouble(notaIngresada);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La nota no es válida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(null,
                        "Nota guardada:\n" +
                        "Módulo: " + moduloSelec + "\n" +
                        "Alumno: " + alumnoSelec + "\n" +
                        "Nota: " + notaIngresada);
            }
        });

        // Necesitamos saber de qué asignatura es la nota
        ModulosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAlumnos();
            }
        });

        actualizarAlumnos();

        // Botón para cerrar sesión
        CerrarSesionbtn = new JButton("Cerrar Sesión");
        CerrarSesionbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        CerrarSesionbtn.setBounds(194, 180, 120, 25);
        getContentPane().add(CerrarSesionbtn);

        CerrarSesionbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginWindow().setVisible(true);
                dispose();
            }
        });
    }

    // Actualizamos la lista de alumnos en función del módulo seleccionado
    private void actualizarAlumnos() {
        AlumnosComboBox.removeAllItems();
        for (Alumno alumno : listaAlumnos) {
            AlumnosComboBox.addItem(alumno.getNombre());
        }
    }

    public static void main(String[] args) {
        TeacherWindow teacherWindow = new TeacherWindow();
        teacherWindow.setVisible(true);
    }
}
