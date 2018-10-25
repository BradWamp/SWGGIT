/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoFileException;
import DTO.Order;
import DTO.Product;
import DTO.Tax;
import Service.OrderService;
import Service.ProductService;
import Service.TaxService;
import UI.FlooringView;
import java.io.FileNotFoundException;
import java.time.LocalDate;

/**
 *
 * @author j1bdw02
 */
public class Controller {

    private FlooringView view;
    private OrderService orderService;
    private TaxService taxService;
    private ProductService productService;

    public Controller(FlooringView view, OrderService orderService, TaxService taxService, ProductService productService) {
        this.view = view;
        this.orderService = orderService;
        this.taxService = taxService;
        this.productService = productService;
    }

    private boolean runProgram = true;
    private int userSelection;

    public void run() {
            while (runProgram) {
             try{
                userSelection = view.getUserOption();
                if (userSelection == 1) {
                    displayOrders();
                } else if (userSelection == 2) {
                    addOrder();
                } else if (userSelection == 3) {
                    editOrder();
                } else if (userSelection == 4) {
                    removeOrder();
                } else if (userSelection == 5) {
                    save();
                } else if (userSelection == 6) {
                    save();
                    break;
                } else if (userSelection == 7) {
                    switchModes();
                } else {
                    view.invalidInput();
                }
            }
           catch (Exception e) {
              view.error(e);
          }
       }
    }

    public void displayOrders() throws Exception {
        LocalDate date = view.displayOrdersView();
        try {
            view.listOrders(orderService.listOrdersService(date));
        } catch (DaoFileException e) {
            view.error(e);
        }
    }

    public void addOrder() throws DaoFileException, FileNotFoundException {
        Order newOrder = view.inputOrderInfo(taxService.listTaxes(), productService.listProducts());
        Tax newTax = taxService.getTaxRateService(newOrder.getState());
        Product newProduct = productService.getProductRatesService(newOrder.getProduct());
        newOrder = orderService.generateOrderNumber(orderService.calculateTotals(newOrder, newTax, newProduct));
        orderService.submitOrder(LocalDate.now(), view.confirmEntry(newOrder), newOrder, "add");
        //newOrder = taxService.getTaxRateService(newOrder);
        //newOrder = productService.getProductRatesService(newOrder);
        //newOrder = orderService.generateOrderNumber(newOrder);
    }

    public void editOrder() throws Exception {
        LocalDate date = view.displayOrdersView();
        int orderNumber = 0;
        try{
            orderNumber = view.findOrderNumber();
            Order editOrder = orderService.findOrderEdit(orderNumber, date); 
            Order newOrder = view.editOrder(editOrder, taxService.listTaxes(), productService.listProducts(), "Please select an option");
            newOrder = orderService.calculateTotals(newOrder, taxService.getTaxRateService(newOrder.getState()),
                productService.getProductRatesService(newOrder.getProduct()));
            orderService.submitOrder(date, view.confirmEntry(newOrder), newOrder, "edit");
        }catch(Exception e){
            throw new DaoFileException("There doesn't appear to be any order number for that input. Try again.", e);
        }
        // pass number and date into arguments with view methods
        
        //editName asks user for new customer name or leaves the same, editState asks for new state or leaves the same needs original state and list of states,
        //editProduct asks for new product or leaves the same needs old product and list of products, editArea asks for new area or leaves the same, newOrder is the order to be compiled.
        
        }

    public void removeOrder() throws Exception {
        LocalDate date = view.displayOrdersView();
        Order removeOrder = orderService.findOrderEdit(view.findOrderNumber(), date);
        orderService.removeOrderService(view.removeOrder(removeOrder), removeOrder, date);
    }

    public void save()throws DaoFileException {
        orderService.saveDataService();
        view.saveConfirmation();
    }
    public void switchModes(){
        view.modeConfirmation(orderService.switchMode(view.getMode()));
        
    }
}
