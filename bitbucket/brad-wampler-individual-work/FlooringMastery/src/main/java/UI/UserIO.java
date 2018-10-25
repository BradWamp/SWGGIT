/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author j1bdw02
 */
public interface UserIO {
    void print(String msg);
    BigDecimal readBigDecimal(String prompt);
    int readInt(String prompt);
    int readInt(String prompt, int min, int max);
    LocalDate readDate(String prompt);
    String readString(String prompt);
    public String readMenuInt(String msgPrompt, int min, int max);
}
