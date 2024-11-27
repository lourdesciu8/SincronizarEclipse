package dao;

import database.BDConnection;
import models.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public void limpiarTabla() throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "DELETE FROM Pedidos";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    public void insertarPedido(Pedido pedido) throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "INSERT INTO Pedidos (id, id_producto, descripcion, precio_total) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pedido.getId());
        preparedStatement.setInt(2, pedido.getIdProducto());
        preparedStatement.setString(3, pedido.getDescripcion());
        preparedStatement.setDouble(4, pedido.getPrecioTotal());
        preparedStatement.executeUpdate();
    }

    public List<Pedido> obtenerTodos() throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "SELECT * FROM Pedidos";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Pedido> pedidos = new ArrayList<>();
        while (resultSet.next()) {
            Pedido pedido = new Pedido(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_producto"),
                    resultSet.getString("descripcion"),
                    resultSet.getDouble("precio_total")
            );
            pedidos.add(pedido);
        }
        return pedidos;
    }
}
