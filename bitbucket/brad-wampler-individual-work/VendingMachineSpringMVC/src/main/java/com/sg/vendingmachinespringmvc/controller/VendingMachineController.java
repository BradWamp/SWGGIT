/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.VendingMachineService;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//test
/**
 *
 * @author bwamp
 */
@Controller
public class VendingMachineController {

    VendingMachineService service;

    @Inject
    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        // Get all the Items from the DAO make sure xml has bean for injection
        List<Item> itemList = service.getAllItems();
        String displayMoney = service.getUserMoney();
        Item storedItem = service.returnItem();
        String change = service.returnChange();
        String message = service.displayMessage();
        
        // Put the List of items on the Model? What does this mean, ins't the model just the DTO?
        model.addAttribute("itemList", itemList);
        model.addAttribute("displayMoney", displayMoney);
        model.addAttribute("storedItem", storedItem);
        model.addAttribute("change", change);
        model.addAttribute("message", message);

        // Return logical name of view
        return "index";
    }

    @RequestMapping(value = "/addMoney", method = RequestMethod.GET)
    public String addMoney(HttpServletRequest request, Model model) {
        String money = request.getParameter("moneyAmount");
        service.addUserMoney(money);        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/vendItem", method = RequestMethod.POST)
    public String vendItem(HttpServletRequest request, Model model)throws Exception {
        try{
        int itemID = Integer.parseInt(request.getParameter("itemNumber"));
        Item item = service.getItemById(itemID);
        item = service.vendItem(item);
        service.updateItem(item);
        service.createMessage("Thank You!");
        service.clearVariables();
        }catch(NumberFormatException e){
            service.createMessage("Please select and item");
        }catch(InsufficientFundsException e){
            service.createMessage(e.getMessage());
        }catch(NoItemInventoryException e){
            service.createMessage(e.getMessage());
        }
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/selectItem", method = RequestMethod.POST)
    public String selectItem(HttpServletRequest request, @RequestParam(value="itemNumber", required=false) Integer itemNumber, Model model) {
        
        Item newItem = new Item();
        newItem.setItemNumber(Integer.parseInt(request.getParameter("itemNumber")));
        newItem.setAmount(Integer.parseInt(request.getParameter("amount")));
        newItem.setPrice(new BigDecimal(request.getParameter("price")));
        newItem.setItem(request.getParameter("item"));
        service.createItem(newItem);
        service.clearMessages();
        // update item in list for new amount
//        dao.updateItem(item);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/returnChange", method = RequestMethod.GET)
    public String getChange(HttpServletRequest request, Model model) {
        
        service.calculateChange(BigDecimal.ZERO);
        service.clearVariables();
        service.clearMessages();
        return "redirect:/";
    }


}
