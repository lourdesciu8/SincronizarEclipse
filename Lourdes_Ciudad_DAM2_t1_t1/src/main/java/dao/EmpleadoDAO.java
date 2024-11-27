package dao;

import database.BDConnection;
import models.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public void limpiarTabla() throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "DELETE FROM Empleados";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    public void insertarEmpleado(Empleado empleado) throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "INSERT INTO Empleados (id, nombre, apellidos, correo) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, empleado.getId());
        preparedStatement.setString(2, empleado.getNombre());
        preparedStatement.setString(3, empleado.getApellidos());
        preparedStatement.setString(4, empleado.getCorreo());
        preparedStatement.executeUpdate();
    }

    public List<Empleado> obtenerTodos() throws Exception {
        Connection connection = BDConnection.getConnection();
        String sql = "SELECT * FROM Empleados";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Empleado> empleados = new ArrayList<>();
        while (resultSet.next()) {
            Empleado empleado = new Empleado(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("correo")
            );
            empleados.add(empleado);
        }
        return empleados;
    }
}
