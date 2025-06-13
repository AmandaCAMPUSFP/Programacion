package servicio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Importamos la libreria gson
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class LlmService {

    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";
    private static final String API_KEY = System.getenv("OPENROUTER_API_KEY"); // Usamos la variable de entorno

    // Método principal que envia el prompt al modelo y devuelve la respuesta
    public String obtenerRespuestaIA(String prompt) {
        try {
            // Construimos el JSON del cuerpo de la petición
            JsonObject message = new JsonObject();
            message.addProperty("role", "user");
            message.addProperty("content", prompt);

            JsonArray messagesArray = new JsonArray();
            messagesArray.add(message);

            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("model", "mistralai/mistral-7b-instruct:free");
            requestBody.add("messages", messagesArray);

            // Creamos el cliente HTTP y la petición POST
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

            // Ejecutamos la petición y procesamos la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Extraemos la respuesta del LLM 
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                JsonArray choices = jsonResponse.getAsJsonArray("choices");
                JsonObject firstChoice = choices.get(0).getAsJsonObject();
                JsonObject messageObj = firstChoice.getAsJsonObject("message");
                return messageObj.get("content").getAsString().trim();
            } else {
                return "Error: Código de estado " + response.statusCode();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al conectarse con la IA: " + e.getMessage();
        }
    }
}
