/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.BookDAO;
import dao.BookDAOImpl;
import models.Book;
import models.User;

import java.util.List;

public class BookController {

    private final BookDAO BookDAO;

    public BookController() {
        this.BookDAO = new BookDAOImpl();

    }

    public Book createBook(String titulo, int numeroPaginas, User userEscritor, User userLector) {
        Book book = new Book(titulo, numeroPaginas);
        book.setUserLector(userLector);
        book.setUserEscritor(userEscritor);
        BookDAO.createBook(book);
        return book;

    }

    public void listLibros() {
        System.out.println("La lista de los libros disponibles es: ");
        List<Book> listarLibros = BookDAO.listarLibros();
        for (Book book : listarLibros) {
            System.out.println(book.getTitulo());
        }

    }

    public void listLibrosLeidosDeUser(User user) {
        List<Book> listLibrosLeidosDeUser = BookDAO.getLibrosLeidos(user);
        System.out.println("Los libros leidos por el usuario" + user.getUserName() + "son: ");
        for (Book book : listLibrosLeidosDeUser) {
            System.out.println(book.getTitulo());

        }
    }

    public Book añadirLector(Book book, User userLector) {
        book.setUserLector(userLector);
        BookDAO.updateBook(book);
        return book;
    }

    public Book añadirEscritor(Book book, User userEscritor) {
        book.setUserEscritor(userEscritor);
        BookDAO.updateBook(book);
        return book;
    }

}
