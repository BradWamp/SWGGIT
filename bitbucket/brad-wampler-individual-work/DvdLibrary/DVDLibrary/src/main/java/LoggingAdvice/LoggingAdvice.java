/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoggingAdvice;

import DAO.DvdDaoException;
import DAO.DvdLoggingDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author bwamp
 */
public class LoggingAdvice {

    DvdLoggingDao loggingDao;

    public LoggingAdvice(DvdLoggingDao loggingDao) {
        this.loggingDao = loggingDao;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String loggingEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            loggingEntry += currentArg;
        }
        try {
            loggingDao.writeLoggingEntry(loggingEntry);
        } catch (DvdDaoException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
