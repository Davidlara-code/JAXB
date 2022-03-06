import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class Principal {

	public static void main(String[] args) {
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos nuevo documento vacio
			doc = analizador.newDocument();
			// Añadimos elemento raiz
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			
			agregarConciertos(concierto, doc);
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);
			
			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void agregarConciertos(Element concierto, Document doc) {
		
	
				
		
		
		Element fecha = doc.createElement("fecha");
		
		fecha.appendChild(doc.createTextNode("20-oct-2018"));
		concierto.appendChild(fecha);
		
		
		Element hora = doc.createElement("hora");
		//lo hacemos de manera directa
		hora.appendChild(doc.createTextNode("21:30"));
		concierto.appendChild(hora);
		
		
		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);
		
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		Element entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("21:30"));
		participante.appendChild(entrada);
		
		
		Element grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		participante.appendChild(grupo);
		
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("22:15"));
		participante.appendChild(entrada);
		
		
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(grupo);
		
		
		
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("23:00"));
		participante.appendChild(entrada);
		
		
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Coldplay"));
		participante.appendChild(grupo);
		
		
				
	}
	
	private static void guardar(Document doc) throws TransformerException {
		//fabrica de Transformes
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		//creamos el objeto Transfomer, que nos permitira serializar el arbol
		//dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		//creamos la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc); 
		//Creamos el flujo de salida, al fichero que queremos (tubito)
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		//por ultimo, serializamos los datos
		conversor.transform(fuente, resultado);
	}
}