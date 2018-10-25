/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
public class FlooringView {

    UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }
    public int getMode() {
        io.print("1. Training");
        io.print("2. Production");        
        return io.readInt("Select the number of the mode to run in", 1, 2);
    }
    public void modeConfirmation (String string){
        io.print(string);
    }

    public int getUserOption() {
        io.print("---DVD Library Menu Selection---");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Save Current Work");
        io.print("6. Quit");
        io.print("7. Switch Mode");
        return io.readInt("Please select the number for the function you'd like to perform", 1, 7);
    }

    public LocalDate displayOrdersView() {
        return io.readDate("Please enter date to search for orders in format MM/dd/yyyy");
    }

    public void listOrders(List<Order> listOfOrders) {
        for (Order currentOrder : listOfOrders) {
            io.print("\nOrder Number: " + currentOrder.getOrderNumber() + "| Customer: " + currentOrder.getCustomerName() + "| State: " + currentOrder.getState()
                    + "| Tax Rate: " + currentOrder.getTaxRate() + "| Product Type: " + currentOrder.getProduct() + "| Area: " + currentOrder.getArea() + "| Cost Per Foot: " + currentOrder.getCostPerFoot()
                    + "| Labor Per Foot: " + currentOrder.getLaborPerFoot() + "| Material Cost: " + currentOrder.getMaterialCost() + "| Labor Cost " + currentOrder.getLaborCost()
                    + "| Tax: " + currentOrder.getTax() + "| Total: " + currentOrder.getTotal());
            io.print("-------------------------");
        }
    }

    public void error(Exception e) {
        io.print(e.getMessage());
    }
    public void invalidInput(){
        io.print("Please select a valid option");
    }

    public void saveConfirmation() {
        io.print("Data has been saved to file.");
    }

    public Order inputOrderInfo(List<Tax> listOfTaxes, List<Product> listOfProducts) {
        Order viewOrder = new Order();
        viewOrder.setCustomerName(io.readString("What is the customer Name?"));
        int stateNumber = this.listTaxes(listOfTaxes);
        Tax viewTax = listOfTaxes.get(stateNumber - 1);
        viewOrder.setState(viewTax.getState());
        int productNumber = this.listProducts(listOfProducts);
        Product viewProduct = listOfProducts.get(productNumber - 1);
        viewOrder.setProduct(viewProduct.getProduct());
        viewOrder.setArea(io.readBigDecimal("What is the total area?"));
        return viewOrder;
    }

    public String confirmEntry(Order currentOrder) {
        io.print("\nOrder Number: " + currentOrder.getOrderNumber() + "| Customer: " + currentOrder.getCustomerName() + "| State: " + currentOrder.getState()
                + "| Tax Rate: " + currentOrder.getTaxRate() + "| Product Type: " + currentOrder.getProduct() + "| Area: " + currentOrder.getArea() + "| Cost Per Foot: " + currentOrder.getCostPerFoot()
                + "| Labor Per Foot: " + currentOrder.getLaborPerFoot() + "| Material Cost: " + currentOrder.getMaterialCost() + "| Labor Cost " + currentOrder.getLaborCost()
                + "| Tax: " + currentOrder.getTax() + "| Total: " + currentOrder.getTotal());
        io.print("-----------------------");
        return io.readString("Is the order information correct and would you like to submit the order? (y/n)");
    }

    public Integer listTaxes(List<Tax> listOfTaxes) {
        int counter = 1;
        for (Tax currentTax : listOfTaxes) {
            io.print(counter + ": State - " + currentTax.getState());
            counter++;
        }
        return io.readInt("What is the option number of the State?", 1, listOfTaxes.size());
    }

    public Integer listProducts(List<Product> listOfProducts) {
        int counter = 1;
        for (Product currentProduct : listOfProducts) {
            io.print(counter + ": Product - " + currentProduct.getProduct());
            counter++;
        }
        return io.readInt("What is the option number of the Product?", 1, listOfProducts.size());
    }

    public Integer findOrderNumber() {
        return io.readInt("What is the order number you want to edit?");
    }

    public Order editOrder(Order editOrder, List<Tax> listOfTaxes, List<Product> listOfProduct, String message) {
        Order newOrder = editOrder;
        String name = io.readString("would you like to edit Customer Name? Currently: " + editOrder.getCustomerName() + " (enter new name, or press 'enter' to continue without editing)");
        if (name.equals("")) {
           // leave name the same
        } else {
            newOrder.setCustomerName(name);
        }
        newOrder.setState(editState(editOrder.getState(), listOfTaxes, message));
        newOrder.setProduct(editProduct(editOrder.getProduct(), listOfProduct, message));
        newOrder.setArea(editArea(editOrder.getArea()));
        return newOrder;
    }

    public String editState(String value, List<Tax> listOfTaxes, String message) {
        io.print("Would you like to change the state. State is currently: " + value + " {Press enter to continue without editing, or select a new number from below");
        int counter = 1;
        for (Tax currentTax : listOfTaxes) {
            io.print(counter + ": State - " + currentTax.getState());
            counter++;
        }
        String state = io.readMenuInt(message, 1, counter);
        if (state.equals("")) {
            return value;
        } else {
            Tax viewTax = listOfTaxes.get(Integer.valueOf(state) - 1);
            return viewTax.getState();
        }
    }

    public String editProduct(String value, List<Product> listOfProduct, String message) {
        io.print("Would you like to change the product. Product is currently: " + value + " {Press enter to continue without editing, or select a new number from below");
        int counter = 1;
        for (Product currentProduct : listOfProduct) {
            io.print(counter + ": Product - " + currentProduct.getProduct());
            counter++;
        }
        String product = io.readMenuInt(message, 1, counter);
        if (product.equals("")) {
            return value;
        } else {
            Product viewProduct = listOfProduct.get(Integer.valueOf(product) - 1);
            return viewProduct.getProduct();
        }
    }

    public BigDecimal editArea(BigDecimal value) {
        String name = io.readString("would you like to edit the Area? Currently: " + value + " (enter new area, or press 'enter' to continue without editing)");
        if (name.equals("")) {
            return value;
        } else {
            return new BigDecimal(name);
        }
    }

    public String removeOrder(Order removeOrder)throws DaoFileException {
        try{
        return io.readString("Are you sure you want to remove the following order? Enter (y/n)" + "\n"
                + "Order Number: " + removeOrder.getOrderNumber() + "| Customer: " + removeOrder.getCustomerName() + "| State: " + removeOrder.getState()
                + "| Tax Rate: " + removeOrder.getTaxRate() + "| Product Type: " + removeOrder.getProduct() + "| Area: " + removeOrder.getArea() + "| Cost Per Foot: " + removeOrder.getCostPerFoot()
                + "| Labor Per Foot: " + removeOrder.getLaborPerFoot() + "| Material Cost: " + removeOrder.getMaterialCost() + "| Labor Cost " + removeOrder.getLaborCost()
                + "| Tax: " + removeOrder.getTax() + "| Total: " + removeOrder.getTotal());
        }catch (Exception e){
            throw new DaoFileException ("could not find order number for that order date", e);
        }
        
    }
}
