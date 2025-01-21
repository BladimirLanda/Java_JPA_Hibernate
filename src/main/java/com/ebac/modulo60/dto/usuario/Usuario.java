package com.ebac.modulo60.dto.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "edad")
    private int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "usuario_id=" + usuario_id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }

    //Testing
    public int getUsuario_id() {
        return usuario_id;
    }

    public String getNombre() {
        return nombre;
    }
}
