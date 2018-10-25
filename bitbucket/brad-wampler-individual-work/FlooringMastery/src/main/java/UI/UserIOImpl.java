/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author j1bdw02
 */

public class UserIOImpl implements UserIO {
    final private Scanner console = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
    @Override
    public String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        return console.nextLine();
    }
    @Override
    public int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                // print the message msgPrompt (asking for #)
                String stringValue = this.readString(msgPrompt);
                // Get the input line, and try and parse
                num = Integer.parseInt(stringValue); 
                invalidInput = false; 
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }
        return num;
    }
    @Override
    public int readInt(String msgPrompt, int min, int max) {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);

        return result;
    }
    
    @Override
    public String readMenuInt(String msgPrompt, int min, int max) {
        String result;
        int resultInt;
        do {
            result = readString(msgPrompt);
                if(result.equals("")){
                    break;
                }else {
                   resultInt = Integer.parseInt(result);
                }
        } while (resultInt < min || resultInt > max);

        return result;
    } 
   
    @Override
    public LocalDate readDate(String msgPrompt) {
        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        while (true) {
            try {
                LocalDate date = LocalDate.parse(this.readString(msgPrompt), dateFormat);
                return date;
            } catch (Exception e) {
                System.out.println("Improper date format, try again.");
            }
        }
    }
    @Override
    public BigDecimal readBigDecimal(String msgPrompt) {
        while (true) {
            try {
                return new BigDecimal(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                System.out.println("Error in format, only enter numerical values");
            }
        }
    }    
}
