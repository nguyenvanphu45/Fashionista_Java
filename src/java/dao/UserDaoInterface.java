/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author Admin
 */
public interface UserDaoInterface {
    List<User> getUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
}
