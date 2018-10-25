/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;

/**
 *
 * @author bwamp
 */
public interface VendingMachineDao {

    public List<Item> getAllItems();

    public Item getItemById(int itemInt);

    public void updateItem(Item paramItem);

    public Item submitItem(Item paramItem);

    public void deleteItem(int paramInt);

}
