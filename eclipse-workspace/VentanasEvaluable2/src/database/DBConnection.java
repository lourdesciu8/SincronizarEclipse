package database;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

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
        String url = "jdbc:mysql://127.0.0.1/gestion_modulos";
        try {
            dbconnection = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión establecida con la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión al servidor de la base de datos: " + e.getMessage());
        }
    }
}
