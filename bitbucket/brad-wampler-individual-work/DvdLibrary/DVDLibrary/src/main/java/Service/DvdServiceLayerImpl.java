/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DvdDao;
import DAO.DvdDaoException;
import DAO.DvdLoggingDao;
import DAO.DvdPersistenceException;
import DTO.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bwamp
 */
public class DvdServiceLayerImpl implements DvdServiceLayer {

    DvdDao dao;
    DvdLoggingDao loggingDao;
    
    public DvdServiceLayerImpl(DvdDao dao, DvdLoggingDao loggingDao) {
        this.dao = dao;
        this.loggingDao = loggingDao;
    }
    
    @Override
    public Dvd addDvd(String title, Dvd newDvd) throws DvdDaoException{
       //loggingDao.writeLoggingEntry("Added : " + title);
        return dao.addDvd(title, newDvd);
        
    }

    @Override
    public void removeDvd(String title) throws DvdDaoException{
        dao.removeDvd(title);
        //loggingDao.writeLoggingEntry("Removed : " + title);
    }

    @Override
    public void editDvd(String returnTitle, int returnField, String returnFieldString) throws DvdDaoException{
        dao.editDvd(returnTitle, returnField, returnFieldString);
        //loggingDao.writeLoggingEntry("Edited : " + returnTitle + "/" + returnFieldString );
    }

    @Override
    public List<Dvd> listDvd() throws DvdDaoException {
        return dao.listDvd();
    }

    @Override
    public Dvd searchForDvd(String searchFor) throws DvdDaoException {
        return dao.searchForDvd(searchFor);
    }

    @Override
    public Map<String, List<Dvd>> getDvdByDirector(String director) throws DvdDaoException {
        return dao.getDvdByDirector(director);
    }

    @Override
    public List<Dvd> getDvdByStudio(String director) throws DvdDaoException {
        return dao.getDvdByStudio(director);
    }

    @Override
    public List<Dvd> getDvdBetweenYears(LocalDate startYear, LocalDate endYear) throws DvdDaoException {
        return dao.getDvdBetweenYears(startYear, endYear);
    }

    @Override
    public double getAverageDvdAge() throws DvdDaoException {
        return dao.getAverageDvdAge();
    }

    @Override
    public List<Dvd> getDvdByMpaa(String mpaa) throws DvdDaoException {
        return dao.getDvdByMpaa(mpaa);
    }

    @Override
    public Dvd getMinDate() throws DvdDaoException {
        return dao.getMinDate();
    }

    @Override
    public Dvd getMaxDate() throws DvdDaoException {
        return dao.getMinDate();
    }
    
}
