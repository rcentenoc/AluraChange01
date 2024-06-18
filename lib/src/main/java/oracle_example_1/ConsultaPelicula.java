package oracle_example_1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultaPelicula {
	Pelicula buscaPelicula(int numeroDePelicula) throws IOException, InterruptedException{
		try {
			
			URI direccion = URI.create("https://swapi.dev/api/films/"+numeroDePelicula+"/");
			HttpClient client = HttpClient.newHttpClient();			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(direccion)
					.build();
			
			HttpResponse<String> response = client
					.send(request, HttpResponse.BodyHandlers.ofString());
					
			return new Gson().fromJson(response.body(),Pelicula.class);
		} catch ( Exception e) {
			throw new RuntimeException("No se encontro esa película: "+e.getMessage());
		}
	}
}
