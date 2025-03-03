package com.ebac.modulo60;

import com.ebac.modulo60.dto.usuario.Usuario;
import com.ebac.modulo60.model.UsuarioModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.*;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class UsuarioModelTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private Usuario usuario;
    private UsuarioModel usuarioModel;

    @Before
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("connectionLocalMySQL");
        entityManager = entityManagerFactory.createEntityManager();
        usuarioModel = new UsuarioModel(entityManager);

        usuario = new Usuario();
        usuario.setNombre("Bladimir");
        usuario.setCorreo("blad@correo.com");
        usuario.setEdad(18);

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void getById() {
        usuarioModel.save(usuario);

        int expected = 1;
        int actual = usuarioModel.getById(1).getUsuario_id();

        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        usuario.setNombre("Juan Carlos");

        usuarioModel.update(usuario);

        String expected = "Juan Carlos";
        String actual = usuarioModel.getById(1).getNombre();

        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        usuarioModel.delete(usuario);

        Object expected = null;
        Object actual = usuarioModel.getById(1);

        assertEquals(expected, actual);
    }

}
