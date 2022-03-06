package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Alumno;
import beans.Direccion;

import beans.Profesor;

public class ProfesorToXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Profesor.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;//Dejamos de ejecutar el metodo main
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Profesor profe = new Profesor();
			
			profe.setComunidad_Autonoma("Madrid");
			
			profe.setNombre("Felix");
			
			
			profe.getAlumnos().add(new Alumno(1, "Adrian", "MCith", 32));
			profe.getAlumnos().add(new Alumno(2, "David	", "Lara", 37));
			profe.getAlumnos().add(new Alumno(3, "Javier", "Sombrilla", 29));
			profe.getAlumnos().add(new Alumno(4, "Alejandro", "Hermosilla", 35));
			profe.getAlumnos().add(new Alumno(5, "Raquel", "Spencer", 28));
			
			Direccion direccion1 = new Direccion();
			direccion1.setNombreVia("Avenida Concha Espina, Madrid");
			direccion1.setNumero(1);
			direccion1.setCp( 28036);

			
			
			Direccion direccion2 = new Direccion();
			direccion2.setNombreVia("Avda.Asturias , Alcorcon");
			direccion2.setNumero(6);
			direccion2.setCp( 28900);
			
			
			Direccion direccion3 = new Direccion();
			direccion3.setNombreVia("AVDA.Montaña , Madrid");
			direccion3.setNumero(3);
			direccion3.setCp( 28666);
			
			
			Direccion direccion4 = new Direccion();
			direccion4.setNombreVia("Calle Europa , Leganes");
			direccion4.setNumero(1);
			direccion4.setCp( 28911);
			
			Direccion direccion5 = new Direccion();
			direccion5.setNombreVia("Calle Sepulveda , Getafe");
			direccion5.setNumero(12);
			direccion5.setCp( 28678);
			
			profe.getAlumnos().get(0).setDireccion(direccion1);
			profe.getAlumnos().get(1).setDireccion(direccion2);
			profe.getAlumnos().get(2).setDireccion(direccion3);
			profe.getAlumnos().get(3).setDireccion(direccion4);
			profe.getAlumnos().get(4).setDireccion(direccion5);

			m.marshal(profe, new File("Profesor.xml"));
			System.out.println("El archivo Profesor.xml ha sido creado con exito,"
					+ " refresque su eclipse :)");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
	}
}
