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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author j1bdw02
 */
public class OrderDaoFileImpl implements OrderDao {

    public static final String DELIMITER = ",";
    public String file;
    //List<Order> orderList = new ArrayList<>();
    HashMap<LocalDate, List<Order>> orderMap = new HashMap<>();

    @Override
    public List<Order> listOrders(LocalDate date) throws DaoFileException {
        List<Order> newList = loadOrder(date);
        return newList;
    }

    @Override
    public Order findOrder(LocalDate date, int orderNumber) throws DaoFileException {
        List<Order> newList = loadOrder(date);
        Order newOrder = null;
        for (Order currentOrder : newList) {
            if (currentOrder.getOrderNumber() == orderNumber) {
                newOrder = currentOrder;
                break;
            }
        }
        return newOrder;
    }

    public List<Order> loadOrder(LocalDate userDate) throws DaoFileException {
        Scanner scanner;
        List<Order> orderList = new ArrayList<>();
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

            orderList.add(currentOrder);
        }

        //orderMap.put(userDate, orderList);
        scanner.close(); // is this to save memory?
        orderMap.put(userDate, orderList);
        return orderList;
    }

    @Override
    public List<Order> addToList(Order newOrder, LocalDate date) throws DaoFileException {
        int counter = 0;
        //loadOrder(date);
        List<Order> newList = orderMap.get(date);
        if (newList == null) {
            List<Order> addList = new ArrayList<>();
            addList.add(0, newOrder);
            orderMap.put(date, addList);
            return addList;
        } else {
            for (Order currentOrder : newList) {
                if (currentOrder.getOrderNumber() == newOrder.getOrderNumber()) {
                    newList.set(counter, newOrder);
                    orderMap.put(date, newList);
                    break;
                }
            }
            return newList;
        }
    }

    @Override
    public List<Order> removeOrder(Order removeOrder, LocalDate date) throws DaoFileException {
        orderMap.remove(removeOrder.getOrderNumber());
        //printData();
        List<Order> orderList = orderMap.get(date);
        for (Iterator<Order> i = orderList.iterator(); i.hasNext();) {
            Order o = i.next();
            if ((o.getOrderNumber() == removeOrder.getOrderNumber())) {
                i.remove();
            }
        }

        return orderList;
    }

    @Override
    public void saveData() throws DaoFileException {
        this.printData();
    }

    private void printData() throws DaoFileException {
        PrintWriter out;
        List<Order> newList;
        for (LocalDate currentDate : orderMap.keySet()) {
            try {
                newList = orderMap.get(currentDate);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
                String stringDate = "Orders_" + currentDate.format(dtf) + ".txt";
                out = new PrintWriter(new FileWriter(stringDate));
            } catch (Exception e) {
                throw new DaoFileException("Could not save data.", e);
            }

            for (Order currentOrder : newList) {
                // write the Student object to the file
                out.println(currentOrder.getOrderNumber() + DELIMITER
                        + currentOrder.getCustomerName() + DELIMITER
                        + currentOrder.getState() + DELIMITER
                        + currentOrder.getTaxRate() + DELIMITER
                        + currentOrder.getProduct() + DELIMITER
                        + currentOrder.getArea() + DELIMITER
                        + currentOrder.getCostPerFoot() + DELIMITER
                        + currentOrder.getLaborPerFoot() + DELIMITER
                        + currentOrder.getMaterialCost() + DELIMITER
                        + currentOrder.getLaborCost() + DELIMITER
                        + currentOrder.getTax() + DELIMITER
                        + currentOrder.getTotal());

                out.flush();
            }
            out.close();
        }
    }

}
