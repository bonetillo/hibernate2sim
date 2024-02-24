/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controllers.BookController;
import controllers.ComentarioController;
import controllers.UserController;
import models.Book;
import models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC GAMING
 */
public class Main {

    public static void main(String[] args) {
        UserController uc = new UserController();
        BookController bc = new BookController();
        ComentarioController cc= new ComentarioController();
        List<Book> listaLibrosLeidos=new ArrayList<>();
        List<Book> listaLibrosEscritos=new ArrayList<>();


        User a = new User("lorenzo", "lore", "1234", "lorMas@gmail.com", listaLibrosEscritos, new ArrayList<>());
        uc.createUser(a);


        User b = new User("roberto", "tomas", "12346", "tolorMas@gmail.com",  new ArrayList<>(),listaLibrosLeidos);
        uc.createUser(b);

        Book uno=bc.createBook("El señor de los anillos", 767,null,null);
        Book dos=bc.createBook("Las dos torres", 867,null,null);

        //porque si lo creo con una valoracion nula me pone un cero en la BBDD????
        cc.usuarioCreaUnComentario("samvalentin", a,uno);
        cc.usuarioCreaUnComentarioYValoracion("el mejor samvalentin",5, b,dos);



        listaLibrosLeidos.add(uno);
        listaLibrosLeidos.add(dos);
        listaLibrosEscritos.add(uno);

        //porque al hacer un update de los usuarios seteandoles las listas llenas de libros no te sale en la bbdd de libros
        uc.updateUserConLibrosEscritos(a,listaLibrosEscritos);
        uc.updateUserConLibrosLeidos(b,listaLibrosLeidos);

        //metodos para añadir libros a usuarios como escritores o lectores añadidos desde libros porque así si funciona wtf
        bc.añadirLector(uno,a);
        bc.añadirEscritor(dos,b);

        //Porque teniendo el mismo método en user userDAOImpl y en su controller no me funcionaba y ahora sí.
        bc.listLibrosLeidosDeUser(a);

        //listar todos los libros
        bc.listLibros();

        //Login correcto
        if (uc.login("lore", "1234") == true) {
            System.out.println("login correcto");
        } else {

            System.out.println("login incorrecto");
        }
        //Login incorrecto
        if (uc.login("loro", "1234") == true) {
            System.out.println("login correcto");
        } else {

            System.out.println("login incorrecto");
        }


    }
}
