import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		Node raiz;

		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("concierto.xml");
			raiz = doc.getDocumentElement();
			fechaHora(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// este metodo es para extraer del xml la fecha y hora de los conciertos

	private static void fechaHora(Node raiz) {
		NodeList nodos = raiz.getChildNodes();

		// Iteración por los elementos concierto.
		for (int i = 4; i < nodos.getLength(); i++) {

			Node nodoHijo = nodos.item(i);
			if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {

				Node fecha = raiz.getChildNodes().item(1);
				Node hora = raiz.getChildNodes().item(3);
				System.out
						.println("Fecha y hora del concierto: " + fecha.getTextContent() + " " + hora.getTextContent());
				Node participantes = raiz.getChildNodes().item(5);
				recorrerNodos(participantes);
			}
		}
	}

	private static void recorrerNodos(Node participantes) {
		NodeList nodos = participantes.getChildNodes();
		System.out.println("Participan los siguientes grupos: ");
		for (int i = 0; i < nodos.getLength(); i++) {
			Node participante = nodos.item(i);
			if (participante.getNodeType() == Node.ELEMENT_NODE) {

				Node entrada = participante.getChildNodes().item(1);
				Node grupo = participante.getChildNodes().item(3);

				System.out.print("   " + entrada.getTextContent() + " " + grupo.getTextContent() + "\n");
				
			}
		}

	}
}