/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author bwamp
 */
import DTO.Dvd;
import java.time.LocalDate;
//import com.sun.security.ntlm.Server;
import java.util.List;
import java.util.Map;

public interface DvdDao {
    public Dvd addDvd(String title, Dvd newDvd) throws DvdDaoException ;
    public void removeDvd(String title) throws DvdDaoException ;
    public void editDvd(String returnTitle, int returnField, String returnFieldString) throws DvdDaoException ;
    public List<Dvd> listDvd() throws DvdDaoException ;
    public Dvd searchForDvd(String searchFor) throws DvdDaoException;
    public Map <String, List<Dvd>> getDvdByDirector(String director) throws DvdDaoException;
    public List<Dvd> getDvdByStudio(String director) throws DvdDaoException;
    public List<Dvd> getDvdBetweenYears(LocalDate startYear, LocalDate endYear) throws DvdDaoException;
    public double getAverageDvdAge()throws DvdDaoException;
    public List<Dvd> getDvdByMpaa(String mpaa) throws DvdDaoException;
    public Dvd getMinDate() throws DvdDaoException;
    public Dvd getMaxDate() throws DvdDaoException;
}
