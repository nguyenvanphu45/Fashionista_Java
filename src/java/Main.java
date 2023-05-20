
import dao.ProductDao;
import dao.UserDao;
import java.util.List;
import model.Product;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println("" + userDao.getUsers());
        
        ProductDao proDao = new ProductDao();
        System.out.println("" + proDao.getProducts());
        
        // add User, Product
//        proDao.addProduct(new Product(
//            "PD006", "Pants", "20000", "Pants wide", "CG001"
//        ));
//        System.out.println("" + userDao.getUsers());

        // Update User
//        List<Product> myList = proDao.getProducts();
//        for (User user : myList) {
//            System.out.println("" + user.toString());
//        }
//          
//        userDao.updateUser(new User(
//                "Ad006", "Bình", "123123", "BinhLe@gmail.com", "Bình Lê", 
//                "HCM", "0990112243"
//        ));
//        myList = userDao.getUsers();
//        System.out.println("==========");
//        for (User user : myList) {
//            System.out.println("" + user.toString());
//        }
          
        // Delete User
//        proDao.deleteProduct("Ad006");
//        myList = userDao.getUsers();
//        System.out.println("==========");
//        for (User user : myList) {
//            System.out.println("" + user.toString());
//        }
    }
}
