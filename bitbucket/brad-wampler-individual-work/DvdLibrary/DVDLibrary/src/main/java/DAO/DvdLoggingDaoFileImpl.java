/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author bwamp
 */
public class DvdLoggingDaoFileImpl implements DvdLoggingDao {
    
    public static final String LOGGING_FILE = "logging.txt";

    @Override
    public void writeLoggingEntry(String entry) throws DvdDaoException {
        
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(LOGGING_FILE, true));
        } catch (Exception e) {
            throw new DvdDaoException("Could not persist logging information.", e);
        }
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
 
}
