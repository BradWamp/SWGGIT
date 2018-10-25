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
public class DvdPersistenceException extends Exception{
    public DvdPersistenceException (String message) {
        super(message);
    }
    public DvdPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
}
