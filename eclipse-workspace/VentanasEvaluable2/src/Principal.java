import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import database.Gestion;
import database.GestionAlumno;

public class Principal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textPass;
	private JComboBox<String> comboCargo;
	private JButton btnLimpiar;
	private JButton btnEntrar;
	private JButton btnSalir;
	private VentanaAlumno vA;
	private VentanaProfesor vP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/icono.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(new GridLayout(1, 2, 5, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(227, 227, 227));
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblusuario = new JLabel("USUARIO");
		lblusuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblusuario.setBounds(66, 65, 67, 28);
		panel1.add(lblusuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(143, 71, 156, 19);
		panel1.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblpass = new JLabel("CONTRASEÑA");
		lblpass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblpass.setBounds(39, 146, 94, 13);
		panel1.add(lblpass);
		
		textPass = new JPasswordField();
		textPass.setBounds(143, 144, 156, 19);
		panel1.add(textPass);
		
		JLabel lblcargo = new JLabel("CARGO");
		lblcargo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcargo.setBounds(76, 207, 57, 13);
		panel1.add(lblcargo);
		
		comboCargo = new JComboBox<>();
		comboCargo.setToolTipText("");
		comboCargo.addItem("Selecionar opción");
		comboCargo.addItem("Alumno");
		comboCargo.addItem("Profesor");
		
		comboCargo.setBounds(143, 204, 156, 21);
		panel1.add(comboCargo);
		
		btnLimpiar = new JButton("LIMPIAR CAMPOS");
		btnLimpiar.setBounds(162, 268, 137, 19);
		panel1.add(btnLimpiar);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLimpiar.setForeground(new Color(0, 0, 0));
		btnLimpiar.addActionListener(this);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(227, 227, 227));
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.setBounds(186, 253, 85, 21);
		panel2.add(btnSalir);
		
		JLabel IMAGE = new JLabel("");
		IMAGE.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/logo.jpg")));
		IMAGE.setBounds(10, 59, 317, 175);
		panel2.add(IMAGE);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(47, 254, 108, 19);
		panel2.add(btnEntrar);
		btnEntrar.addActionListener(this);			
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 12));
	}
	public JTextField getTextUsuario() {
		return textUsuario;
	}
	public JComboBox<String> getComboCargo() {
		return comboCargo;
	}
	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	public JButton getBtnEntrar() {
		return btnEntrar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JPasswordField getTextPass() {
		return textPass;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    // Se hace clic en SALIR
	    if (e.getSource().equals(btnSalir)) {
	        JOptionPane.showMessageDialog(null, "¡Hasta pronto!");
	        System.exit(0);
	    }

	    // Se hace clic en ENTRAR
	    if (e.getSource().equals(btnEntrar)) {
	        String usuario = textUsuario.getText().trim();
	        String pass = new String(textPass.getPassword()).trim();
	        String cargo = (String) comboCargo.getSelectedItem();


	        // 🔹 Validar que se haya seleccionado un cargo
	        if (comboCargo.getSelectedIndex() == 0) {  // Comprobar índice en lugar de comparar texto
	            JOptionPane.showMessageDialog(this, "Debe seleccionar un cargo antes de iniciar sesión.", "Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        // 🔹 Verificar si usuario o contraseña están vacíos
	        if (usuario.isEmpty() || pass.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        // Verificar credenciales
	        boolean credencialCorrecta = Gestion.verificarCredencial(usuario, pass, cargo);

	        if (credencialCorrecta) {
	            if (cargo.equals("Alumno")) {
	                int id_alumno = GestionAlumno.obteneridAlumno(usuario);
	                if (id_alumno != -1) {
	                    VentanaAlumno vA = new VentanaAlumno(id_alumno);
	                    vA.setVisible(true);
	                    this.dispose();
	                }
	            } else if (cargo.equals("Profesor")) {
	                int id_profesor = Gestion.obteneridProfesor(usuario);
	                if (id_profesor != -1) {
	                    VentanaProfesor vP = new VentanaProfesor(id_profesor);
	                    vP.setVisible(true);
	                    this.dispose();
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    // Se hace clic en LIMPIAR CAMPOS
	    if (e.getSource().equals(btnLimpiar)) {
	        textUsuario.setText("");
	        textPass.setText("");
	        comboCargo.setSelectedIndex(0);
	    }
	}

}