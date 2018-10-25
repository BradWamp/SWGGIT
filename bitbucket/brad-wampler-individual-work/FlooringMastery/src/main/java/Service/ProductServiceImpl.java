/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DaoFileException;
import DAO.ProductDao;
import DTO.Order;
import DTO.Product;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public class ProductServiceImpl implements ProductService {
    ProductDao productDao;
    
    public ProductServiceImpl (ProductDao productDao) {
        this.productDao = productDao;
    }
    
    @Override
    public Product getProductRatesService(String product)throws DaoFileException{
        Product serviceProduct = productDao.getProductRates(product);
        return serviceProduct;
    }
    @Override
    public List<Product> listProducts() throws DaoFileException {
        return productDao.listProducts();
    }
}
