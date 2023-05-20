/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbcontext.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDao implements UserDaoInterface{
    
    @Override
    public List<User> getUsers() {
        // Khai bao list de do result vao
        List<User> sl = new ArrayList<>();
        // Tao ket noi CSDL
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            // Hien thi sap xep id theo thu tu
            String sql = "Select * from Users order by id";
            // excute cau lenh sql
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1).trim();
                // Trim de remove khoang space
                String userName = rs.getString(2).trim();
                String password = rs.getString(3).trim();
                String email = rs.getString(4).trim();
                String fullName = rs.getString(5).trim();
                String address = rs.getString(6).trim();
                String phoneNumber = rs.getString(7).trim();
                User user = new User(
                    id, userName, password, email, fullName, address, phoneNumber
                );
                sl.add(user);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sl;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO Users(id, userName, password, email, "
                + "fullName, address, phoneNumber)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getFullName());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getPhoneNumber());
            
            // khi insert se dung execute
            statement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE Users \n" + 
                "SET username=?, password=?, email=?, fullName=?, address=?, phoneNumber=? \n"
                + "WHERE id = ?;";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        
        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFullName());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getPhoneNumber());
            statement.setString(7, user.getId());
            statement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deleteUser(String id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            // set paramenter in the sql
            statement.setString(1, id);
            statement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public User userLogin(String email, String password) {
        User user = null;
        // Tao ket noi CSDL
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * from Users where email=? and password=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1).trim();
                String userName = rs.getString(2).trim();
                password = rs.getString(3).trim();
                email = rs.getString(4).trim();
                String fullName = rs.getString(5).trim();
                String address = rs.getString(6).trim();
                String phoneNumber = rs.getString(7).trim();
                user = new User(
                    id, userName, password, email, fullName, address, phoneNumber
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return user;
    }
}
