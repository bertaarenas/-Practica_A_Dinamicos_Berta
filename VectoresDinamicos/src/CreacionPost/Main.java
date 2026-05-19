package CreacionPost;
import java.util.HashMap;
import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
public class Main {

    static HashMap<String, Post> posts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("== NUEVO POST ==");

        System.out.print("Nombre del post: ");
        String nombre = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("URL de la foto: ");
        String foto = sc.nextLine();

        Post post = new Post(nombre, autor, foto);
        posts.put(nombre, post);

        String json = post.toString();
        System.out.println("JSON generado: " + json);

        System.out.print("IP del servidor (ej: 192.168.1.10): ");
        String ip = sc.nextLine();

        System.out.print("Puerto (ej: 8080): ");
        String puerto = sc.nextLine();

        enviarPost(ip, puerto, json);
    }

    static void enviarPost(String ip, String puerto, String json) {
        try {
            String urlCompleta = "http://" + ip + ":" + puerto + "/api/posts";
            URL url = new URL(urlCompleta);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
                os.flush();
            }

            int respuesta = conn.getResponseCode();
            if (respuesta == 200) {
                System.out.println("Post enviado correctamente");
            } else {
                System.out.println("Error del servidor: " + respuesta);
            }

            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}
