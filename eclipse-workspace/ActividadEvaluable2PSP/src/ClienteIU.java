//CLASE CON SOLO LA INTERFAZ GRÁFICA

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteIU {
    private JFrame frameLoteria;
    private JTextField textField;
    private JLabel resultLabel;
    private JLabel label;
    private JButton btnEnviar;
    
    public ClienteIU() {
        frameLoteria = new JFrame("Lotería");
        frameLoteria.getContentPane().setBackground(new Color(203, 228, 228));
        frameLoteria.getContentPane().setForeground(new Color(255, 255, 255));
        frameLoteria.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Raul\\Documents\\GitHub\\SincronizarEclipse\\eclipse-workspace\\ActividadEvaluable2PSP\\imagenes\\logo.png"));
        frameLoteria.setTitle("Lotería");
        frameLoteria.setSize(491, 288);
        //Se pone la ventana con tamaño fijo
        frameLoteria.setResizable(false); 
        frameLoteria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel("Introduce el número de lotería:");
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(120, 24, 237, 13);
        textField = new JTextField(10);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.BOLD, 13));
        textField.setBounds(113, 74, 108, 32);
        btnEnviar = new JButton("Enviar");
        btnEnviar.setBackground(new Color(255, 255, 255));
        btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnEnviar.setBounds(247, 74, 95, 33);
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
        resultLabel.setBounds(98, 195, 289, 19);
        
        //Acción para el Botón Enviar
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero = textField.getText();
                //Comprueba que el número introducido tenga 5 dígitos
                if (numero.length() != 5) {
                    resultLabel.setText("Error: el número debe tener 5 dígitos.");
                    return; // Evita que se envíe el número si es inválido
                }
                
                System.out.println("Número ingresado por el usuario: " + numero);
                
                //Se llama al método creado en SocketCliente
                String respuesta = SocketCliente.enviarNumero(numero);
                resultLabel.setText("Respuesta: " + respuesta);
                System.out.println("Respuesta del servidor: " + respuesta); 
            }
        });
        frameLoteria.getContentPane().setLayout(null);
        
        frameLoteria.getContentPane().add(label);
        frameLoteria.getContentPane().add(textField);
        frameLoteria.getContentPane().add(btnEnviar);
        frameLoteria.getContentPane().add(resultLabel);
        
        frameLoteria.setVisible(true);
    }
    
    public static void main(String[] args) {
        new ClienteIU();
    }
	
}