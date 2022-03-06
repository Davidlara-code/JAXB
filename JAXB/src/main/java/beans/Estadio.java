package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



	@XmlRootElement(name = "Estadios")
	public class Estadio {
	
		private String Comunidad_Autonoma;
		private List<Equipo> equipos;

		public Estadio() {
			equipos = new ArrayList<Equipo>();
		}

		

		@XmlElement(name = "Equipo")
		
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

