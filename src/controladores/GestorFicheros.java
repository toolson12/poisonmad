package controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorFicheros {

	public ArrayList<HashMap<String, String>> leerArchivo(String rutaArchivo) throws IOException {

		File fichero = new File(rutaArchivo);		
		BufferedReader buffer;
		FileReader lector;
		ArrayList<HashMap<String, String>> listaDatos = new ArrayList<HashMap<String, String>>() ;		


		if (fichero.exists()) {
			lector = new FileReader(fichero); // Iniciador
			buffer = new BufferedReader(lector); // Buffer		


		} else {
			System.out.println("Fichero no encontrado"); // TODO implementación con gestión de errores
			return listaDatos;
		}

		String linea = "";
		linea = buffer.readLine();		
		while (linea != null) {
			String[] lineaSpliteada = linea.split(";");			
			if (rutaArchivo.contains("horario")) {
				HashMap<String, String> datos = splitDatosAire(lineaSpliteada);
				listaDatos.add(datos);
				linea = buffer.readLine();
			} else if (rutaArchivo.contains("codigosEstaciones")) {
				HashMap<String, String> datos = splitDatosEstaciones(lineaSpliteada);
				listaDatos.add(datos);
				linea = buffer.readLine();
			} else if (rutaArchivo.contains("codigosMagnitudes")) {
				HashMap<String, String> datos = splitDatosMagnitudes(lineaSpliteada);
				listaDatos.add(datos);
				linea = buffer.readLine();
			}			
		}	
		// Elimino de manera programática la primera entrada de datos ya que no me interesan (son las cabeceras).
		// Según qué circustancias podría usarlas como cabeceras del html, pero dada la denominación, las elimino. 
		if (rutaArchivo.contains("horario")) {			
			listaDatos.remove(0);
		}
		lector.close();
		buffer.close();
		return listaDatos;
	}

	public HashMap<String, String> splitDatosAire(String[] lineaSpliteada) {	
		HashMap<String, String> datos = new HashMap<>();	
		datos.put("Provincia", lineaSpliteada[0]);
		datos.put("Municipio", lineaSpliteada[1]);
		datos.put("Estacion", lineaSpliteada[2]);
		datos.put("Magnitud", lineaSpliteada[3]);
		datos.put("puntoMuestreo", lineaSpliteada[4]);
		datos.put("anio", lineaSpliteada[5]);
		datos.put("mes", lineaSpliteada[6]);
		datos.put("dia", lineaSpliteada[7]);
		
		int idx = 8;
		for (int i=1; i<25; i++) {
			String hora = "h"+i;
			datos.put(hora, lineaSpliteada[idx]);
			idx+= 1;
			String validado = "v" +i;
			datos.put(validado, lineaSpliteada[idx]);
			idx+=1;
		}			
		return datos;
	}


	public HashMap<String, String> splitDatosEstaciones(String[] lineaSpliteada) {	
		HashMap<String, String> datos = new HashMap<>();					
		datos.put("codEstacion", lineaSpliteada[0]);			
		datos.put("nombreEstacion", lineaSpliteada[1]);			
		return datos;
	}

	public HashMap<String, String> splitDatosMagnitudes(String[] lineaSpliteada) {	
		HashMap<String, String> datos = new HashMap<>();
		
		datos.put("codMagnitud", lineaSpliteada[0]);
		datos.put("nombreMagnitud", lineaSpliteada[1]);
		return datos;
	}

}


