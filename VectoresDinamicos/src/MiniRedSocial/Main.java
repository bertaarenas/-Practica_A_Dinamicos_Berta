package MiniRedSocial;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    static HashMap<String, Usuario> usuarios = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        usuarios.put("ana@mail.com", new Usuario("ana@mail.com", "1234"));
        usuarios.put("luis@mail.com", new Usuario("luis@mail.com", "abcd"));
        usuarios.get("ana@mail.com").publicar("Hola a todos.");
        usuarios.get("luis@mail.com").publicar("Mi primera publicación");

        System.out.println("== MINI RED SOCIAL ==");
        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (usuarios.containsKey(correo)) {
            Usuario u = usuarios.get(correo);

            if (u.contrasena.equals(pass)) {
                System.out.println("Bienvenido, " + correo);
                menu(u);
            }
            else {
                System.out.println("Contraseña incorrecta");
            }
        }
        else {
            System.out.println("Usuario no encontrado");
        }
    }

    static void menu(Usuario usuarioActual) {
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Ver publicaciones de otros");
            System.out.println("2. Publicar algo");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    for (String correo : usuarios.keySet()) {
                        if (!correo.equals(usuarioActual.correo)) {
                            System.out.println("-- " + correo + " --");
                            for (String post : usuarios.get(correo).publicaciones) {
                                System.out.println("  · " + post);
                            }
                        }
                    }
                    break;

                case "2":
                    System.out.print("Escribe tu publicación: ");
                    String texto = sc.nextLine();
                    usuarioActual.publicar(texto);
                    System.out.println("Publicado!");
                    break;

                case "3":
                    salir = true;
                    break;
            }
        }
    }
}
