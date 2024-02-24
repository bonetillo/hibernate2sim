
package controllers;

import dao.UserDAO;
import dao.UserDAOImpl;
import models.Book;
import models.User;

import java.util.Calendar;
import java.util.List;

public class UserController {
    private final UserDAO userDAO;
    public UserController() {
        this.userDAO = new UserDAOImpl();
    }
    public void createUser(User user) {
        userDAO.createUser(user);
    }
    public void updateUserConLibrosEscritos(User user, List<Book> LibrosEscritos) {
        user.setLibrosLeidos(LibrosEscritos);

        userDAO.updateUser(user);
    }
    public void updateUserConLibrosLeidos(User user, List<Book> librosLeidos) {
        user.setLibrosLeidos(librosLeidos);
        System.out.println("insertando los libros en "+user.getUserName());
        for (Book book : librosLeidos) {
            System.out.println(book.getTitulo());
        }

        userDAO.updateUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);

    }
    public boolean login(String userName, String contrasena) {
        List<User> listaUsers = userDAO.getUser();

        for (User user : listaUsers) {
            if (user.getUserName().equals(userName) && user.getContrasena().equals(contrasena)) {
                user.setTiempolog(Calendar.getInstance());
                updateUser(user);
                return true;
            }
        }
        return false;
    }
}
