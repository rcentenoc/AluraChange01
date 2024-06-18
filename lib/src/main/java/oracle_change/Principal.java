package oracle_change;

import javax.swing.*;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class Principal {
	public static void main(String[] args) {		
		try {		
		var APIKEY = "d4d0bb88963b76c5d80a1a6e";
		String[] opcion = { "Conversor de Moneda", "Conversor de temperatura" };
		String[] monedasPrincipales = {"USD","EUR","PEN", "OTRAS...", "EXIT"};
		String[] monedas = {};
		ImageIcon icon = new ImageIcon("src/image/icon.png");
		String seleccion = (String) JOptionPane.showInputDialog(
				null, "Seleccione una opción de conversión: ", "Menu",
				JOptionPane.QUESTION_MESSAGE, icon, opcion, opcion[0]);
		System.out.println(seleccion);
		
			Consulta consulta = new Consulta();
			Conversiones conversiones = consulta.extraeConversiones(APIKEY, "USD");
			List<String> opcionConversorMonedas = new ArrayList<>(conversiones.conversion_rates().keySet());
		
		if (seleccion.equals(opcion[0])) {
			String seleccionMonedaBase = Modulos.consultaTipoMoneda(icon, monedasPrincipales, "Ingrese su moneda: ");
			System.out.println(seleccionMonedaBase);
			
			if (seleccionMonedaBase == "OTRAS...") {
				seleccionMonedaBase = Modulos.capturaConversionMoneda(icon, opcionConversorMonedas);
				System.out.println(seleccionMonedaBase);
			}else if(seleccionMonedaBase == null){
				JOptionPane.showMessageDialog(null, "El dato ingresado no es valido.");
				System.exit(0);
			}
			
			if (Arrays.asList(monedasPrincipales).contains(seleccionMonedaBase)) {
				monedas = ArrayUtils.removeElement(monedasPrincipales, seleccionMonedaBase);
			}else {
				monedas = monedasPrincipales;
			}
			
			String monedaDestino = Modulos.consultaTipoMoneda(icon, monedas, "Ingrese la moneda de su interes a cambiar: ");					
			System.out.println(monedaDestino);	
			
			if(monedaDestino == "OTRAS...") {
				monedaDestino = Modulos.capturaConversionMoneda(icon, opcionConversorMonedas);
				System.out.println(monedaDestino);
			}else if(monedaDestino == null){
				System.out.println(" Saliendo del programa");
				System.exit(0);
			}
			Conversiones conversionesOtras = consulta.extraeConversiones(APIKEY, seleccionMonedaBase);
			System.out.println(conversionesOtras);
			
			double busquedaConversion = conversionesOtras.conversion_rates().get(monedaDestino);
			
			try {
				double tasaConversion = Modulos.capturaConversionMonto();								
				double resultado = Modulos.convertirMonto(tasaConversion,busquedaConversion,monedaDestino);
				System.out.println("Saldo Final: "+resultado+" "+monedaDestino);	
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "EL valor ingresado no es valido");
				System.exit(0);
			}				
			System.exit(0);
		}
		
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}

}


/*
				if(monedaDestino == "OTRAS") {
					Conversiones conversiones = consulta.extraeConversiones(KEY, monedaDestino);
					List<String> opcionConversorMonedas = new ArrayList<>(conversiones.conversion_rates().keySet());
					
					String tipoConversion = Modulos.capturaConversionMoneda(icon, opcionConversorMonedas);
					
					double busquedaConversion = conversiones.conversion_rates().get(tipoConversion);
					
					double tasaConversion = Modulos.capturaConversionMonto();				
					
					double resultado = Modulos.convertirMonto(tasaConversion,busquedaConversion,tipoConversion);
					
				} else if (monedaDestino == null) {
					System.exit(0);
				} else {
					Conversiones conversiones = consulta.extraeConversiones(KEY, monedaDestino);
					List<String> opcionConversorMonedas = new ArrayList<>(conversiones.conversion_rates().keySet());					
				}
*/









	/*
					
					
					
					monedaDestino = (String) JOptionPane.showInputDialog(
							null, "Seleccione la moneda a convertir:", "Conversor de monedas", 
							JOptionPane.QUESTION_MESSAGE, icon, opcionConversorMonedas.toArray(), 
							opcionConversorMonedas.get(0));
					
					double cantidad = Double.parseDouble(JOptionPane.showInputDialog(
							null, "Ingrese la cantidad a convertir: ", 
							"Conversor de monedas Alura", JOptionPane.QUESTION_MESSAGE));
					
					System.out.println("MONTO A CAMBIAR: "+ cantidad +" "+ monedaBase);				
					
					double tasaConversion = conversiones.conversion_rates().get(monedaDestino);				
					
					double resultado = cantidad*tasaConversion;
					System.out.println(tasaConversion+" "+monedaDestino+" "+resultado);
										
					
					
				}else if (seleccionMonedaBase == 1) {
					monedaBase="EUR";
				}else if (seleccionMonedaBase == 2) {
					monedaBase="PEN";
				}else if (seleccionMonedaBase == 3) {
					
				}else if (seleccionMonedaBase == 4) {
					System.exit(0);
				}else {
					System.exit(0);
				}
				
				Conversiones conversiones = consulta.extraeConversiones(KEY, "USD");
				ArrayList<String> opcionConversorMonedas = new ArrayList<>(conversiones.conversion_rates().keySet());
				
				String monedaBase = (String) JOptionPane.showInputDialog(
						null, "Seleccione su moneda base: ",
						"Conversor de monedas Alura", JOptionPane.QUESTION_MESSAGE,
						icon, opcionConversorMonedas.toArray(), opcionConversorMonedas.get(0) );
					
				double cantidad = Double.parseDouble(JOptionPane.showInputDialog(
						null, "Ingrese la cantidad a convertir: ", 
						"Conversor de monedas Alura", JOptionPane.QUESTION_MESSAGE));
				
				System.out.println("MONTO A CAMBIAR: "+ cantidad +" "+ monedaBase);				
				
				String monedaDestino = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda a convertir:", "Conversor de monedas", JOptionPane.QUESTION_MESSAGE, icon, opcionConversorMonedas.toArray(), opcionConversorMonedas.get(0));
				double tasaConversion = conversiones.conversion_rates().get(monedaDestino);				
				
				var resultado = cantidad*tasaConversion;
				System.out.println(tasaConversion+" "+monedaDestino+" "+resultado);				
	 */