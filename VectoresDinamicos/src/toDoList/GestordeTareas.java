package toDoList;
import java.util.ArrayList;
public class GestordeTareas {

    private ArrayList<Tarea> listaTareas;

    public GestordeTareas() {
        listaTareas = new ArrayList<Tarea>();
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    public void mostrarTareas() {
        for (Tarea tarea : listaTareas) {
            System.out.println(tarea);
        }
    }

    public Tarea buscarTarea(String nombre) {
        for (Tarea t : listaTareas) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null;
    }

    public void actualizarEstado(String nombre, String nuevoEstado) {
        Tarea t = buscarTarea(nombre);
        if (t != null) {
            t.setEstado(nuevoEstado);
        }
        else {
            System.out.println("No se ha encontrado ninguna tarea con ese nombre.");
        }
    }
}
