/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author j1bdw02
 */
public class TaxDaoFileImpl implements TaxDao{

    public static final String DELIMITER = ",";
    public static final String TAXFILE = "Taxes.txt";
    private HashMap <String, Tax> taxMap = new HashMap<>();
    
    public TaxDaoFileImpl()throws Exception{
        loadTaxes();
    }
    
    @Override
    public Tax getTaxRate(String state) throws DaoFileException{
        //loadTaxes();
        Tax newTax = taxMap.get(state);
        return newTax;
    }
    @Override
    public List<Tax> listTaxes() throws DaoFileException {
        //loadTaxes();
        return new ArrayList<Tax>(taxMap.values());
    }
    @Override
    public void addTax(String key, Tax tax){
        taxMap.put(key, tax);
    }
    
    private void loadTaxes() throws DaoFileException{
        Scanner scanner;
	String currentLine;
        String[] currentTokens;
	try {
	    scanner = new Scanner(new BufferedReader(new FileReader(TAXFILE)));
	} catch (FileNotFoundException e) {
	    throw new DaoFileException("Tax File load failed.", e);
	}
        
        while (scanner.hasNextLine()) {
	    currentLine = scanner.nextLine();
	    currentTokens = currentLine.split(DELIMITER);
            Tax currentTax = new Tax();
	    
            currentTax.setState(currentTokens[0]);
            currentTax.setTaxRate(new BigDecimal(currentTokens[1]));
                       
	    taxMap.put(currentTax.getState(), currentTax);
        }
	    scanner.close();
        } 
}

