package com.ebac.modulo60;

import com.ebac.modulo60.dto.autor.Autor;
import com.ebac.modulo60.dto.libro.GeneradorLibros;
import com.ebac.modulo60.dto.libro.Libro;
import com.ebac.modulo60.dto.usuario.Usuario;
import com.ebac.modulo60.model.AutorModel;
import com.ebac.modulo60.model.LibroModel;
import com.ebac.modulo60.model.UsuarioModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static com.ebac.modulo60.dto.libro.Categoria.*;

public class Contexto {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("connectionLocalMySQL");
        entityManager = entityManagerFactory.createEntityManager();

        operacionesUsuario();
        //operacionesAutor();
        //operacionesLibro();

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void operacionesUsuario() {
        System.out.println("----OPERACIONES CON USUARIO----");
        UsuarioModel usuarioModel = new UsuarioModel(entityManager);

        //Creación
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Vianney");
        usuario1.setCorreo("vianney@correo.com");
        usuario1.setEdad(26);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Faridee");
        usuario2.setCorreo("faridee@correo.com");
        usuario2.setEdad(30);

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Jose");
        usuario3.setCorreo("jose@correo.com");
        usuario3.setEdad(18);

        //Guardar
        usuarioModel.save(usuario1);
        usuarioModel.save(usuario2);
        usuarioModel.save(usuario3);
        System.out.println( "Guardado: " + usuario1 );
        System.out.println( "Guardado: " + usuario2 );
        System.out.println( "Guardado: " + usuario3 );
        System.out.println("----------");

        //Obtener
        Usuario usuarioDB = usuarioModel.getById(1);
        System.out.println( "Obtenido: " + usuarioDB );
        System.out.println("----------");

        //Actualizar
        usuario1.setNombre("Gio");
        usuario1.setCorreo("gio@correo.com");
        usuario1.setEdad(40);

        usuarioModel.update(usuario1);
        System.out.println( "Actualizado: " + usuario1 );

        Usuario usuarioDB2 = usuarioModel.getById(1);
        System.out.println( "Obtenido: " + usuarioDB2 );
        System.out.println("----------");

        //Eliminar
        usuarioModel.delete(usuario3);

        Usuario usuarioD = usuarioModel.getById(3);
        System.out.println( "No encontrado: " + usuarioD );
        System.out.println("----------");

        //Mapeo
        System.out.println("MAPEO");
        usuarioModel.getAll()
                .forEach(System.out::println);
    }

    private static void operacionesAutor() throws Exception {
        System.out.println("----OPERACIONES CON AUTOR----");
        AutorModel autorModel = new AutorModel(entityManager);

        //Creación
        Autor autor1 = new Autor.AutorBuilder("Blad")
                .setApellido("Landa")
                .setLibros(10)
                .build();

        Autor autor2 = new Autor.AutorBuilder("Manu")
                .setApellido("Carrillo")
                .setLibros(5)
                .build();

        Autor autor3 = new Autor.AutorBuilder("Edher")
                .setApellido("Alcazar")
                .setLibros(2)
                .build();

        //Guardar
        autorModel.save(autor1);
        autorModel.save(autor2);
        autorModel.save(autor3);
        System.out.println( "Guardado: " + autor1 );
        System.out.println( "Guardado: " + autor2 );
        System.out.println( "Guardado: " + autor3 );
        System.out.println("----------");

        //Obtener
        Autor autorDB = autorModel.getById(1);
        System.out.println( "Obtenido: " + autorDB);
        System.out.println("----------");

        //Actualizar
        autor1.setNombre("Carlos");
        autor1.setApellido("Landa");
        autor1.setLibros(15);

        autorModel.update(autor1);
        System.out.println( "Actualizado: " + autor1 );

        Autor autorDB2 = autorModel.getById(1);
        System.out.println( "Obtenido: " + autorDB2 );
        System.out.println("----------");

        //Eliminar
        autorModel.delete(autor3);

        Autor autorD = autorModel.getById(3);
        System.out.println( "No encontrado: " + autorD );
        System.out.println("----------");

        //Mapeo
        System.out.println("MAPEO");
        autorModel.getAll()
                .forEach(System.out::println);
    }

    private static void operacionesLibro() throws Exception {
        System.out.println("----OPERACIONES CON LIBRO----");
        LibroModel libroModel = new LibroModel(entityManager);

        //Creación
        GeneradorLibros generadorLibros = new GeneradorLibros();

        Libro libro1 = generadorLibros.generarLibro(ROMANCE);
        libro1.setTitulo("Amor a Gatas");
        libro1.setAutor("Jose");
        libro1.setPublicacion(2002);
        libro1.setIsbn("0044c");

        Libro libro2 = generadorLibros.generarLibro(TERROR);
        libro2.setTitulo("Terro Bajo la Lluvia");
        libro2.setAutor("Josefina");
        libro2.setPublicacion(2012);
        libro2.setIsbn("0055c");

        Libro libro3 = generadorLibros.generarLibro(AVENTURA);
        libro3.setTitulo("Aventura Nautica");
        libro3.setAutor("Bladimir");
        libro3.setPublicacion(1998);
        libro3.setIsbn("0066c");

        //Guardar
        libroModel.save(libro1);
        libroModel.save(libro2);
        libroModel.save(libro3);
        System.out.println( "Guardado: " + libro1 );
        System.out.println( "Guardado: " + libro2 );
        System.out.println( "Guardado: " + libro3 );
        System.out.println("------");

        //Obtener
        Libro libroDB = libroModel.getById(1);
        System.out.println( "Obtenido: " + libroDB);
        System.out.println("----------");

        //Actualizar
        libro1.setTitulo("Amor en el Monte");
        libro1.setIsbn("0055c");

        libroModel.update(libro1);
        System.out.println( "Actualizado: " + libro1 );

        Libro libroDB2 = libroModel.getById(1);
        System.out.println( "Obtenido: " + libroDB2 );
        System.out.println("----------");

        //Eliminar
        libroModel.delete(libro3);

        Libro libroD = libroModel.getById(3);
        System.out.println( "No encontrado: " + libroD );
        System.out.println("----------");

        //Mapeo
        System.out.println("MAPEO");
        libroModel.getAll()
                .forEach(System.out::println);

    }

}
