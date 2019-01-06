/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.service;

import com.sg.dvdlibraryspringmvc.dao.DvdDao;
import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author bwamp
 */
public class DvdServiceLayerImpl implements DvdServiceLayer {
    
    DvdDao dao;
    
    @Inject
    public DvdServiceLayerImpl (DvdDao dao){
        this.dao = dao;
    }

    @Override
    public Dvd addDvd(Dvd newDvd) {
        Dvd dvd = dao.addDvd(newDvd);
        return dvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        dao.removeDvd(dvdId);
    }

    @Override
    public void editDvd(Dvd dvd) {
        dao.editDvd(dvd);
    }

    @Override
    public List<Dvd> listDvd() {
        List<Dvd> newList = dao.listDvd();
        return newList;        
    }

    @Override
    public Dvd searchForDvd(int searchFor) {
       Dvd dvd = dao.searchForDvd(searchFor);
       return dvd;
    }

    @Override
    public List<Dvd> searchAllDvd(String searchCategory, String searchTerm) {
        List<Dvd> newList = dao.searchAllDvd(searchCategory, searchTerm);
        return newList;
    }
    
}
