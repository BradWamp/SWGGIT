/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import DTO.Product;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public interface ProductDao {
    public Product getProductRates(String product) throws DaoFileException;
    public List<Product> listProducts() throws DaoFileException;
    public void addProduct(String key, Product product);
}
