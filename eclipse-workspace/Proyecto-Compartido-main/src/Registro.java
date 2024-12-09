import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfApellido;
    private JTextField tfNombre;
    private JTextField tfContraseña;
    private JTextField tfNacimiento;
    private JComboBox<String> comboBoxSexo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registro frame = new Registro();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Registro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 68, 70, 13);
        contentPane.add(lblNombre);

        tfNombre = new JTextField();
        tfNombre.setBounds(90, 65, 96, 19);
        contentPane.add(tfNombre);
        tfNombre.setColumns(10);

        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(10, 112, 70, 13);
        contentPane.add(lblApellido);

        tfApellido = new JTextField();
        tfApellido.setBounds(90, 109, 96, 19);
        contentPane.add(tfApellido);
        tfApellido.setColumns(10);

        
        JLabel lblContraseña = new JLabel("Contraseña");
        lblContraseña.setBounds(10, 162, 70, 13);
        contentPane.add(lblContraseña);

        tfContraseña = new JTextField();
        tfContraseña.setBounds(90, 159, 96, 19);
        contentPane.add(tfContraseña);
        tfContraseña.setColumns(10);

       
        JLabel lblFecha = new JLabel("Fecha nacimiento");
        lblFecha.setBounds(222, 68, 120, 13);
        contentPane.add(lblFecha);

        tfNacimiento = new JTextField();
        tfNacimiento.setBounds(315, 65, 96, 19);
        contentPane.add(tfNacimiento);
        tfNacimiento.setColumns(10);

        
        JLabel lblSexo = new JLabel("Sexo");
        lblSexo.setBounds(222, 112, 45, 13);
        contentPane.add(lblSexo);

        comboBoxSexo = new JComboBox<>();
        comboBoxSexo.setBounds(315, 108, 96, 21);
        comboBoxSexo.addItem("Seleccione");
        comboBoxSexo.addItem("Masculino");
        comboBoxSexo.addItem("Femenino");
        comboBoxSexo.addItem("No binario");
        contentPane.add(comboBoxSexo);

        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(90, 213, 96, 21);
        contentPane.add(btnLimpiar);

        
        JButton btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(222, 213, 85, 21);
        contentPane.add(btnRegistro);

        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(341, 213, 85, 21);
        contentPane.add(btnCerrar);

        // Acción para el botón "Registrarse"
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = tfNombre.getText();
                String apellido = tfApellido.getText();
                String contraseña = tfContraseña.getText();
                String fechaNacimiento = tfNacimiento.getText();
                String sexo = (String) comboBoxSexo.getSelectedItem();

                if (nombre.isEmpty() || apellido.isEmpty() || contraseña.isEmpty() || fechaNacimiento.isEmpty() || "Seleccione".equals(sexo)) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Registro exitoso:\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellido: " + apellido + "\n" +
                        "Contraseña: " + contraseña + "\n" +
                        "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                        "Sexo: " + sexo,
                        "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfNombre.setText("");
                tfApellido.setText("");
                tfContraseña.setText("");
                tfNacimiento.setText("");
                comboBoxSexo.setSelectedIndex(0);
            }
        });

       
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
