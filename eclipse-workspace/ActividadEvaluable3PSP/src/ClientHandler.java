import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            // Lo primero que se recibe debe ser el nombre del usuario
            out.println("Enter your username:");
            username = in.readLine();

            if (username == null || username.isEmpty()) {
                out.println("Invalid username.");
                socket.close();
                return;
            }

            ChatServer.clients.put(username, this);
            out.println("Chat iniciado");
            broadcastUserList(); // notifica a todos los clientes al conectarse


            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Formato esperado: destinatario:mensaje
                if (inputLine.contains(":")) {
                    String[] parts = inputLine.split(":", 2);
                    String targetUser = parts[0].trim();
                    String message = parts[1].trim();

                    ClientHandler target = ChatServer.clients.get(targetUser);
                    if (target != null) {
                        target.sendMessage(username + ": " + message);
                    } else {
                        out.println("User '" + targetUser + "' not found.");
                    }
                } else {
                    out.println("Invalid format. Use: destinatario:mensaje");
                }
            }

        } catch (IOException e) {
            System.out.println("Usuario desconectado: " + username);
        } finally {
            try {
                ChatServer.clients.remove(username);
                socket.close();
                broadcastUserList(); // notifica a todos los clientes
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para enviar un mensaje a este cliente
    public void sendMessage(String msg) {
        out.println(msg);
    }
    
    //Método para 
    private void broadcastUserList() {
        StringBuilder userList = new StringBuilder("#USERS#");

        for (String user : ChatServer.clients.keySet()) {
            userList.append(" ").append(user);
        }

        for (ClientHandler client : ChatServer.clients.values()) {
            client.sendMessage(userList.toString());
        }
    }

}
