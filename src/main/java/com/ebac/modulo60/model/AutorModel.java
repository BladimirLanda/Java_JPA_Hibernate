package com.ebac.modulo60.model;

import com.ebac.modulo60.dto.autor.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AutorModel {

    private final EntityManager entityManager;

    public AutorModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Guardar
    public void save(Autor autor) {
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(autor);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Actualizar
    public void update(Autor autor) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(autor);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Eliminar
    public void delete(Autor autor) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(autor);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Obtener Uno
    public Autor getById(int id) {
        return entityManager.find(Autor.class, id);
    }

    //Obtener Todos
    public List<Autor> getAll() {
        String query = "SELECT * FROM autores";

        return entityManager.createNativeQuery(query, Autor.class)
                .getResultList();
    }

}
