/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DaoFileException;
import DTO.Order;
import DTO.Tax;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public interface TaxService {
    public Tax getTaxRateService(String state)throws DaoFileException;
    public List<Tax> listTaxes() throws DaoFileException;
    // need to validate that state abbreviation is in the file.
}

  