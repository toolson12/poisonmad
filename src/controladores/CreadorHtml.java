package controladores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreadorHtml {


	public String crearHtml(ArrayList<HashMap<String, String>> datosAire, 
							ArrayList<HashMap<String, String>> datosEstaciones,
							ArrayList<HashMap<String, String>> datosMagnitudes) throws IOException {
		
		File ficheroHtml = new File("ficheros\\tabla.html");				
		BufferedWriter bufferEscritura;
		String htmlFormado = "";

		
		ficheroHtml.createNewFile();
		FileWriter ficheroAEscribir = new FileWriter(ficheroHtml);	
		bufferEscritura = new BufferedWriter(ficheroAEscribir);

		StringBuilder formadorHtml = new StringBuilder();
		formadorHtml.append("<html>" +
				"<head>" + 
				"<title>Calidad del aire en Madrid</title>" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">" + 
				"<meta charset=\"UTF-8\">" +
				"</head>" +
				"<body>" +
				"<table>" +
				"<tr>" +
				"<th>Municipio</th>" +
				"<th>Estacion</th>" +
				"<th>Magnitud</th>" +
				"<th>Fecha</th>" +
				"<th>00:00</th>" +
				"<th>01:00</th>" +
				"<th>02:00</th>" +
				"<th>03:00</th>" +
				"<th>04:00</th>" +
				"<th>05:00</th>" +
				"<th>06:00</th>" +
				"<th>07:00</th>" +
				"<th>08:00</th>" +
				"<th>09:00</th>" +
				"<th>10:00</th>" +
				"<th>11:00</th>" +
				"<th>12:00</th>" +
				"<th>13:00</th>" +
				"<th>14:00</th>" +
				"<th>15:00</th>" +
				"<th>16:00</th>" +
				"<th>17:00</th>" +
				"<th>18:00</th>" +
				"<th>19:00</th>" +
				"<th>20:00</th>" +
				"<th>21:00</th>" +
				"<th>22:00</th>" +
				"<th>23:00</th>" +					
				"</tr>");

		for (HashMap<String, String> d : datosAire) {
			formadorHtml.append("<tr>")
			.append("<td>" + d.get("Municipio") + "</td>")
			.append("<td>" + conversorEstacion(d.get("Estacion"), datosEstaciones) + "</td>")	
			.append("<td>" + conversorMagnitud(d.get("Magnitud"), datosMagnitudes) + "</td>")	
			.append("<td>" + d.get("dia")+ "-" +d.get("mes")+ "-" + d.get("anio") + "</td>")	
			.append("<td>" + d.get("h1") + "</td>")
			.append("<td>" + d.get("h2") + "</td>")
			.append("<td>" + d.get("h3") + "</td>")
			.append("<td>" + d.get("h4") + "</td>")
			.append("<td>" + d.get("h5") + "</td>")
			.append("<td>" + d.get("h6") + "</td>")
			.append("<td>" + d.get("h7") + "</td>")
			.append("<td>" + d.get("h8") + "</td>")
			.append("<td>" + d.get("h9") + "</td>")
			.append("<td>" + d.get("h10") + "</td>")
			.append("<td>" + d.get("h11") + "</td>")
			.append("<td>" + d.get("h12") + "</td>")
			.append("<td>" + d.get("h13") + "</td>")
			.append("<td>" + d.get("h14") + "</td>")
			.append("<td>" + d.get("h15") + "</td>")
			.append("<td>" + d.get("h16") + "</td>")
			.append("<td>" + d.get("h17") + "</td>")
			.append("<td>" + d.get("h18") + "</td>")
			.append("<td>" + d.get("h19") + "</td>")
			.append("<td>" + d.get("h20") + "</td>")
			.append("<td>" + d.get("h21") + "</td>")
			.append("<td>" + d.get("h22") + "</td>")
			.append("<td>" + d.get("h23") + "</td>")	
			.append("<td>" + d.get("h24") + "</td>")					
			.append("</tr>");
		
		}
		
		formadorHtml.append("</table>" +
				"</body>" +
				"</html>");

		htmlFormado = formadorHtml.toString();
		bufferEscritura.write(htmlFormado);

		bufferEscritura.close();		
		ficheroAEscribir.close();
		System.out.println("Fichero HTML creado con éxito");
		return htmlFormado;
		

	}
	
	public String conversorEstacion(String codigo, ArrayList<HashMap<String, String>> datosEstaciones) {
		String nombreEstacion = "";
		for (HashMap<String, String> datos : datosEstaciones) {	
			if (datos.get("codEstacion").equals(codigo)){				
				nombreEstacion = datos.get("nombreEstacion");
				return nombreEstacion;
			}			
		}		
		return nombreEstacion;
	}
	
	public String conversorMagnitud(String codigo, ArrayList<HashMap<String, String>> datosMagnitudes) {
		String nombreMagnitud = "";		
		for (HashMap<String, String> datos : datosMagnitudes) {			
			if (datos.get("codMagnitud").equals(codigo)){		
				if (nombreMagnitud.equals("1")) {
					System.out.println("Equivale a uno");
				}
				nombreMagnitud = datos.get("nombreMagnitud");					
				return nombreMagnitud;
			}			
		}		
		return nombreMagnitud;
	}
	
}
