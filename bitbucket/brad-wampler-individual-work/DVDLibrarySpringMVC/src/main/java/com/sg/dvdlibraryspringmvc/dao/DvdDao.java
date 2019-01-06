/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bwamp
 */
public interface DvdDao {
    public Dvd addDvd(Dvd newDvd);
    public void removeDvd(int dvdId);
    public void editDvd(Dvd dvd);
    public List<Dvd> listDvd();
    public Dvd searchForDvd(int searchFor);
    public List<Dvd> searchAllDvd(String searchCategory, String searchTerm);

}
