/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DaoFileException;
import DAO.TaxDao;
import DTO.Order;
import DTO.Tax;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public class TaxServiceImpl implements TaxService {
    TaxDao taxDao;
    
    
    public TaxServiceImpl (TaxDao taxDao){
        this.taxDao = taxDao;
    }
    @Override
    public Tax getTaxRateService(String state)throws DaoFileException{
        Tax serviceTax = taxDao.getTaxRate(state);
        return serviceTax;
    }
    @Override
    public List<Tax> listTaxes() throws DaoFileException {
        return taxDao.listTaxes();
    }
}
