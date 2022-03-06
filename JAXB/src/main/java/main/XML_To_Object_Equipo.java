package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import beans.Direccion;
import beans.Equipo;



public class XML_To_Object_Equipo {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			
			 contexto = JAXBContext.newInstance(Equipo.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		Marshaller m;
		try {
			/*
			 * Obtiene el objeto Marshaller asociado al contexto.
			 * Con dicho objeto podremos convertir un objeto en xml
			 * es decir, lo serializaremos
			 */
			m = contexto.createMarshaller();
			/*
			 * stablecer la propiedad JAXB_FORMATTED_OUTPUT con el valor true 
			 * permite que en la conversión a formato XML se incluyan retornos 
			 * de carro e indentación (sangrado del texto). 
			 * Prueba a ejecutar el programa con los valores true y 
			 * false para ver la diferencia.
			 */
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//creamos el Equipo y su direccion
			Equipo p = new Equipo(12, "Fuenlabrada", 10);
			Direccion direccion = new Direccion();
			direccion.setNombreVia("Gran Via");
			direccion.setNumero(3);
			direccion.setCp(28567);
			p.setDireccion(direccion);
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(p, System.out);
			//tambien podemos crear un fichero
			m.marshal(p, new File("Equipo.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			 contexto = JAXBContext.newInstance(Equipo.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("Equipo.xml");

			if (fichero.exists()) {
				Equipo p = (Equipo) u.unmarshal(fichero);

				
				System.out.println(p);
			} else {
				System.out.println("Fichero XML Equipo.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
}
