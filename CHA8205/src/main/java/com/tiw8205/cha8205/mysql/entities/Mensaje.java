package com.tiw8205.cha8205.mysql.entities;

import org.springframework.data.annotation.PersistenceConstructor;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name="mensajes")
@XmlRootElement
public class Mensaje {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String emisor;
    private String receptor;
    private String mensaje;

    public Mensaje() {

    }

    public Mensaje(String emisor, String receptor, String mensaje) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
    }

    @PersistenceConstructor
    public Mensaje(int id, String emisor, String receptor, String mensaje) {
        this.id = id;
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
