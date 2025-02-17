import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora extends JFrame implements ActionListener {
    private JTextField pantalla;
    private String operador = "";
    private double numero1 = 0, numero2 = 0, resultado = 0;
    private boolean nuevaOperacion = true;
    private JPanel panelBotones;

    public calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Pantalla
        pantalla = new JTextField("0");
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        getContentPane().add(pantalla, BorderLayout.NORTH);

        // Panel para los botones con GridLayout
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5)); // 4 filas x 4 columnas con espacio de 5px entre botones

        // Botones
        String botones []= {
                "7", "8", "9", "C",
                "4", "5", "6", "*",
                "1", "2", "3", "/",
                "+", "0", "-", "="
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.addActionListener(this);
            panelBotones.add(boton);
        }

        getContentPane().add(panelBotones, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ("0123456789".contains(comando)) {
            if (nuevaOperacion) {
                pantalla.setText(comando);
                nuevaOperacion = false;
            } else {
                pantalla.setText(pantalla.getText() + comando);
            }
        } else if ("/*-+".contains(comando)) {
            operador = comando;
            numero1 = Double.parseDouble(pantalla.getText());
            nuevaOperacion = true;
        } else if ("=".equals(comando)) {
            numero2 = Double.parseDouble(pantalla.getText());
            switch (operador) {
                case "+" -> resultado = numero1 + numero2;
                case "-" -> resultado = numero1 - numero2;
                case "*" -> resultado = numero1 * numero2;
                case "/" -> resultado = numero1 / numero2;
            }
            pantalla.setText(String.valueOf(resultado));
            nuevaOperacion = true;
        } else if ("C".equals(comando)) {
            pantalla.setText("0");
            numero1 = numero2 = resultado = 0;
            operador = "";
            nuevaOperacion = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            calculadora calculadora = new calculadora();
            calculadora.setVisible(true);
        });
    }

}
