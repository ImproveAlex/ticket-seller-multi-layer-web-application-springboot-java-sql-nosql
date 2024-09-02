package entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;





@Table(name="entradas")
@Entity(name="entradas")
//@IdClass(Entradas.class)


public class Entradas implements Serializable {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "evento")
	private String evento;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "precio")
	private int precio;
	
	@Column(name = "propietario")
	private String propietario;
	
	@Column(name = "disponible")
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
//	
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