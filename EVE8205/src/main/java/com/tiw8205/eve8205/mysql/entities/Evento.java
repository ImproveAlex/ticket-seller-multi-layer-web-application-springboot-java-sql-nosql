package com.tiw8205.eve8205.mysql.entities;

import org.springframework.data.annotation.PersistenceConstructor;
import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Random;
import java.sql.Date;


@Entity
@Table(name="eventos")
@XmlRootElement
public class Evento implements Serializable{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String categoria;
    private Date fecha;
    private String ciudad;

    private int sala;

    private String imagen;


    @PersistenceConstructor
    public Evento(String titulo, String categoria, Date fecha, String ciudad, int sala, String imagen) {
        this.titulo= titulo;
        this.categoria = categoria;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.sala = sala;
        this.imagen = imagen;

    }

    public Evento(int id, String titulo, String categoria, Date fecha, String ciudad, int sala, String imagen) {
        this.id=id;
        this.titulo= titulo;
        this.categoria = categoria;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.sala = sala;
        this.imagen = imagen;

    }

    public Evento(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
