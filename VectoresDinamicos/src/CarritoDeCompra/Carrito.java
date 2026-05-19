package CarritoDeCompra;
import java.util.*;
public class Carrito {

    private HashMap<Producto, Integer> productos = new HashMap<>();

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
        System.out.println("Añadido: " + producto.getNombre() + " x" + cantidad);
    }

    public void eliminarProducto(Producto producto) {
        if (productos.containsKey(producto)) {
            productos.remove(producto);
            System.out.println("Eliminado: " + producto.getNombre());
        }
        else {
            System.out.println("El producto no está en el carrito.");
        }
    }

    public void generarTicket() {
        System.out.println("------------------------------");
        System.out.println("   SUPERMERCADOS BERTA");
        System.out.println("-------------------------------");

        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        }
        else {
            double total = 0;
            for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
                Producto p = entry.getKey();
                int cantidad = entry.getValue();
                double subtotal = p.getPrecio() * cantidad;
                total += subtotal;

                System.out.println(p.getNombre() + " x" + cantidad + " -> " + subtotal + "€");
            }
            System.out.println("-----------------------------");
            System.out.println("TOTAL: " + total + "€");
        }

        System.out.println("Gracias por la compra.");

    }
}