/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tax;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public interface TaxDao {
   public Tax getTaxRate(String state) throws DaoFileException;
   public List<Tax> listTaxes() throws DaoFileException;
   public void addTax(String key, Tax tax);
}
