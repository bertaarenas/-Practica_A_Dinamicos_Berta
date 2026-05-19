package toDoList;
public class Tarea {

    String nombre;
    String autor;
    String descripcion;
    int duracionAprox;
    String estado;

    public Tarea(String nombre, String autor, String descripcion, int duracionAprox,  String estado) {
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
        this.duracionAprox = duracionAprox;
        this.estado = estado;
    }

    public String getNombre() {return nombre;}
    public String getAutor() {return autor;}
    public String getDescripcion() {return descripcion;}
    public int getDuracionAprox() {return duracionAprox;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Autor: " + autor + " | Descripción: " + descripcion + " | Duración: " + duracionAprox + " | Estado: " + estado;
    }


}
