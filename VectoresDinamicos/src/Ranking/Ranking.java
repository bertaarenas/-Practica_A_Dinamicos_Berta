package Ranking;
import java.util.*;
public class Ranking {
    private HashMap<String, Integer> puntuaciones = new HashMap<>();

    public void setPuntuacion(String jugador, int puntos) {
        puntuaciones.put(jugador, puntos);
    }

    public void mostrarRanking() {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(puntuaciones.entrySet());

        lista.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("-- RANKING --");
        for (Map.Entry<String, Integer> e : lista) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println();
    }
}