/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author bwamp
 */
public class Change {
    int quarterCount;
    int dimeCount;
    int nickelCount;
    int pennyCount;

    public int getQuarterCount() {
        return quarterCount;
    }

    public void setQuarterCount(int quarterCount) {
        this.quarterCount = quarterCount;
    }

    public int getDimeCount() {
        return dimeCount;
    }

    public void setDimeCount(int dimeCount) {
        this.dimeCount = dimeCount;
    }

    public int getNickelCount() {
        return nickelCount;
    }

    public void setNickelCount(int nickelCount) {
        this.nickelCount = nickelCount;
    }

    public int getPennyCount() {
        return pennyCount;
    }

    public void setPennyCount(int pennyCount) {
        this.pennyCount = pennyCount;
    }
    
}
