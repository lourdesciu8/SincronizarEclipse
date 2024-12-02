package dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.BDConnection;
import models.Producto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void limpiarTabla() throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "DELETE FROM Productos";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    public void insertarProducto(Producto producto) throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "INSERT INTO Productos (id, nombre, descripcion, cantidad, precio) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, producto.getId());
        preparedStatement.setString(2, producto.getTitle());
        preparedStatement.setString(3, producto.getDescription());
        preparedStatement.setInt(4, producto.getStock());
        preparedStatement.setDouble(5, producto.getPrice());
        preparedStatement.executeUpdate();
    }

    public List<Producto> obtenerTodos() throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "SELECT * FROM Productos";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Producto> productos = new ArrayList<>();
        while (resultSet.next()) {
            Producto producto = new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("precio")
            );
            productos.add(producto);
        }
        return productos;
    }

    public void insertarProductosDesdeJson(String jsonUrl) throws Exception {
        Connection connection = BDConnection.getConnection();

        // Comprobar si la tabla Productos tiene datos
        String Sql = "SELECT COUNT(*) FROM Productos";
        PreparedStatement preparedStatement = connection.prepareStatement(Sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);

        // Si la tabla no tiene datos, cargar desde el JSON
        if (count == 0) {
            System.out.println("La tabla Productos está vacía. Cargando datos desde JSON...");

            // Conexión a la URL
            URL url = new URL(jsonUrl);
            HttpURLConnection connectionUrl = (HttpURLConnection) url.openConnection();

            // Leer los datos desde la conexión con un BufferedReader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connectionUrl.getInputStream()));
            String linea = bufferedReader.readLine(); // Leer la primera línea del JSON

            // Convertir el String del JSON a un JSONObject
            JsonObject response = new Gson().fromJson(linea, JsonObject.class);

            // Extraer el array "products" del JSONObject
            for (Object productObj : response.getAsJsonArray("products")) {
                if (productObj instanceof JsonObject) {
                    // Convertir cada objeto JSON a un Producto usando Gson
                    Producto producto = new Gson().fromJson(productObj.toString(), Producto.class);

                    // Insertar el producto en la base de datos
                    insertarProducto(producto);
                }
            }

            System.out.println("Productos agregados exitosamente desde el JSON.");
        } else {
            System.out.println("La tabla Productos ya tiene datos. No se realizará la importación.");
        }
    }

    public void insertarProductosFavoritos(double precioMinimo) throws Exception {
        Connection connection = BDConnection.getConnection();

        // Limpiar la tabla Productos_Fav antes de insertar nuevos registros
        String deleteSql = "DELETE FROM Productos_Fav";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
        deleteStatement.executeUpdate();

        // Insertar productos favoritos con precio superior al mínimo
        String sql = "INSERT INTO Productos_Fav (id_producto) SELECT id FROM Productos WHERE precio > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, precioMinimo);
        preparedStatement.executeUpdate();

    }

    public List<Producto> productosPorPrecio(double precio) throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "SELECT * FROM Productos WHERE precio < ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, precio);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Producto> productos = new ArrayList<>();
        while (resultSet.next()) {
            Producto producto = new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("precio")
            );
            productos.add(producto);
        }
        return productos;
    }
}
