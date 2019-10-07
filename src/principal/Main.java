package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import controladores.CreadorHtml;
import controladores.GestorFicheros;

public class Main {

	public static void main(String[] args) throws IOException {

		GestorFicheros gestor = new GestorFicheros();
		ArrayList<HashMap<String, String>> datosAire = gestor.leerArchivo("ficheros\\horario.csv");
				ArrayList<HashMap<String, String>> datosEstaciones = gestor.leerArchivo("ficheros\\codigosEstaciones.csv");
				ArrayList<HashMap<String, String>> datosMagnitudes = gestor.leerArchivo("ficheros\\codigosMagnitudes.csv");
				CreadorHtml creador = new CreadorHtml();
				creador.crearHtml(datosAire, datosEstaciones, datosMagnitudes);


	}
}
