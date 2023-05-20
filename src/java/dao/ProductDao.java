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
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDao implements ProductInterface{

    @Override
    public List<Product> getProducts() {
        // Khai bao list de do result vao
        List<Product> sl = new ArrayList<>();
        // Tao ket noi CSDL
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            // Hien thi sap xep id theo thu tu
            String sql = "Select * from Products order by id";
            // excute cau lenh sql
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1).trim();
                // Trim de remove khoang space
                String name = rs.getString(2).trim();
                String price = rs.getString(3).trim();
                String description = rs.getString(4).trim();
                String image = rs.getString(5).trim();
                Product pro = new Product(
                    id, name, price, description, image
                );
                sl.add(pro);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sl;
    }

    @Override
    public void addProduct(Product pro) {
        String sql = "INSERT INTO Products(id, name, price, description, image)\n" 
                + "VALUES (?, ?, ?, ?, ?)";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, pro.getId());
            statement.setString(2, pro.getName());
            statement.setString(3, pro.getPrice());
            statement.setString(4, pro.getDescription());
            statement.setString(5, pro.getImage());
            
            // khi insert se dung execute
            statement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateProduct(Product pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Product id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Product getProductById(String id) {
        Product pro = null;
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * from Products where id=?";
            // excute cau lenh sql
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                pro = new Product();
                pro.setId(rs.getString("id"));
                pro.setName(rs.getString("name"));
                pro.setPrice(rs.getString("price"));
                pro.setDescription(rs.getString("descrition"));
                pro.setImage(rs.getString("image"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return pro;
    }
}
