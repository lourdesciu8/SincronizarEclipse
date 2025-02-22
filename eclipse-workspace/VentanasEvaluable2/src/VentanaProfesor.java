import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import database.Gestion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SpinnerNumberModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class VentanaProfesor extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table_registro;
    private DefaultTableModel tabla_alumnos;
    private JComboBox<String> comboModulos;
    private JSpinner spinNota;
    private JSpinner spinAlumno;
    private JButton btnGuardar;
    private JButton btnSalir2;
    private int id_profesor;

    public VentanaProfesor(int id) {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaProfesor.class.getResource("/imagenes/logo.jpg")));
        this.id_profesor = id;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblProfesor = new JLabel("Bienvenido Profesor " + id_profesor);
        lblProfesor.setFont(new Font("Tahoma", Font.BOLD, 16));
        topPanel.add(lblProfesor);
        contentPane.add(topPanel, BorderLayout.NORTH);

        // Panel central (Formulario)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblModulos = new JLabel("Módulos:");
        lblModulos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        centerPanel.add(lblModulos);

        comboModulos = new JComboBox<>();
        comboModulos.setPreferredSize(new Dimension(200, 30));
        comboModulos.addActionListener(this);
        centerPanel.add(comboModulos);

        JLabel lblAlumno = new JLabel("ID Alumno");
        lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        centerPanel.add(lblAlumno);

        spinAlumno = new JSpinner(new SpinnerNumberModel(0, 0, 70, 1));
        centerPanel.add(spinAlumno);
        
        JLabel Nota = new JLabel("nota");
		Nota.setFont(new Font("Tahoma", Font.PLAIN, 14));
        centerPanel.add(Nota);

        spinNota = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        centerPanel.add(spinNota);

        contentPane.add(centerPanel, BorderLayout.CENTER);

        // Panel inferior (Botones)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bottomPanel.add(btnGuardar);
        btnGuardar.addActionListener(this);

        btnSalir2 = new JButton("Salir");
        btnSalir2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bottomPanel.add(btnSalir2);
        btnSalir2.addActionListener(this);

        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        
        tabla_alumnos = new DefaultTableModel();
		tabla_alumnos.addColumn("id");
        tabla_alumnos.addColumn("Nombre");
        tabla_alumnos.addColumn("Apellido");
        tabla_alumnos.addColumn("Nota");
        
        table_registro = new JTable(tabla_alumnos);
        //para que la columna sea editable.
        table_registro.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JTextField()));
        
        
        JScrollPane scrollTable = new JScrollPane(table_registro);
        scrollTable.setPreferredSize(new Dimension(300, 200)); 
        contentPane.add(scrollTable, BorderLayout.EAST);

        // Cargar módulos
        cargarModulos();
    }



	public JComboBox<String> getComboModulos() {
		return comboModulos;
	}
	public JTable getTable_registro() {
		return table_registro;
	}
	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnSalir2() {
		return btnSalir2;
	}
	public DefaultTableModel getModeloTabla() {
		return tabla_alumnos;
	}
	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.tabla_alumnos = modeloTabla;
	}
	//PARA QUE LOS MODULOS CARGUEN EN EL COMBOBOX
	private void cargarModulos() {
		//obtenemos la lista de modulos de la base de datos.
		List<String> modulos = Gestion.obtenerModulosParaProfesor(id_profesor);
		
		//Se limpiar antes de agregar
		comboModulos.removeAllItems();
		
		//agrega los modulos
		for(String modulo: modulos) {
			comboModulos.addItem(modulo);
		}
	}
	//PARA QUE LOS MODULOS CARGUEN EN JTABLE
	private void cargarDatosAlumnos(String modulos) {
		//convertimos la table registro en el modelo de la tabla para acceder y manipular
		DefaultTableModel columnas = (DefaultTableModel) table_registro.getModel();
		
		//limpiar tabla antes de agregar
		columnas.setRowCount(0);
		
		//obtenemos la lista
		List<String[]> datos = Gestion.obtenerDatosModulos(modulos);
		
		//agregar
		for(String[] lista: datos) {
			columnas.addRow(lista);
		}
	}
	//MÉTODO PARA OBTENER ID DE LA FILA DONDE MODIFICAREMOS LA NOTA 
	private int obtenerFila(DefaultTableModel tabla, int numFila) {
		try {
			return Integer.parseInt(tabla.getValueAt(numFila, 0).toString());
		}catch(NumberFormatException e1) {
			System.out.println("El Id no es valido "+e1.getMessage());
			return -1;
		}
	}
	//MÉTODO PARA OBTENER EL MÓDULO DONDE MODICAREMOS LA NOTA.
	public String obtenerModulo(JComboBox<String> comboModulos) {
		return (String) comboModulos.getSelectedItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//CARGA LOS DATOS DE LOS ALUMNOS
		if(e.getSource().equals(comboModulos)) {
			cargarDatosAlumnos(comboModulos.getSelectedItem().toString());
		}
		if(e.getSource().equals(btnGuardar)){
		//obtenemos el id del spinner
			int id_alumno = (int) spinAlumno.getValue();
			//obtener modulo
			String modulo_seleccionado = obtenerModulo(comboModulos);
			
			if(modulo_seleccionado == null) {
				JOptionPane.showMessageDialog(this, "Selecciona un modulo");
				return;
			}
			//obtenemos la tabla registro 
			DefaultTableModel tabla_alumno = (DefaultTableModel) table_registro.getModel();
		
			//recorremos para obtener el ID
			for(int i = 0; i < tabla_alumno.getRowCount(); i++) {
				int id_fila = obtenerFila(tabla_alumno, i);
				
				//comparamos para obtener la fila correspondiente
				if(id_fila == id_alumno) {
					//obtenemos la nueva nota desde el Spinner
					  double nota_editada = ((Number) spinNota.getValue()).doubleValue();
					
					//Se actualiza la tabla visualmente
					tabla_alumno.setValueAt(nota_editada, i, 3);
					
					boolean actualizada = Gestion.editarNota(id_alumno, modulo_seleccionado, nota_editada);
					if(actualizada) {
						JOptionPane.showMessageDialog(this, "Nota actualizada");
					}else {
						JOptionPane.showMessageDialog(this, "No se pudo actualizar");
					}
					return;
				}
			}
		}
		//Regresa a la venta principal
		if(e.getSource().equals(btnSalir2)) {
			JOptionPane.showMessageDialog(null, "Sesión Cerrada");
			this.dispose();
			Principal ventanaPrincipal = new Principal();
		    ventanaPrincipal.setVisible(true);  
		}
	}
}
					
					