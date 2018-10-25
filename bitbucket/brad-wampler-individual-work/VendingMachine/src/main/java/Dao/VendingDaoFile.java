/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bwamp
 */
public interface VendingDaoFile {
    public List<Item> displayItems() throws VendingDaoException;
    public Item getItem (int itemNumber)throws VendingDaoException;
    public Item updateInventory(Item newItem) throws VendingDaoException;
}
