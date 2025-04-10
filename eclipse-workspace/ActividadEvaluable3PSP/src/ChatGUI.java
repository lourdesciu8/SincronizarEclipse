import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class ChatGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private JList<String> userList;
    private String username;
    private JLabel lblUsuariosLinea;
    
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    

    public ChatGUI() {
        setTitle("Chat Client");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatArea);

        messageField = new JTextField();
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
     
        userList = new JList<>();
        JScrollPane userScroll = new JScrollPane(userList);
        userScroll.setPreferredSize(new Dimension(100, 0));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(userScroll, BorderLayout.EAST);
        
        lblUsuariosLinea = new JLabel("EN LÍNEA:");
        lblUsuariosLinea.setFont(new Font("Tahoma", Font.BOLD, 12));
        userScroll.setColumnHeaderView(lblUsuariosLinea);
        getContentPane().add(chatScroll, BorderLayout.CENTER);
        
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());

        userList.setSelectedIndex(0); // selecciona el primer usuario automáticamente
        
        setVisible(true);

        connectToServer();
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 12345);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Leer mensaje del servidor que pide el nombre de usuario
            String request = in.readLine();
            username = JOptionPane.showInputDialog(this, request);
            out.println(username);

            // Hilo para recibir mensajes
            new Thread(() -> {
                String line;
                try {
                    while ((line = in.readLine()) != null) {
                        if (line.startsWith("#USERS#")) {
                            // Extraer los nombres de usuario
                            String[] users = line.substring(8).trim().split(" ");
                            SwingUtilities.invokeLater(() -> {
                                DefaultListModel<String> model = new DefaultListModel<>();
                                for (String user : users) {
                                    // Evita que el usuario se vea a sí mismo en la lista
                                    if (!user.equals(username)) {
                                        model.addElement(user);
                                    }
                                }
                                userList.setModel(model);
                            });
                        } else {
                        	String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
                        	chatArea.append("[" + currentTime + "] " + line + "\n");

                        }
                    }
                } catch (IOException e) {
                    chatArea.append("Disconnected from server.\n");
                }
            }).start();


        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error connecting to server: " + e.getMessage());
        }
    }

    private void sendMessage() {
        if (out == null) {
            chatArea.append("You are not connected to the server.\n");
            return;
        }

        String message = messageField.getText().trim();
        String targetUser = userList.getSelectedValue();

        if (!message.isEmpty()) {
            if (targetUser == null) {
                chatArea.append("Please select a user to send the message.\n");
                return;
            }

            message = message.replace(":)", "😊")
                             .replace(":D", "😄")
                             .replace(":(", "😞")
                             .replace(";)", "😉")
                             .replace(":P", "😛")
                             .replace("<3", "❤️");

            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            //Se simula una alineacion a la derecha dejando espacios al principio de la linea para poder
            //diferenciar mejor visualmente los mensajes enviados de los recibidos
            //chatArea.append("[" + time + "] Tú: " + message + "\n");
            int padding = 100; // ajusta según el ancho de la ventana
            String paddedMessage = String.format("%" + padding + "s", "[" + time + "] Tú: " + message);
            chatArea.append(paddedMessage + "\n");
            
            
            out.println(targetUser + ":" + message);
            messageField.setText("");

        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatGUI::new);
    }
}

