/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public class OrderDaoStubImpl implements OrderDao {
    Order fakeOrder = new Order();
    Order fakeOrder2 = new Order();
    List <Order> orderList = new ArrayList<>();
    
    public OrderDaoStubImpl(){
        fakeOrder.setArea(new BigDecimal("100"));
        fakeOrder.setState("KS");
        fakeOrder.setCostPerFoot(BigDecimal.ONE);
        fakeOrder.setCustomerName("Customer1");
        fakeOrder.setLaborPerFoot(BigDecimal.ONE);
        fakeOrder.setLaborCost(new BigDecimal("100"));
        fakeOrder.setMaterialCost(new BigDecimal("100"));
        fakeOrder.setOrderNumber(1);
        fakeOrder.setProduct("fake wood");
        fakeOrder.setTaxRate(BigDecimal.ZERO);
        fakeOrder.setTaxRate(BigDecimal.ZERO);
        fakeOrder.setTotal(new BigDecimal("200"));
        
        fakeOrder2.setArea(new BigDecimal("100"));
        fakeOrder2.setState("MO");
        fakeOrder2.setCostPerFoot(BigDecimal.ONE);
        fakeOrder2.setCustomerName("Customer2");
        fakeOrder2.setLaborPerFoot(BigDecimal.ONE);
        fakeOrder2.setLaborCost(new BigDecimal("200"));
        fakeOrder2.setMaterialCost(new BigDecimal("200"));
        fakeOrder2.setOrderNumber(2);
        fakeOrder2.setProduct("plastic");
        fakeOrder2.setTaxRate(BigDecimal.ZERO);
        fakeOrder2.setTaxRate(BigDecimal.ZERO);
        fakeOrder2.setTotal(new BigDecimal("400"));
    }

    @Override
    public List<Order> listOrders(LocalDate date) throws DaoFileException {
        orderList.add(fakeOrder);
        orderList.add(fakeOrder2);
        return orderList;
    }

    @Override
    public List<Order> addToList(Order newOrder, LocalDate date) throws DaoFileException {
        orderList.add(newOrder);
        return orderList;
    }

    @Override
    public List<Order> removeOrder(Order removeOrder, LocalDate date) throws DaoFileException {
        orderList.remove(removeOrder);
        return orderList;
    }

    @Override
    public Order findOrder(LocalDate date, int orderNumber) throws DaoFileException {
        Order newOrder = orderList.get(orderNumber);
        return newOrder;
    }

    @Override
    public void saveData() throws DaoFileException {
        // do nothing
    }
    
}
