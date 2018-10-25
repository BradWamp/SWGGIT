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
public interface DvdLoggingDao {
    public void writeLoggingEntry(String entry) throws DvdDaoException;
}
