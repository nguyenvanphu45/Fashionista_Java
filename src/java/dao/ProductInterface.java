/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Product;

/**
 *
 * @author Admin
 */
public interface ProductInterface {
    List<Product> getProducts();
    void addProduct(Product pro);
    void updateProduct(Product pro);
    void deleteProduct(Product id);
}
