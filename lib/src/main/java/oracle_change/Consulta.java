package oracle_change;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class Consulta {
	Conversiones extraeConversiones(String KEY, String MONEDA) throws IOException, InterruptedException {
		try {
			URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + KEY + "/latest/" + MONEDA + "/");
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), Conversiones.class);
            } else {
                throw new RuntimeException("Error en la respuesta: " + response.statusCode() + " " + response.body());
            }
		} catch (IOException | InterruptedException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("No se encontro la moneda: " + e.getMessage());
		}
	}
	
	
	
}
