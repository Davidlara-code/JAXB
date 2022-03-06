package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Estas anotaciones sirven para que JAXB que es el motor de java para
//convertir objetos a XML y a la inversa, sepa como hacerlo
//serializar y deserializar

//esta etiqueta estamos estableciendo el nombre de el nodo raiz en xml
//etiqueta obligatoria
// sin esta etiqueta no podemos hacer un xml to object
@XmlRootElement(name = "equipo")
//Podemos hacer que las etiquetas salgan en un determinado orden
//etiqueta opcional
@XmlType(propOrder = { "clasificacion", "nombre", "puntos", "direccion" })

public class Equipo {

	private int clasificacion;
	private String nombre;
	private int puntos;
	private Direccion direccion;

	// JAXB necesita para funcionar del constructor por defecto de java
	public Equipo() {

	}

	public Equipo(int clasificacion, String nombre, int puntos) {
		super();
		this.clasificacion = clasificacion;
		this.nombre = nombre;

		this.puntos = puntos;
	}

	// etiqueta que hace que el id de la persona se serialize como atributo de
	// persona
	// etiqueta opcional
	@XmlAttribute(name = "clasificacion")
	public int getClasificacion() {
		return clasificacion;
	}

	

	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}

	// etiqueta opcional
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Equipo [clasificacion=" + clasificacion + ", nombre=" + nombre + ", puntos=" + puntos + ", direccion="
				+ direccion + "]";
	}

	
	
	
	
}
