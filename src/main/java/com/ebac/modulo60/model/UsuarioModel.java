package com.ebac.modulo60.model;

import com.ebac.modulo60.dto.usuario.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UsuarioModel {

    private final EntityManager entityManager;

    public UsuarioModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Guardar
    public void save(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Actualizar
    public void update(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Eliminar
    public void delete(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //Obtener Uno
    public Usuario getById(int id) {
        return entityManager.find(Usuario.class, id);
    }

    //Obtener Todos
    public List<Usuario> getAll() {
        String query = "SELECT * FROM usuarios";

        return entityManager.createNativeQuery(query, Usuario.class)
                .getResultList();
    }

}
