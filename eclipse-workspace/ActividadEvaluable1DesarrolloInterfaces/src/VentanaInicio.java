import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaInicio frame = new VentanaInicio();
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
    public VentanaInicio() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Raul\\Documents\\GitHub\\SincronizarEclipse\\eclipse-workspace\\ActividadEvaluable1DesarrolloInterfaces\\imagenes\\UE ICONO PEQUEÑO.jpg"));
        setTitle("Ventana de inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 644, 331);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel LabelUsuario = new JLabel("USUARIO");
        LabelUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
        LabelUsuario.setBounds(22, 35, 106, 20);
        contentPane.add(LabelUsuario);

        JLabel LabelCargo = new JLabel("CARGO");
        LabelCargo.setFont(new Font("Tahoma", Font.BOLD, 16));
        LabelCargo.setBounds(22, 169, 124, 20);
        contentPane.add(LabelCargo);

        JLabel LabelContraseña_1 = new JLabel("CONTRASEÑA");
        LabelContraseña_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        LabelContraseña_1.setBounds(22, 102, 124, 20);
        contentPane.add(LabelContraseña_1);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(153, 37, 132, 22);
        contentPane.add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(156, 104, 129, 22);
        contentPane.add(passwordField);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLimpiar.setBounds(168, 213, 94, 25);
        contentPane.add(btnLimpiar);
        
        // Evento para el botón "Limpiar"
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldUsuario.setText("");
                passwordField.setText("");
            }
        });

        JButton btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSalir.setBounds(444, 213, 88, 25);
        contentPane.add(btnSalir);

        //Evento para el botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });

        JButton btEntrar = new JButton("ENTRAR");
        btEntrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btEntrar.setBounds(346, 213, 88, 25);
        contentPane.add(btEntrar);

        // Evento para el botón "Entrar"
        btEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String contrasena = new String(passwordField.getPassword());

                if (usuario.equals("lourdes") && contrasena.equals("uem")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
                }
            }
        });

        JComboBox<String> comboBoxListaDesplegable = new JComboBox<>();
        comboBoxListaDesplegable.setModel(new DefaultComboBoxModel<>(new String[] {"Estudiante", "Profesor"}));
        comboBoxListaDesplegable.setToolTipText("Seleccione una opción");
        comboBoxListaDesplegable.setBounds(156, 171, 129, 21);
        contentPane.add(comboBoxListaDesplegable);

        JLabel LogoUE = new JLabel("");
        LogoUE.setIcon(new ImageIcon("C:\\Users\\Raul\\Documents\\GitHub\\SincronizarEclipse\\eclipse-workspace\\ActividadEvaluable1DesarrolloInterfaces\\imagenes\\descarga.png"));
        LogoUE.setBounds(306, 59, 300, 95);
        contentPane.add(LogoUE);
    }
}
