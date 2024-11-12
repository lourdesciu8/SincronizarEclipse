import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class Ventas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Raul\\Documents\\GitHub\\SincronizarEclipse\\eclipse-workspace\\VentanaVentas\\imagenes\\images.jpg"));
		setResizable(false);
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 311);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelVentas = new JLabel("Ventas");
		LabelVentas.setFont(new Font("Tahoma", Font.BOLD, 40));
		LabelVentas.setBounds(163, 70, 208, 41);
		contentPane.add(LabelVentas);
		
		JLabel LabelClientes = new JLabel("Cliente:");
		LabelClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelClientes.setBounds(85, 136, 55, 28);
		contentPane.add(LabelClientes);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(153, 136, 169, 28);
		contentPane.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		JButton ButtonBuscar = new JButton("Buscar");
		ButtonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonBuscar.setBackground(new Color(207, 207, 207));
		ButtonBuscar.setForeground(new Color(0, 0, 0));
		ButtonBuscar.setBounds(345, 136, 85, 28);
		contentPane.add(ButtonBuscar);
	}
}
