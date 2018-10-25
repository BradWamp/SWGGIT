/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author j1bdw02
 */
public class DaoFileException extends Exception {
     public DaoFileException(String message) {
        super(message);
    }
	    
    public DaoFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
