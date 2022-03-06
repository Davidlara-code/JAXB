package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


  @XmlRootElement(name = "Profesores")
  public class Profesor {
	private String Comunidad_Autonoma;
	private String nombre;
	private List<Alumno> alumnos;

	public Profesor() {
		alumnos = new ArrayList<Alumno>();
	}

	
	// sea "estudiante"
	@XmlElement(name = "estudiante")
	
	@XmlElementWrapper(name = "estudiantes")
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getComunidad_Autonoma() {
		return Comunidad_Autonoma;
	}

	public void setComunidad_Autonoma(String comunidad_Autonoma) {
		Comunidad_Autonoma = comunidad_Autonoma;
	}

}
