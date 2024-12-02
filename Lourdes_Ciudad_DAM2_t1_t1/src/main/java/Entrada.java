import dao.EmpleadoDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import models.Empleado;
import models.Pedido;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            PedidoDAO pedidoDAO = new PedidoDAO();
            ProductoDAO productoDAO = new ProductoDAO();

            // Limpiar tablas
          /*  empleadoDAO.limpiarTabla();
            pedidoDAO.limpiarTabla();
            productoDAO.limpiarTabla();*/

            // Insertar productos desde el JSON
            String jsonUrl = "https://dummyjson.com/products";
            productoDAO.insertarProductosDesdeJson(jsonUrl);

            // Solicitar empleados por teclado
            System.out.println("¿Cuántos empleados quieres agregar?");
            int numEmpleados = scanner.nextInt();
            scanner.nextLine(); // Consumir línea pendiente
            for (int i = 0; i < numEmpleados; i++) {
                System.out.println("Empleado " + (i + 1) + ":");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellidos: ");
                String apellidos = scanner.nextLine();
                System.out.print("Correo: ");
                String correo = scanner.nextLine();

                Empleado empleado = new Empleado(nombre, apellidos, correo);
                empleadoDAO.insertarEmpleado(empleado);
            }

            // Solicitar pedidos por teclado
            System.out.println("¿Cuántos pedidos quieres agregar?");
            int numPedidos = scanner.nextInt();
            scanner.nextLine(); // Consumir línea pendiente
            for (int i = 0; i < numPedidos; i++) {
                System.out.println("Pedido " + (i + 1) + ":");
                System.out.print("ID del Producto: ");
                int idProducto = scanner.nextInt();
                scanner.nextLine(); // Consumir línea pendiente
                System.out.print("Descripción: ");
                String descripcion = scanner.nextLine();
                System.out.print("Precio Total: ");
                double precioTotal = scanner.nextDouble();

                Pedido pedido = new Pedido(idProducto, descripcion, precioTotal);
                pedidoDAO.insertarPedido(pedido);
            }

            // Insertar productos favoritos con precio > 1000
            productoDAO.insertarProductosFavoritos(1000.0);

            // Mostrar datos
            System.out.println("Empleados : " + empleadoDAO.obtenerTodos());
            System.out.println("Pedidos : " + pedidoDAO.obtenerTodos());
            System.out.println("Mostrando productos: " + productoDAO.obtenerTodos());
            System.out.println("Productos con precio < 600 : " +productoDAO.productosPorPrecio(600));
            System.out.println("Productos favoritos con precio > 1000 añadidos correctamente ");
        } catch (Exception e) {
            System.out.println("Error en la ejecución");
            System.out.println(e.getMessage());
        }
    }
}
