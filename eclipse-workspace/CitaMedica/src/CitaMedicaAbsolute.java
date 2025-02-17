import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;//Mediante esta clase podemos obtener los datos de la tabla
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CitaMedicaAbsolute extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable JTable;
	private JTextField textfieldNombre;
	private JTextField textfieldApellido;
	private JTextField textfieldTelefono;
	private JLabel jLabelNombre;
	private JLabel jLabelApellido;
	private JLabel jLabelTelefono;
	private JLabel jLabelFecha;
	private JButton botonAgregarCita;
	private JButton botonSalir;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CitaMedicaAbsolute frame = new CitaMedicaAbsolute();
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
	public CitaMedicaAbsolute() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jLabelNombre = new JLabel("Nombre");
		jLabelNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabelNombre.setBounds(21, 33, 85, 13);
		contentPane.add(jLabelNombre);
		
		jLabelApellido = new JLabel("Apellido:");
		jLabelApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabelApellido.setBounds(21, 56, 85, 13);
		contentPane.add(jLabelApellido);
		
		jLabelTelefono = new JLabel("Teléfono:");
		jLabelTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabelTelefono.setBounds(21, 79, 85, 13);
		contentPane.add(jLabelTelefono);
		
		jLabelFecha = new JLabel("Fecha de la cita:");
		jLabelFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabelFecha.setBounds(21, 102, 133, 13);
		contentPane.add(jLabelFecha);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 148, 405, 151);
		contentPane.add(scrollPane);
		
		JTable = new JTable();
		JTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Telefono", "Fecha de cita"
			}
		));
		scrollPane.setViewportView(JTable);
		
		//Acción para el botón de agregar cita
		botonAgregarCita = new JButton(" Agregar Cita");
		botonAgregarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCita();
			}
		});
		botonAgregarCita.setBackground(new Color(230, 230, 250));
		botonAgregarCita.setBounds(113, 322, 113, 21);
		contentPane.add(botonAgregarCita);
		
		//Acción para el botón de salir
		botonSalir = new JButton("Salir");
		botonSalir.setBackground(new Color(230, 230, 250));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(249, 322, 99, 21);
		contentPane.add(botonSalir);
	
		
		textfieldNombre = new JTextField();
		textfieldNombre.setBounds(227, 27, 199, 19);
		contentPane.add(textfieldNombre);
		textfieldNombre.setColumns(10);
		
		textfieldApellido = new JTextField();
		textfieldApellido.setBounds(227, 53, 199, 19);
		contentPane.add(textfieldApellido);
		textfieldApellido.setColumns(10);
		
		textfieldTelefono = new JTextField();
		textfieldTelefono.setBounds(227, 76, 199, 19);
		contentPane.add(textfieldTelefono);
		textfieldTelefono.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(227, 102, 199, 19);
		contentPane.add(dateChooser);
		
	}
	
	private void agregarCita() {
		
		// Obtener el modelo de la tabla
		DefaultTableModel modelo = (DefaultTableModel) JTable.getModel();
		
        // Obtenemos valores
        String nombre = textfieldNombre.getText().trim();
        String apellido = textfieldApellido.getText().trim();
        String telefono = textfieldTelefono.getText().trim();
        java.util.Date fechaSeleccionada = dateChooser.getDate();

        // Validaciones
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, complete todos los campos",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Formatear fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaCitaStr = sdf.format(fechaSeleccionada);

        // Añadir a la tabla
        modelo.addRow(new Object[] { nombre, apellido, telefono, fechaCitaStr });

        // Limpiar
        textfieldNombre.setText("");
        textfieldApellido.setText("");
        textfieldTelefono.setText("");
        dateChooser.setCalendar(null);
    }
	
	
}