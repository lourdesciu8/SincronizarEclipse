import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitaMedicaBorderLayout extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Campos para los datos
    private JTextField txtNombre, txtApellido, txtTelefono;
    private JDateChooser dcFechaCita;
    private JTable tablaCitas;
    private DefaultTableModel modeloTabla;
    private JButton btnSalir;
    private JButton btnAgregar;
    private JButton btnCancelar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CitaMedicaBorderLayout frame = new CitaMedicaBorderLayout();
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
    public CitaMedicaBorderLayout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Aquí construimos la interfaz
        initUI();
    }

    private void initUI() {
        // Panel superior con GridBagLayout para los campos
        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ------------ Nombre ------------
        GridBagConstraints gbcLabelNombre = new GridBagConstraints();
        gbcLabelNombre.insets = new Insets(5, 5, 5, 5);
        gbcLabelNombre.gridx = 0;
        gbcLabelNombre.gridy = 0;
        gbcLabelNombre.fill = GridBagConstraints.HORIZONTAL;
        panelDatos.add(new JLabel("Nombre:"), gbcLabelNombre);

        GridBagConstraints gbcTxtNombre = new GridBagConstraints();
        gbcTxtNombre.insets = new Insets(5, 5, 5, 5);
        gbcTxtNombre.gridx = 1;
        gbcTxtNombre.gridy = 0;
        gbcTxtNombre.fill = GridBagConstraints.HORIZONTAL;
        txtNombre = new JTextField(15);
        panelDatos.add(txtNombre, gbcTxtNombre);

        // ------------ Apellido ------------
        GridBagConstraints gbcLabelApellido = new GridBagConstraints();
        gbcLabelApellido.insets = new Insets(5, 5, 5, 5);
        gbcLabelApellido.gridx = 0;
        gbcLabelApellido.gridy = 1;
        gbcLabelApellido.fill = GridBagConstraints.HORIZONTAL;
        panelDatos.add(new JLabel("Apellido:"), gbcLabelApellido);

        GridBagConstraints gbcTxtApellido = new GridBagConstraints();
        gbcTxtApellido.insets = new Insets(5, 5, 5, 5);
        gbcTxtApellido.gridx = 1;
        gbcTxtApellido.gridy = 1;
        gbcTxtApellido.fill = GridBagConstraints.HORIZONTAL;
        txtApellido = new JTextField(15);
        panelDatos.add(txtApellido, gbcTxtApellido);

        // ------------ Teléfono ------------
        GridBagConstraints gbcLabelTelefono = new GridBagConstraints();
        gbcLabelTelefono.insets = new Insets(5, 5, 5, 5);
        gbcLabelTelefono.gridx = 0;
        gbcLabelTelefono.gridy = 2;
        gbcLabelTelefono.fill = GridBagConstraints.HORIZONTAL;
        panelDatos.add(new JLabel("Teléfono:"), gbcLabelTelefono);

        GridBagConstraints gbcTxtTelefono = new GridBagConstraints();
        gbcTxtTelefono.insets = new Insets(5, 5, 5, 5);
        gbcTxtTelefono.gridx = 1;
        gbcTxtTelefono.gridy = 2;
        gbcTxtTelefono.fill = GridBagConstraints.HORIZONTAL;
        txtTelefono = new JTextField(15);
        panelDatos.add(txtTelefono, gbcTxtTelefono);

        // ------------ Fecha de la cita (JDateChooser) ------------
        GridBagConstraints gbcLabelFecha = new GridBagConstraints();
        gbcLabelFecha.insets = new Insets(5, 5, 5, 5);
        gbcLabelFecha.gridx = 0;
        gbcLabelFecha.gridy = 3;
        gbcLabelFecha.fill = GridBagConstraints.HORIZONTAL;
        panelDatos.add(new JLabel("Fecha de la cita:"), gbcLabelFecha);

        GridBagConstraints gbcDateChooser = new GridBagConstraints();
        gbcDateChooser.insets = new Insets(5, 5, 5, 5);
        gbcDateChooser.gridx = 1;
        gbcDateChooser.gridy = 3;
        gbcDateChooser.fill = GridBagConstraints.HORIZONTAL;
        dcFechaCita = new JDateChooser();
        dcFechaCita.setDateFormatString("dd/MM/yyyy");
        panelDatos.add(dcFechaCita, gbcDateChooser);

        // Agregamos el panel de datos a la parte superior
        contentPane.add(panelDatos, BorderLayout.NORTH);

        // Panel central con la tabla
        modeloTabla = new DefaultTableModel(
            new String[] { "Nombre", "Apellido", "Teléfono", "Fecha de Cita" }, 
            0
        );
        tablaCitas = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Nombre", "Apellido", "Tel\u00E9fono", "Fecha de Cita"
        	}
        ));
        JScrollPane scrollTabla = new JScrollPane(tablaCitas);
        contentPane.add(scrollTabla, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel();

        btnAgregar = new JButton("Agregar Cita");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCita();
            }
        });
        panelBotones.add(btnAgregar);

        btnCancelar = new JButton("Cancelar Cita");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarCita();
            }
        });
        panelBotones.add(btnCancelar);

        contentPane.add(panelBotones, BorderLayout.SOUTH);
        
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        panelBotones.add(btnSalir);
    }

    private void agregarCita() {
        // Obtenemos valores
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        java.util.Date fechaSeleccionada = dcFechaCita.getDate();

        // Validaciones
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, completa todos los campos y selecciona una fecha.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Formatear fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaCitaStr = sdf.format(fechaSeleccionada);

        // Añadir a la tabla
        modeloTabla.addRow(new Object[] { nombre, apellido, telefono, fechaCitaStr });

        // Limpiar
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        dcFechaCita.setCalendar(null);
    }

    private void cancelarCita() {
        // Eliminar la fila seleccionada
        int fila = tablaCitas.getSelectedRow();
        if (fila >= 0) {
            modeloTabla.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Selecciona una cita de la tabla para poder cancelarla.",
                    "Ninguna cita seleccionada",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
	
}
