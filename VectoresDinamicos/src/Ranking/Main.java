package Ranking;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ranking ranking = new Ranking();

        System.out.print("Nombre del jugador: ");
        String nombreJugador = sc.nextLine();

        String nombreIA = "IA";

        JuegoDados juego = new JuegoDados(nombreJugador, nombreIA);

        boolean jugar = true;

        while (jugar) {
            juego.jugar();

            ranking.setPuntuacion(nombreJugador, juego.puntosJugador);
            ranking.setPuntuacion(nombreIA, juego.puntosIA);;

            ranking.mostrarRanking();

            System.out.print("Quieres jugar otra partida? (s/n): ");
            String opcion = sc.nextLine().toLowerCase();
            if (!opcion.equals("s")) {
                jugar = false;
            }
        }

        System.out.println("Has terminado. Ranking final:");
        ranking.mostrarRanking();
    }
}