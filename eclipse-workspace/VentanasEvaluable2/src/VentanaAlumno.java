import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import database.GestionAlumno;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class VentanaAlumno extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel tabla_alumnos;
    private int id_alumno;
    private JButton btnSalir2;
    private JScrollPane scrollTable;
    private JTable table_registro = new JTable();
    private JComboBox<String> comboModulos = new JComboBox<>(); // 🔹 Usar el atributo de clase

    /**
     * Constructor de la ventana del alumno
     */
    public VentanaAlumno(int id_alumno) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAlumno.class.getResource("/imagenes/logo.jpg")));
        this.id_alumno = id_alumno;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 351);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table_registro = new JTable();
        scrollTable = new JScrollPane(table_registro); // 🔹 Agregar la tabla dentro del JScrollPane
        scrollTable.setPreferredSize(new Dimension(300, 200));
        scrollTable.setBounds(377, 62, 314, 128);
        contentPane.add(scrollTable);

        btnSalir2 = new JButton("Salir");
        btnSalir2.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSalir2.setBounds(280, 224, 135, 54);
        contentPane.add(btnSalir2);

        tabla_alumnos = new DefaultTableModel();
        tabla_alumnos.addColumn("id");
        tabla_alumnos.addColumn("Nombre");
        tabla_alumnos.addColumn("Apellido");
        tabla_alumnos.addColumn("Nota");

        table_registro = new JTable(tabla_alumnos); // 🔹 Asociar el modelo a la tabla
        scrollTable.setViewportView(table_registro); // 🔹 Asegurar que la tabla esté en el JScrollPane

        JLabel lblModulos = new JLabel("Módulos:");
        lblModulos.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblModulos.setBounds(10, 10, 106, 54);
        contentPane.add(lblModulos);

        // 🔹 Aquí usamos la variable de clase y no creamos otra nueva
        comboModulos.setPreferredSize(new Dimension(200, 30));
        comboModulos.setBounds(10, 62, 348, 128);
        contentPane.add(comboModulos);

        // 🔹 Registrar eventos
        registrarEventos();

        // 🔹 Cargar módulos
        cargarModulos(); 
    }

    /**
     * Método para registrar eventos en los botones y comboBox
     */
    private void registrarEventos() {
        btnSalir2.addActionListener(this);
        comboModulos.addActionListener(this);  // 🔹 REGISTRO DE EVENTOS PARA EL JComboBox
    }

    public JComboBox<String> getComboModulos() {
        return comboModulos;
    }

    public JTable getTable_registro() {
        return table_registro;
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

    /**
     * Método para cargar los módulos en el JComboBox
     */
    private void cargarModulos() {
        System.out.println("Cargando módulos...");

        // Obtener módulos desde la base de datos
        List<String> modulos = GestionAlumno.obtenerModulosParaAlumno(id_alumno);

        // Verificar si se obtienen datos
        System.out.println("Módulos obtenidos: " + modulos.size());

        // Agregar módulos al comboBox
        for (String modulo : modulos) {
            System.out.println("Agregando módulo: " + modulo);
            comboModulos.addItem(modulo);
        }
    }

    /**
     * Método para cargar las notas de un módulo seleccionado
     */
    private void cargarDatosAlumno(String modulo) {
        System.out.println("Cargando datos para el módulo: " + modulo);

        // Obtener modelo de la tabla y limpiar antes de agregar nuevos datos
        DefaultTableModel columnas = (DefaultTableModel) table_registro.getModel();
        columnas.setRowCount(0); // Limpia la tabla antes de cargar nuevos datos

        // Obtener datos de la BD
        List<String[]> datos = GestionAlumno.obtenerDatosModulosDeAlumno(modulo, id_alumno);
        
        System.out.println("Cantidad de registros obtenidos: " + datos.size());

        // Agregar los datos a la tabla
        for (String[] lista : datos) {
            System.out.println("Fila añadida: " + Arrays.toString(lista));
            columnas.addRow(lista);
        }
    }

    /**
     * Manejo de eventos
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(comboModulos)) {
            if (comboModulos.getSelectedItem() != null) {
                cargarDatosAlumno(comboModulos.getSelectedItem().toString());
            }
        }

        // 🔹 Manejo del botón "Salir"
        if (e.getSource().equals(btnSalir2)) {
            JOptionPane.showMessageDialog(this, "¡Hasta pronto!");
            this.dispose();  // Cierra la ventana actual

            // Opcional: Volver a la ventana principal si es necesario
            Principal ventanaPrincipal = new Principal();
            ventanaPrincipal.setVisible(true);
        }
    }
}

