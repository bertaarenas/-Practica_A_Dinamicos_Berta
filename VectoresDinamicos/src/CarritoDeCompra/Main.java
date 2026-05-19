package CarritoDeCompra;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Carrito carrito = new Carrito();

        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto("Leche", 1.20));
        catalogo.add(new Producto("Pan", 0.90));
        catalogo.add(new Producto("Huevos", 2.50));
        catalogo.add(new Producto("Arroz", 1.80));
        catalogo.add(new Producto("Tomate", 0.60));
        catalogo.add(new Producto("Pollo", 4.30));
        catalogo.add(new Producto("Agua", 0.50));
        catalogo.add(new Producto("Zumo", 1.95));

        boolean activo = true;

        while (activo) {
            System.out.println("-- MENÚ --");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Añadir producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Generar ticket");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println((i + 1) + ". " + catalogo.get(i));
                    }
                    break;

                case 2:
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println((i + 1) + ". " + catalogo.get(i));
                    }
                    System.out.print("Número de producto: ");
                    int numProducto = sc.nextInt() - 1;
                    sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    carrito.agregarProducto(catalogo.get(numProducto), cantidad);
                    break;

                case 3:
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println((i + 1) + ". " + catalogo.get(i));
                    }
                    System.out.print("Número de producto a eliminar: ");
                    int numEliminar = sc.nextInt() - 1;
                    sc.nextLine();
                    carrito.eliminarProducto(catalogo.get(numEliminar));
                    break;

                case 4:
                    carrito.generarTicket();
                    break;

                case 5:
                    activo = false;
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}