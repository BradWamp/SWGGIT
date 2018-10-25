/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import DTO.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author j1bdw02
 */
public class ProductDaoFileImpl implements ProductDao {
    public static final String DELIMITER = ",";
    public static final String PRODUCTFILE = "Products.txt";
    private HashMap <String, Product> productMap = new HashMap<>();
    
    public ProductDaoFileImpl()throws Exception{
        loadProducts();
    }
    
    @Override
    public Product getProductRates(String product) throws DaoFileException{
        //loadProducts();
        Product newProduct = productMap.get(product);
        return newProduct;
    }
    @Override
    public List<Product> listProducts() throws DaoFileException {
        //loadProducts();
        return new ArrayList<Product>(productMap.values());
    }
    
    @Override
    public void addProduct(String key, Product product){
        productMap.put(key, product);
    }
    
    private void loadProducts() throws DaoFileException{
        Scanner scanner;
	String currentLine;
        String[] currentTokens;
	try {
	    scanner = new Scanner(new BufferedReader(new FileReader(PRODUCTFILE)));
	} catch (FileNotFoundException e) {
	    throw new DaoFileException("Product File load failed.", e);
	}
        
        while (scanner.hasNextLine()) {
	    currentLine = scanner.nextLine();
	    currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product();
	    
            currentProduct.setProduct(currentTokens[0]);
            currentProduct.setMaterialCostPerFoot(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCostPerFoot(new BigDecimal(currentTokens[2]));
                       
	    productMap.put(currentProduct.getProduct(), currentProduct);
        }
	    scanner.close();
        } 
}
