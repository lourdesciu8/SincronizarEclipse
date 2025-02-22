import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import BaseDatos.GestionBD;
import model.Alumno;
import model.Profesor;
import model.Usuario;

public class VentanaInicio extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JComboBox<String> cbCargo;
    private JButton btnEntrar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JButton btnRegistrar;
    private JLabel lblLogo;
    private GestionBD db;
    private JLabel RegistroLbl;

    public VentanaInicio() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/Imagenes/logo_resized_50x50.png")));
        db = new GestionBD();
        setResizable(false);
        setTitle("Ventana de Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        getContentPane().setBackground(SystemColor.control);
        getContentPane().setLayout(null);

        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(VentanaInicio.class.getResource("/Imagenes/logo_less_width.png")));
        lblLogo.setBounds(323, 30, 141, 98);
        getContentPane().add(lblLogo);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        userLabel.setBounds(30, 30, 80, 25);
        getContentPane().add(userLabel);

        userField = new JTextField();
        userField.setBounds(120, 30, 165, 25);
        getContentPane().add(userField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(30, 87, 100, 25);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 89, 165, 25);
        getContentPane().add(passwordField);

        JLabel cargoLabel = new JLabel("Cargo:");
        cargoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cargoLabel.setBounds(30, 141, 80, 25);
        getContentPane().add(cargoLabel);

        cbCargo = new JComboBox<>(new String[]{"Seleccione", "Alumno", "Profesor"});
        cbCargo.setFont(new Font("Verdana", Font.PLAIN, 14));
        cbCargo.setBounds(120, 141, 165, 25);
        getContentPane().add(cbCargo);

        btnEntrar = new JButton("Iniciar Sesión");
        btnEntrar.setBackground(new Color(192, 192, 192));
        btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEntrar.setBounds(314, 138, 150, 30);
        getContentPane().add(btnEntrar);
        btnEntrar.addActionListener(e -> validarLogin());

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLimpiar.setBounds(75, 200, 100, 30);
        getContentPane().add(btnLimpiar);
        btnLimpiar.addActionListener(e -> {
            userField.setText("");
            passwordField.setText("");
            cbCargo.setSelectedIndex(0);
        });

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSalir.setBounds(213, 200, 100, 30);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(e -> System.exit(0));

        btnRegistrar = new JButton("");
        btnRegistrar.setIcon(new ImageIcon(VentanaInicio.class.getResource("/Imagenes/click_here_resized.jpg")));
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRegistrar.setForeground(new Color(0, 0, 0));
        btnRegistrar.setBounds(364, 262, 100, 41);
        getContentPane().add(btnRegistrar);
        
        RegistroLbl = new JLabel("¿Nuevo usuario?");
        RegistroLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        RegistroLbl.setBounds(355, 241, 131, 25);
        getContentPane().add(RegistroLbl);
        btnRegistrar.addActionListener(e -> new Registro().setVisible(true));
    }

    private void validarLogin() {
        String cargo = (String) cbCargo.getSelectedItem();
        String user = userField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        System.out.println("Cargo seleccionado: " + cargo);
        System.out.println("Usuario ingresado: " + user);
        System.out.println("Contraseña ingresada: " + password);

        if (user.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        if ("Alumno".equals(cargo)) {
            try {
                ResultSet rs = db.buscarAlumno(user, password);
                if (rs != null && rs.next()) {
                    System.out.println("Alumno encontrado en la BD.");
                    Alumno alumno = new Alumno(
                        rs.getString("dni_alumno"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("direccion"),
                        rs.getString("pass")
                    );
                    new VentanaAlumno(alumno).setVisible(true);
                    dispose();
                } else {
                    System.out.println("Alumno NO encontrado.");
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                }
            } catch (SQLException e) {
                System.out.println("Error SQL al buscar Alumno.");
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if ("Profesor".equals(cargo)) {
            try {
                ResultSet rs = db.buscarProfesor(user, password);
                if (rs != null && rs.next()) {
                    System.out.println("Profesor encontrado en la BD.");
                    Profesor profesor = new Profesor(
                        rs.getString("dni_profesor"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("direccion"),
                        rs.getString("pass")
                    );
                    System.out.println("Abriendo VentanaProfesor...");
                    new VentanaProfesor(profesor).setVisible(true);
                    dispose();
                } else {
                    System.out.println("Profesor NO encontrado.");
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                }
            } catch (SQLException e) {
                System.out.println("Error SQL al buscar Profesor.");
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cargo.");
        }
    }
}
