/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author j1bdw02
 */
public interface OrderDao {
    public List<Order> listOrders(LocalDate date) throws DaoFileException;
    public List<Order> addToList (Order newOrder, LocalDate date)throws DaoFileException;
    public List<Order> removeOrder (Order removeOrder, LocalDate date) throws DaoFileException;
    public Order findOrder(LocalDate date, int orderNumber) throws DaoFileException;
    public void saveData()throws DaoFileException;
}
