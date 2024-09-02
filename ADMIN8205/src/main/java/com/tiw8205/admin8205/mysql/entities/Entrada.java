package com.tiw8205.admin8205.mysql.entities;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name="entradas")
@XmlRootElement


public class Entrada implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String evento;
    private String tipo;
    private int precio;
    private String propietario;
    private boolean disponible;


    public Entrada() {
    }

    @PersistenceConstructor
    public Entrada(String evento, String tipo, int precio, String propietario, boolean disponible) {
        this.evento = evento;
        this.tipo = tipo;
        this.precio = precio;
        this.propietario = propietario;
        this.disponible = disponible;

    }


    public Entrada(int id, String evento, String tipo, int precio, String propietario, boolean disponible) {
        this.id = id;
        this.evento = evento;
        this.tipo = tipo;
        this.precio = precio;
        this.propietario = propietario;
        this.disponible = disponible;

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