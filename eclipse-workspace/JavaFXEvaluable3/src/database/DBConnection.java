package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection dbconnection;

    public static Connection getDbconnection() {
        try {
            // Verifica si la conexión no existe o está cerrada, sino la crea.
            if (dbconnection == null || dbconnection.isClosed()) {
                createConnection();
            }
        } catch (SQLException e) {
            System.out.println("Error verificando la conexión: " + e.getMessage());
        }
        return dbconnection;
    }

    private static void createConnection() {
        String url = "jdbc:mysql://127.0.0.1:33060/gestion_modulos?useSSL=false";
        //pass: secret
        //"jdbc:mysql://localhost:33060/gestion_modulos?useSSL=false";
        
        try {
            dbconnection = DriverManager.getConnection(url, "root", "secret");
            System.out.println("Conexión establecida con la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión al servidor de la base de datos: " + e.getMessage());
        }
    }
}



