
package practica6;

/**
 *
 * @author jordan Simo
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
public class Practica6 {

    
    public static void main(String[] args) {
       try {
            // URL del servicio web REST
            String apiUrl = "https://api.chucknorris.io/jokes/random";

            // Realizar la solicitud HTTP
            String jsonResponse = sendHttpRequest(apiUrl);

            // Crear un HashMap para almacenar la respuesta
            HashMap<String, String> chuckNorrisJokeMap = new HashMap<>();

            // Analizar la respuesta JSON y almacenarla en el HashMap
            chuckNorrisJokeMap.put("ChuckNorrisJoke", jsonResponse);

            // Imprimir el HashMap
            System.out.println("Chuck Norris Joke HashMap: " + chuckNorrisJokeMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     private static String sendHttpRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Leer la respuesta del servicio web
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();
        } finally {
            connection.disconnect();
        }
    }
}
