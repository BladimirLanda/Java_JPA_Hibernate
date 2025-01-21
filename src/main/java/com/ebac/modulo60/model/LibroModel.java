package com.ebac.modulo60.model;

import com.ebac.modulo60.dto.libro.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LibroModel {

    private final EntityManager entityManager;

    public LibroModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Guardar
    public void save(Libro libro) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(libro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Actualizar
    public void update(Libro libro) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(libro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Eliminar
    public void delete(Libro libro) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(libro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Obtener Uno
    public Libro getById(int id) {
        return entityManager.find(Libro.class, id);
    }

    //Obtener Todos
    public List<Libro> getAll() {
        String query = "SELECT * FROM libros";

        return entityManager.createNativeQuery(query, Libro.class)
                .getResultList();
    }

}
