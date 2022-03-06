package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Direccion;
import beans.Equipo;
import beans.Estadio;


public class EstadioToXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Estadio.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();
			return;// Dejamos de ejecutar el metodo main
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Estadio estadio = new Estadio();

			

			estadio.setComunidad_Autonoma("Madrid");

			estadio.getEquipos().add(new Equipo(1, "Real Madrid", 36));

			estadio.getEquipos().add(new Equipo(2, "Alcorcon", 33));

			estadio.getEquipos().add(new Equipo(3, "Atletico de Madrid", 30));

			estadio.getEquipos().add(new Equipo(4, "Leganes", 25));

			estadio.getEquipos().add(new Equipo(5, "Getafe FC", 23));

			Direccion direccion_RM = new Direccion();
			direccion_RM.setNombreVia("Avenida Concha Espina, Madrid");
			direccion_RM.setNumero(1);
			direccion_RM.setCp( 28036);

			
			
			Direccion direccion_Alco = new Direccion();
			direccion_Alco.setNombreVia("Avda.Asturias , Alcorcon");
			direccion_Alco.setNumero(6);
			direccion_Alco.setCp( 28900);
			
			
			Direccion direccion_ATL = new Direccion();
			direccion_ATL.setNombreVia("AVDA.Montaña , Madrid");
			direccion_ATL.setNumero(3);
			direccion_ATL.setCp( 28666);
			
			
			Direccion direccion_LEG = new Direccion();
			direccion_LEG.setNombreVia("Calle Europa , Leganes");
			direccion_LEG.setNumero(1);
			direccion_LEG.setCp( 28911);
			
			Direccion direccion_GET = new Direccion();
			direccion_GET.setNombreVia("Calle Sepulveda , Getafe");
			direccion_GET.setNumero(12);
			direccion_GET.setCp( 28678);
			
			
			
			
			
			estadio.getEquipos().get(0).setDireccion(direccion_RM);
			estadio.getEquipos().get(1).setDireccion(direccion_Alco);
			estadio.getEquipos().get(2).setDireccion(direccion_ATL);
			estadio.getEquipos().get(3).setDireccion(direccion_LEG);
			estadio.getEquipos().get(4).setDireccion(direccion_GET);

			m.marshal(estadio, new File("Partidos.xml"));
			System.out.println("El archivo Partidos.xml ha sido creado con exito," + " refresque su eclipse :)");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
	}
}
