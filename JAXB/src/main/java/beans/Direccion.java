package beans;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder = { "nombreVia", "numero", "cp" })
//si solo ponemos esta anotacion, el root element sera el nombre de la clase
@XmlRootElement
public class Direccion {
	private int numero;
	private String nombreVia;
	private int cp;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	@Override
	public String toString() {
		return "Direccion [numero=" + numero + ", nombreVia=" + nombreVia + ", cp=" + cp + "]";
	}
	
	
}
