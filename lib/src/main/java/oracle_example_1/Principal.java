package oracle_example_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oracle_example.Titulo;

public class Principal {
	public static void main(String[] args) throws IOException, InterruptedException {
		try (Scanner lectura = new Scanner(System.in)) {
			List<Titulo> peliculasConsultadas = new ArrayList<>();

			ConsultaPelicula consulta = new ConsultaPelicula();
			while(true) {
				System.out.println("Si desea salir del programa ingrese salir o de lo contrario, ");
				System.out.println("Ingrese el número de pelicula a consultar:");
				var numeroDePelicula = lectura.next();
				if (numeroDePelicula.equalsIgnoreCase("salir")) {
					System.out.println("Finalizando programa");
					break;
				}
				Pelicula pelicula = consulta.buscaPelicula(Integer.valueOf(numeroDePelicula));
				System.out.println(pelicula);			
				GeneradorDeArchivo generador = new GeneradorDeArchivo();
				generador.guardarJson(pelicula);
			}						
		} catch (RuntimeException | IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Finalizando programa");
		}
	}
}
