package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



	@XmlRootElement(name = "Estadios")
	public class Estadio {
		//private String nombre;
		private String Comunidad_Autonoma;
		private List<Equipo> equipos;

		public Estadio() {
			equipos = new ArrayList<Equipo>();
		}

		// Establezco que cada elemento del array se serialice a una etiqueta xml cuyo
		// nombre
		// sea "persona"
		@XmlElement(name = "Equipo")
		// Podemos crear una etiqueta que envuelva las etiquetas persona, si no la
		// ponemos saldran
		// las etiquetas "persona" al mismo nivel que la familia, de esta manera
		// agrupamos todos
		// los "miembro" en la etiqueta "miembros"
		@XmlElementWrapper(name = "Equipos")
		public List<Equipo> getEquipos() {
			return equipos;
		}

		public void setEquipos(List<Equipo> equipos) {
			this.equipos = equipos;
		}

	

		public String getComunidad_Autonoma() {
			return Comunidad_Autonoma;
		}

		public void setComunidad_Autonoma(String comunidad_Autonoma) {
			Comunidad_Autonoma = comunidad_Autonoma;
		}

	

	}

