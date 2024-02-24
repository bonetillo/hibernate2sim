/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import models.Book;
import models.User;

import java.util.List;

public interface BookDAO {
    void createBook(Book book);
    void updateBook(Book book);
    List<Book> listarLibros();

    List<Book>  getLibrosLeidos(User user);
    
    
    
    
}
