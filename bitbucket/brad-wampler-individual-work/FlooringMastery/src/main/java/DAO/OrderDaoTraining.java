/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author j1bdw02
 */
public class OrderDaoTraining implements OrderDao {

    public static final String DELIMITER = ",";
    public String file;
    HashMap<Integer, Order> orderMap = new HashMap<>();

    @Override
    public List<Order> listOrders(LocalDate date) throws DaoFileException {
        loadOrder(date);
        return new ArrayList<Order>(orderMap.values());
    }
    @Override
    public Order findOrder(LocalDate date, int orderNumber) throws DaoFileException {
        loadOrder(date);
            Order newOrder = orderMap.get(orderNumber);
        return newOrder;
    }
    
    public void loadOrder(LocalDate userDate) throws DaoFileException {
        Scanner scanner;
        String currentLine;
        String[] currentTokens;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
        String formattedDate = userDate.format(dtf);
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("Orders_" + formattedDate + ".txt")));
        } catch (FileNotFoundException e) {
            throw new DaoFileException("Load failed, might not be any orders for that date. Try again.", e);
        }

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Order currentOrder = new Order();

            currentOrder.setOrderNumber(Integer.parseInt(currentTokens[0]));
            currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setState(currentTokens[2]);
            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
            currentOrder.setProduct(currentTokens[4]);
            currentOrder.setArea(new BigDecimal(currentTokens[5]));
            currentOrder.setCostPerFoot(new BigDecimal(currentTokens[6]));
            currentOrder.setLaborPerFoot(new BigDecimal(currentTokens[7]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
            currentOrder.setTax(new BigDecimal(currentTokens[10]));
            currentOrder.setTotal(new BigDecimal(currentTokens[11]));

            orderMap.put(currentOrder.getOrderNumber(), currentOrder);
        }
        scanner.close(); // is this to save memory?
    }
    @Override
    public List<Order> addToList (Order newOrder, LocalDate date)throws DaoFileException{
        try{
            loadOrder(date);
        }finally{
        orderMap.put(newOrder.getOrderNumber(), newOrder);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
        this.file = "Orders_" + date.format(dtf) + ".txt";
        //printData();
        
        List<Order> orderList = new ArrayList <Order>(orderMap.values());
        return orderList;
        }
    }
    @Override 
    public List<Order> removeOrder (Order removeOrder, LocalDate date) throws DaoFileException{
        orderMap.remove(removeOrder.getOrderNumber());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
        this.file = "Orders_" + date.format(dtf) + ".txt";
        //printData();
        List<Order> orderList = new ArrayList <Order>(orderMap.values());
        return orderList;
    }
    @Override
    public void saveData()throws DaoFileException{
        this.printData();
    }
    private void printData() throws DaoFileException {
        // does nothing in training mode.
    }
}

