package com.tiw8205.admin8205.mysql.entities;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@XmlRootElement
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String ap1;
    private String ap2;
    private String username;
    private String pass;
    private String dir;
    private int tlf;
    private boolean administrador;

    public Usuario() {

    }

    @PersistenceConstructor
    public Usuario(String nombre, String ap1, String ap2, String username, String pass, String dir, int tlf,
                   boolean administrador) {

        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.username = username;
        this.pass = pass;
        this.dir = dir;
        this.tlf = tlf;
        this.administrador = administrador;
    }

    public Usuario(int id, String nombre, String ap1, String ap2, String username, String pass, String dir, int tlf,
                   boolean administrador) {
        this.id = id;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.username = username;
        this.pass = pass;
        this.dir = dir;
        this.tlf = tlf;
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
