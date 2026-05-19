package MiniRedSocial;
import java.util.ArrayList;
public class Usuario {
    String correo;
    String contrasena;
    ArrayList<String> publicaciones;

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.publicaciones = new ArrayList<>();
    }

    public void publicar(String texto) {
        publicaciones.add(texto);
    }
}