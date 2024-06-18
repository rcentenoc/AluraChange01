package oracle_example;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Busqueda {
	public static void main(String[] args) throws IOException, InterruptedException, RuntimeException{
		
		try (Scanner lectura = new Scanner(System.in)) {
			List<Titulo> titulos = new ArrayList<>();
			//Gson gson = new Gson();
			Gson gson = new GsonBuilder()
					.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
					.setPrettyPrinting()
					.create();
			
			while(true) {
				String APIKEY = "d8f7e59";
				System.out.println("Escriba el nombre de la película: ");
				var busqueda = lectura.nextLine();
				if (busqueda.equalsIgnoreCase("salir")) {
					break;
				}
				
				String direccion = "https://www.omdbapi.com/?t="+busqueda.replace(' ','+')+"&apikey="+APIKEY;
				System.out.println(direccion);
				
				HttpClient client = HttpClient.newHttpClient();			
				HttpRequest request = HttpRequest.newBuilder()
				      .uri(URI.create(direccion))
				      .build();
				
				HttpResponse<String> response = client
					  .send(request, HttpResponse.BodyHandlers.ofString());
				
				String json = response.body();
				System.out.println(json);
							
				TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
				System.out.println(miTituloOmdb);
				
				Titulo miTitulo = new Titulo(miTituloOmdb);
				System.out.println(miTitulo.toString());
				titulos.add(miTitulo);
				
			}
			System.out.println("Finaliznado programa");
			System.out.println("Consultas: ");
			System.out.println(titulos);
			
			FileWriter escritura = new FileWriter("titulos.json");
			escritura.write(gson.toJson(titulos));
			escritura.close();
		}catch (Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
