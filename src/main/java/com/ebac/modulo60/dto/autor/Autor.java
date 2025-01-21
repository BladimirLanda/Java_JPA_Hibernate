package com.ebac.modulo60.dto.autor;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    //Configuración DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autor_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "libros")
    private int libros;

    //Lógica Creación
    public Autor(String nombre, String apellido, int libros) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.libros = libros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setLibros(int libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "autor_id=" + autor_id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", libros=" + libros +
                '}';
    }

    //--Clase Anidada: Patrón de Diseño Builder--//
    public static class AutorBuilder {

        private final String nombre;

        private String apellido = "Desconocido";
        private int libros;

        public AutorBuilder(String nombre) {
            this.nombre = nombre;
        }

        public AutorBuilder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public AutorBuilder setLibros(int libros) {
            this.libros = libros;
            return this;
        }

        public Autor build() throws Exception{
            validarLibros();
            return new Autor(this.nombre, this.apellido, this.libros);
        }

        private void validarLibros() throws Exception {
            if( this.libros <= 0 ) {
                throw new Exception("Error: El número de libros no puede ser 0");
            }
        }


    }

}

