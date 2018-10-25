/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author j1bdw02
 */
public class ProductDaoStubImpl implements ProductDao {
    Product fakeProduct = new Product();
    Product fakeProduct2 = new Product();
    Map <String, Product> productMap = new HashMap<>();
    
    public ProductDaoStubImpl(){
        fakeProduct.setLaborCostPerFoot(BigDecimal.ONE);
        fakeProduct.setMaterialCostPerFoot(BigDecimal.ONE);
        fakeProduct.setProduct("test1");
        
        fakeProduct2.setLaborCostPerFoot(BigDecimal.TEN);
        fakeProduct2.setMaterialCostPerFoot(BigDecimal.TEN);
        fakeProduct2.setProduct("test2");
        
        productMap.put(fakeProduct.getProduct(), fakeProduct);
        productMap.put(fakeProduct2.getProduct(), fakeProduct2);
    }

    @Override
    public Product getProductRates(String product) throws DaoFileException {
        return productMap.get(product);
    }

    @Override
    public List<Product> listProducts() throws DaoFileException {
       return new ArrayList<>(productMap.values());
    }

    @Override
    public void addProduct(String key, Product product) {
        productMap.put(key, product);
    }
}
