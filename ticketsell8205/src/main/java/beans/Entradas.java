package beans;

import java.io.Serializable;
import java.util.Objects;

public class Entradas implements Serializable {
	

	private int id;
	
	private String evento;
	
	private String tipo;
	
	private int precio;
	
	private String propietario;
	
	private boolean disponible;
	
	
	public Entradas(int id, String evento) {
		this.id = id;
		this.evento = evento;
		
	}
	
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Entradas aux = (Entradas) o;
//        return id == aux.id &&
//                evento.equals(aux.evento);
//    }
//	
//	
//	@Override
//    public int hashCode() {
//        return Objects.hash(id, evento);
//    }
	
	public Entradas() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
	
	
	
}