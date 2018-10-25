/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author j1bdw02
 */
public class TaxDaoStubImpl implements TaxDao{
    Tax fakeTax = new Tax();
    Tax fakeTax2 = new Tax();
    Map <String, Tax> taxMap = new HashMap<>();
    
    public TaxDaoStubImpl(){
        fakeTax.setState("KS");
        fakeTax.setTaxRate(BigDecimal.ONE);
        
        fakeTax2.setState("MO");
        fakeTax2.setTaxRate(BigDecimal.ONE);
        
        taxMap.put(fakeTax.getState(), fakeTax);
        taxMap.put(fakeTax2.getState(), fakeTax2);
    }

    @Override
    public Tax getTaxRate(String state) throws DaoFileException {
         return taxMap.get(state);
    }

    @Override
    public List<Tax> listTaxes() throws DaoFileException {
        return new ArrayList<>(taxMap.values());
    }

    @Override
    public void addTax(String key, Tax tax) {
        taxMap.put(key, tax);
    }
    
}
