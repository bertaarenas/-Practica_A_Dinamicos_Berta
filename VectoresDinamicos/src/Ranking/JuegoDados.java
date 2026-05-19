package Ranking;
public class JuegoDados {

    String nombre;
    String ia;
    int puntosJugador = 0;
    int puntosIA = 0;

    public JuegoDados(String nombre, String ia) {
        this.nombre = nombre;
        this.ia = ia;
        this.puntosJugador = 0;
        this.puntosIA = 0;
    }

    public void jugar() {

        int dadoJugador = (int) (Math.random() * 6) + 1;
        int dadoIA = (int) (Math.random() * 6) + 1;

        System.out.println(nombre + " saca: " + dadoJugador);
        System.out.println(ia + " saca: " + dadoIA);

        if (dadoJugador > dadoIA) {
            System.out.println("Gana " + nombre + "!");
            puntosJugador += 1;

        }
        else if (dadoIA > dadoJugador) {
            System.out.println("Gana " + ia + "!");
            puntosIA += 1;

        }
        else {
            System.out.println("Empate.");
        }
    }
}