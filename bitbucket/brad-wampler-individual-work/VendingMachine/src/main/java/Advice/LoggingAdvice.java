/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Advice;

import Dao.VendingDaoException;
import Dao.VendingLoggingDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author bwamp
 */
public class LoggingAdvice {
 
    VendingLoggingDao loggingDao;
 
    public LoggingAdvice(VendingLoggingDao loggingDao) {
        this.loggingDao = loggingDao;
    }
 
    public void createAuditEntry(JoinPoint jp, Exception ex) {
        Object[] args = jp.getArgs();
        String loggingEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            loggingEntry += currentArg + " :";
        }
        try {
            loggingDao.writeLoggingEntry(loggingEntry + ex);
        } catch (VendingDaoException e) {
            System.err.println(
               "ERROR: Could not create the log entry.");
        }
    }
}

