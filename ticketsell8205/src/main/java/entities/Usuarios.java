package entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ap1")
	private String ap1;

	@Column(name = "ap2")
	private String ap2;
	
	


	@Column(name = "pass")
	private String pass;
	
	@Column(name = "dir")
	private String dir;
	
	@Column(name = "tlf")
	private int tlf;
	
	@Column(name = "administrador")
	private boolean administrador;
	
	
	public Usuarios() {
		
	}
	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAp1() {
		return ap1;
	}


	public void setAp1(String ap1) {
		this.ap1 = ap1;
	}


	public String getAp2() {
		return ap2;
	}


	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getDir() {
		return dir;
	}


	public void setDir(String dir) {
		this.dir = dir;
	}


	public int getTlf() {
		return tlf;
	}


	public void setTlf(int tlf) {
		this.tlf = tlf;
	}


	public boolean isAdministrador() {
		return administrador;
	}


	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	
	
	
}