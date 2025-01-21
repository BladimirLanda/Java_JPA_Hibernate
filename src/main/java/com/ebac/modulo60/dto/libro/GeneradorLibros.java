package com.ebac.modulo60.dto.libro;

//--Clase: Patrón de Diseño FactoryMethod--//
public class GeneradorLibros {

    public Libro generarLibro(Categoria categoria) throws Exception {
        Libro libro;

        switch (categoria) {
            case AVENTURA -> libro = new Libro("AVENTURA");
            case ROMANCE -> libro = new Libro("ROMANCE");
            case TERROR -> libro = new Libro("TERROR");
            default -> throw new Exception("Categoria no encontrada");
        }

        return libro;
    }

}
