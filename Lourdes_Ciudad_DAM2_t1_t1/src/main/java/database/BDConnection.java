package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

    private static Connection connection; //Esta es la conexión con la BBDD

    // necesito que se pueda crear la conexion -> solo la primera vez(después usaré copias de la conexión)

    // pedir conexion -> tantas como veces me pida -> te paso la que ya existe
    public static Connection getConnection(){

        // la primera vez la creas
        if (connection == null){
            createConnection();
        }

        //Si no es nula, es porque ya existe, entonces la retornas:
        return connection;
    }

    private static void createConnection(){
        // protocolo de conexion jdbc:mysql
        // host: 127.0.0.1
        // database: almacen
        String url =String.format("jdbc:mysql://%s/%s", SchemaDB.HOST, SchemaDB.DB_NAME) ;
        try {
            connection = DriverManager.getConnection(url,"root","");
            System.out.println("Conexión creada con éxito");
        } catch (SQLException e) {
            System.out.println("Error en la conexión al servidor de base de datos");
        }
    }

}
