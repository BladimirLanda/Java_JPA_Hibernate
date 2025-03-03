package com.ebac.modulo60.dto.libro;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "publicacion")
    private int publicacion;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "categoria")
    private final String categoria;

    public Libro(String categoria) {
        this.categoria = categoria;
    }

    //Getters
    public int getBook_id() {
        return book_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //toString
    @Override
    public String toString() {
        return "Libro{" +
                "book_id=" + book_id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", publicacion=" + publicacion +
                ", isbn='" + isbn + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
