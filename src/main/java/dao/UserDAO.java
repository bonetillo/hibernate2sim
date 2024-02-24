/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import models.Book;
import models.User;
import java.util.List;

public interface UserDAO {
    void createUser(User user);
    List<User> getUser();
    void updateUser(User user);
    void deleteUser(User user);

}
