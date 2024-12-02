import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class TeacherWindow extends JFrame {
    private JComboBox<String> ModulosComboBox;
    private JTextField NotaTextField;
    private JButton Guardarbtn;
    private JButton CerrarSesionbtn;

    public TeacherWindow() {
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

        // Etiqueta para la lista de alumnos
        JLabel AlumnosLabel = new JLabel("Alumnos:");
        AlumnosLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        AlumnosLabel.setBounds(30, 70, 80, 25);
        getContentPane().add(AlumnosLabel);

        // Recuadro donde aparecerán los alumnos (sin lógica aún asociada)
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(120, 70, 150, 100);
        getContentPane().add(scrollPane);

        // Campo de texto para la nota
        JLabel NotaLabel = new JLabel("Nota:");
        NotaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        NotaLabel.setBounds(90, 189, 43, 25);
        getContentPane().add(NotaLabel);

        NotaTextField = new JTextField();
        NotaTextField.setBounds(143, 190, 106, 25);
        getContentPane().add(NotaTextField);

        // Botón para guardar la nota (aún por asociar la lógica)
        Guardarbtn = new JButton("Guardar");
        Guardarbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Guardarbtn.setBounds(84, 261, 100, 25);
        getContentPane().add(Guardarbtn);
        
        Guardarbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
		
		 

        // Botón para cerrar sesión
        CerrarSesionbtn = new JButton("Cerrar Sesión");
        CerrarSesionbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        CerrarSesionbtn.setBounds(194, 261, 120, 25);
        getContentPane().add(CerrarSesionbtn);

        CerrarSesionbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginWindow().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        TeacherWindow teacherWindow = new TeacherWindow();
        teacherWindow.setVisible(true);
    }
}

