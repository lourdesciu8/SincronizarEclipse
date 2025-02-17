import java.awt.EventQueue;

import javax.swing.*;
public class Entrada {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                	//Me he traído esto desde la ventana de registro
                    // Salta la ventana de Login
                    LoginWindow frame = new LoginWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });}

}
//Pendientes:
//Obtener asignaturas
//Obtener nota Ppara la asignatura
//La clase Registro debe guardar los datos en la base de datos
//Añadir cargo en la ventana de Registro, ahora no lo pide
