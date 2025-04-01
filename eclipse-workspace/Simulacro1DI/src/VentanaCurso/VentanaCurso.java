package VentanaCurso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class VentanaCurso extends JFrame {

	//VARIABLES
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private JLabel lblID;
	private JLabel lblNombre;
	private JPanel panelCurso;
	private JPanel panelGrado;
	private JButton btnInsertar;
	private JButton btnLimpiar;
	private JCheckBox chckbx1Curso;
	private JCheckBox chckbx2Curso;
	private final ButtonGroup buttonGroupCurso = new ButtonGroup();
	private JRadioButton rdbtnInformatica;
	private JRadioButton rdbtnDependencia;
	private JRadioButton rdbtnEnfermeria;
	private final ButtonGroup buttonGroupGrado = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCurso frame = new VentanaCurso();
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
	public VentanaCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblID.setBounds(86, 54, 45, 13);
		contentPane.add(lblID);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(86, 108, 70, 13);
		contentPane.add(lblNombre);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(183, 53, 108, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(183, 107, 108, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		//ACCIÓN BOTÓN INSERTAR
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 1. Obtener el texto de los campos ID y Nombre
		        String id = textFieldID.getText().trim();
		        String nombre = textFieldNombre.getText().trim();

		        // 2. Verificar que los campos no estén vacíos
		        if (id.isEmpty() || nombre.isEmpty()) {
		            JOptionPane.showMessageDialog(
		                null,
		                "Los campos ID y Nombre deben rellenarse",
		                "Error",
		                JOptionPane.ERROR_MESSAGE
		            );
		            return; // Salir si falta algún dato
		        }

		        // 3. Determinar el Checkbox de "Curso" seleccionado
		        String cursoSeleccionado;
		        if (chckbx1Curso.isSelected()) {
		            cursoSeleccionado = "PRIMERO";
		        } else {
		            cursoSeleccionado = "SEGUNDO";
		        }

		        // 4. Determinar el RadioButton de "Grado" seleccionado
		        String gradoSeleccionado;
		        if (rdbtnInformatica.isSelected()) {
		            gradoSeleccionado = "INFORMÁTICA";
		        } else if (rdbtnDependencia.isSelected()) {
		            gradoSeleccionado = "DEPENDENCIA";
		        } else {
		            gradoSeleccionado = "ENFERMERÍA";
		        }

		        // 5. Mostrar mensaje con los valores seleccionados
		        JOptionPane.showMessageDialog(
		            null,
		            "ID: " + id + "\n" +
		            "Nombre: " + nombre + "\n" +
		            "Curso: " + cursoSeleccionado + "\n" +
		            "Grado: " + gradoSeleccionado,
		            "Datos insertados correctamente",
		            JOptionPane.INFORMATION_MESSAGE
		        );
		    }
		});

		btnInsertar.setBounds(86, 341, 120, 21);
		contentPane.add(btnInsertar);
		
		//ACCIÓN BOTÓN LIMPIAR
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. Dejar en blanco los campos de texto
			    textFieldID.setText("");
			    textFieldNombre.setText("");

			    // 2. Restaurar los valores por defecto de los checkbox y los radio button
			    chckbx1Curso.setSelected(true);      // Volver a "PRIMERO" como estaba al inicio
			    rdbtnInformatica.setSelected(true);  // Volver a "INFORMÁTICA" como estaba al inicio
			}
		});
		btnLimpiar.setBounds(239, 341, 108, 21);
		contentPane.add(btnLimpiar);
		
		panelCurso = new JPanel();
		panelCurso.setBorder(new TitledBorder(null, "Curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCurso.setBounds(86, 192, 129, 81);
		contentPane.add(panelCurso);
		
		chckbx1Curso = new JCheckBox("PRIMERO");
		buttonGroupCurso.add(chckbx1Curso);
		panelCurso.add(chckbx1Curso);
		chckbx1Curso.setSelected(true);
		
		chckbx2Curso = new JCheckBox("SEGUNDO");
		buttonGroupCurso.add(chckbx2Curso);
		panelCurso.add(chckbx2Curso);
		
		panelGrado = new JPanel();
		panelGrado.setBorder(new TitledBorder(null, "Grado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrado.setBounds(239, 192, 155, 139);
		contentPane.add(panelGrado);
		
		rdbtnInformatica = new JRadioButton("INFORMÁTICA");
		buttonGroupGrado.add(rdbtnInformatica);
		rdbtnInformatica.setSelected(true);
		panelGrado.add(rdbtnInformatica);
		
		rdbtnDependencia = new JRadioButton("DEPENDENCIA");
		buttonGroupGrado.add(rdbtnDependencia);
		panelGrado.add(rdbtnDependencia);
		
		rdbtnEnfermeria = new JRadioButton("ENFERMERÍA");
		buttonGroupGrado.add(rdbtnEnfermeria);
		panelGrado.add(rdbtnEnfermeria);
	}
	
}
