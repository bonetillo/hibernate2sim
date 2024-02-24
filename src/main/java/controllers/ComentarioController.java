package controllers;

import dao.BookDAOImpl;
import dao.ComentarioDAO;
import dao.ComentarioDAOImpl;
import models.Book;
import models.Comentario;
import models.User;

public class ComentarioController {
    private final dao.ComentarioDAO comentarioDAO;
    public ComentarioController() {
        this.comentarioDAO = new ComentarioDAOImpl();
    }
    public void usuarioCreaUnComentario(String comentario, User user, Book book) {
        Comentario c= new Comentario();
        c.setComentario(comentario);
        c.setLibroComentado(book);
        c.setUser(user);
        comentarioDAO.createComentario(c);

    }
    public void usuarioCreaUnaValoracion(int valoracion, User user, Book book) {
        Comentario c= new Comentario();
        if (valoracion<=5 && valoracion>=0){
            c.setValoracion(valoracion);
            c.setLibroComentado(book);
            c.setUser(user);
            comentarioDAO.createComentario(c);
        }else{
            System.out.println("valoracion ha de ser entre 1 y 5");
        }
    }
    public void usuarioCreaUnComentarioYValoracion(String comentario,int valoracion, User user, Book book) {
        Comentario c= new Comentario();
        if (valoracion<=5 && valoracion>=0){
            c.setValoracion(valoracion);
            c.setComentario(comentario);
            c.setLibroComentado(book);
            c.setUser(user);
            comentarioDAO.createComentario(c);
        }else{
            System.out.println("valoracion ha de ser entre 1 y 5");
        }
    }

}
