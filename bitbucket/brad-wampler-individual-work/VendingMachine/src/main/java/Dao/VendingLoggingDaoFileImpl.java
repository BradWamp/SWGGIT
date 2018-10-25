/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author bwamp
 */
public class VendingLoggingDaoFileImpl implements VendingLoggingDao {

    public static final String LOGGING_FILE = "logging.txt";

    @Override
    public void writeLoggingEntry(String entry) throws VendingDaoException {

        PrintWriter out;

        try {
        out = new PrintWriter(new FileWriter(LOGGING_FILE, true));
        } catch (Exception e) {
         throw new VendingDaoException("Could not persist logging information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
        out.close();
    }

}
