package JSON;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
public class ConsultaPokeAPI {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://pokeapi.co/api/v2/pokemon/pikachu");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder json = new StringBuilder();
        String linea;
        while ((linea = reader.readLine()) != null) {json.append(linea);}
        reader.close();
        conn.disconnect();

        String jsonTexto = json.toString();

        HashMap<String, String> pokemon = new HashMap<>();

        pokemon.put("nombre",    extraerCampo(jsonTexto, "name"));
        pokemon.put("id",        extraerCampo(jsonTexto, "id"));
        pokemon.put("peso",      extraerCampo(jsonTexto, "weight"));
        pokemon.put("altura",    extraerCampo(jsonTexto, "height"));
        pokemon.put("xp_base",  extraerCampo(jsonTexto, "base_experience"));


        System.out.println("== DATOS POKÉMON ==");
        for (String clave : pokemon.keySet()) {
            System.out.println(clave + " - " + pokemon.get(clave));
        }
    }

    static String extraerCampo(String json, String clave) {
        String buscar = "\"" + clave + "\":";
        int inicio = json.indexOf(buscar);
        if (inicio == -1) {
            return "no encontrado";
        }

        inicio += buscar.length();
        int fin = json.indexOf(",", inicio);
        if (fin == -1) {
            fin = json.indexOf("}", inicio);
        }

        return json.substring(inicio, fin).replace("\"", "").trim();
    }
}