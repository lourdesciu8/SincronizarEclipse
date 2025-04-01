package VentanaBotones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaBotones extends JFrame {

	//Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnContacts;
	private JButton btnMessage;
	private JButton btnCallLog;
	private JButton btnGames;
	private JButton btnSettings;
	private JButton btnApplications;
	private JButton btnMusic;
	private JButton btnGallery;
	private JButton btnOrganiser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBotones frame = new VentanaBotones();
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
	public VentanaBotones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		
		//Se crean los botones y se añaden al panel del GridLayout
		btnContacts = new JButton("Contacts");
		btnContacts.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnContacts);
		
		btnMessage = new JButton("Message");
		btnMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnMessage);
		
		btnCallLog = new JButton("Call Log");
		btnCallLog.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnCallLog);
		
		btnGames = new JButton("Games");
		btnGames.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnGames);
		
		btnSettings = new JButton("Settings");
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSettings);
		
		btnApplications = new JButton("Applications");
		btnApplications.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnApplications);
		
		btnMusic = new JButton("Music");
		btnMusic.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnMusic);
		
		btnGallery = new JButton("Gallery");
		btnGallery.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnGallery);
		
		btnOrganiser = new JButton("Organiser");
		btnOrganiser.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnOrganiser);
	}

}
