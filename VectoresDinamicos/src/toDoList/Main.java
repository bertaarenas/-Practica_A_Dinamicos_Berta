package toDoList;
public class Main {
    public static void main(String[] args) {

        GestordeTareas gestor = new GestordeTareas();

        Tarea t1 = new Tarea("Deberes","Berta","Hacer los deberes de programación", 120,"Pendiente");
        Tarea t2 = new Tarea("Compra", "Berta", "Hacer la compra semanal", 120, "En proceso");

        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);

        System.out.println(" -- TAREAS --");
        gestor.mostrarTareas();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        System.out.println("Tareas actualizadas:");

        gestor.actualizarEstado("Deberes", "Completada");
        gestor.actualizarEstado("Compra", "Completada");


        gestor.mostrarTareas();

    }
}
