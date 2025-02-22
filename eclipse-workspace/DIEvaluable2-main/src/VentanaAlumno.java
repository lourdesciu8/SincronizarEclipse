import javax.swing.*;

import BaseDatos.GestionBD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Alumno;

public class VentanaAlumno extends JFrame {
    private Alumno alumno;
    private JComboBox<String> cbAsignatura;
    
    private JTextField tfNota;
    private GestionBD bd;

    public VentanaAlumno(Alumno alumno) {
        this.alumno = alumno;
        
        
       bd = new GestionBD();//Inicializo la BD

        setTitle("Ventana Alumno - " + alumno.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        
        JLabel lblAsignatura = new JLabel("Asignaturas");
        lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAsignatura.setBounds(34, 59, 150, 25);
        getContentPane().add(lblAsignatura);

        cbAsignatura = new JComboBox<>();
        cbAsignatura.setBounds(34, 100, 150, 25);
        getContentPane().add(cbAsignatura);
        cbAsignatura.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(e.getStateChange()==ItemEvent.SELECTED) {
        			String asignaturaSelect= (String) cbAsignatura.getSelectedItem();
        			mostrarNota(asignaturaSelect);
        			
        			//Detecta el cambio y llama a mostrar asignatura
        		}
        	}
        });
        

       
        JLabel lblNota = new JLabel("Nota:");
        lblNota.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNota.setBounds(200, 60, 150, 25);
        getContentPane().add(lblNota);

        tfNota = new JTextField();
        tfNota.setBounds(200, 100, 150, 25);
        tfNota.setEditable(false);
        getContentPane().add(tfNota);

        
        JButton cerrarSesionBtn = new JButton("Cerrar Sesión");
        cerrarSesionBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        cerrarSesionBtn.setBounds(140, 200, 120, 30);
        getContentPane().add(cerrarSesionBtn);
        
        JPanel panelTítulo = new JPanel();
        panelTítulo.setPreferredSize(new Dimension(500, 60));
        panelTítulo.setBackground(new Color(192, 192, 192));
        panelTítulo.setBounds(0, 0, 386, 49);
        getContentPane().add(panelTítulo);
        panelTítulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel lblNotasAlumnos = new JLabel("NOTAS - ALUMNOS");
        lblNotasAlumnos.setBackground(new Color(240, 240, 240));
        lblNotasAlumnos.setForeground(new Color(0, 0, 0));
        lblNotasAlumnos.setFont(new Font("Tahoma", Font.BOLD, 16));
        panelTítulo.add(lblNotasAlumnos);

        cerrarSesionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaInicio().setVisible(true);
                dispose();
            }
        });

        mostrarAsignaturas();
        //Aquí el constructor llama a mostrarAsignaturas(). MostrarAsignaturas tiene que llamar
        //a bd.mostrarAlumno--> Devuelve ResulSet con las asignaturas
       
       
    }

    private void mostrarAsignaturas() {
    	try {
    	
			ResultSet rs= bd.mostrarNotasAlumno(alumno.getDni_alumno());
			
			while(rs.next()) {//Iteramos las filas del ResulSet que me devuelve el método mostrarNotasAlumno
				String asignatura= rs.getString("denominacion");//Obtenemos el nombre de la asignatura
				//Obtengo el nombre porque lo que necesito poner en el Combox es el nombre, no el id
				System.out.println("agregando al cbB la asignatura:"+ asignatura);
				cbAsignatura.addItem(asignatura);//Añade la asignatura al ComboBox
			}
		
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(cbAsignatura, "No se pudieron cargar las asignaturas");
		}
    	
    }
    

    private void mostrarNota(String asignaturaNombre) {
   
    	//Busca el id a partir del nombre
    	String asignatura= bd.obtenerIdAsignaturaPorNombre(asignaturaNombre);
    	if(asignatura==null) {
    		System.out.println("No estoy encontrando la asignatura");
    		return;
    	}
    	
    	try {
    		//Busca lanota del alumno para esa asignatura
			ResultSet rs = bd.notaAlumnoAsignatura(alumno.getDni_alumno(), asignatura);
			if(rs.next()) {
				//Si la consulta devuelve una nota la muestra en el tf
				tfNota.setText(rs.getString("calificacion"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(cbAsignatura, "Algo falló en mostrar nota");
		}
    }
}