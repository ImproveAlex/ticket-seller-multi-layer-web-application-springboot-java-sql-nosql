package entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.sql.Date;

@Entity(name="eventos")
@Table(name="eventos")
public class Eventos implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "fecha")
	private Date fecha;


	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "sala")
	private int sala;
	
	@Column(name = "imagen")
	private String imagen;
	
	
	public Eventos() {
		
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public int getSala() {
		return sala;
	}


	public void setSala(int sala) {
		this.sala = sala;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
	
	
	
}