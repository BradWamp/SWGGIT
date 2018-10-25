/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DaoFileException;
import DTO.Order;
import DTO.Product;
import DTO.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public interface OrderService {
    public List<Order> listOrdersService(LocalDate date) throws Exception;
    public Order calculateTotals(Order newOrder, Tax newTax, Product newProduct);
    public Order generateOrderNumber(Order newOrder);
    public Order findOrderEdit(Integer orderNumber, LocalDate date)throws Exception;
    //public Order compileOrderEdit (String name, String state, String product, BigDecimal area, Order newOrder);
    public void submitOrder (LocalDate date,String confirm, Order newOrder, String action)throws DaoFileException;
    public void removeOrderService (String confirm, Order removeOrder, LocalDate date) throws DaoFileException;
    public void saveDataService()throws DaoFileException;
    public String switchMode(int selection);
    
}
