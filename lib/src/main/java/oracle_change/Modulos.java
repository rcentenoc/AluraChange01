package oracle_change;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Modulos {
	
	public static String consultaTipoMoneda (ImageIcon icon, Object[] object, String frase){
		int seleccionMonedaBase = JOptionPane.showOptionDialog( 
				null, frase, "Conversor de monedas Alura",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				icon, object , object[0]);
		System.out.println(object.length);
		if(seleccionMonedaBase <= (object.length - 2)) {
			return (String) object[seleccionMonedaBase];
		}else {
			return null;
		}
	};
	
	public static String capturaConversionMoneda(ImageIcon icon, List<String> object) {
		try {
		String monedaDestino = (String) JOptionPane.showInputDialog(
				null, "Seleccione la moneda a convertir:", "Conversor de monedas", 
				JOptionPane.QUESTION_MESSAGE, icon, object.toArray(), 
				object.get(0));
			return monedaDestino;			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"El valor ingresado no es valido: "+e);
			return "El valor ingresado no es valido "+e;
		}
	}
	
	public static double capturaConversionMonto(){
		double cantidad = Double.parseDouble(JOptionPane.showInputDialog(
				null, "Ingrese la cantidad a convertir: ", 
				"Conversor de monedas Alura", JOptionPane.QUESTION_MESSAGE));
		return cantidad;		
	}
	
	public static double convertirMonto(Double monto, Double tasaConversion, String tipoConversion) {
		var resultado = Math.round((monto * tasaConversion)* 100.0)/ 100.0;
		JOptionPane.showMessageDialog(null, "Tu saldo total es: "+resultado+" "+tipoConversion);
		return resultado;
	}
	
}



