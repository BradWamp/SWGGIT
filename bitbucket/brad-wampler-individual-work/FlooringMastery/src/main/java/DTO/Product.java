/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;

/**
 *
 * @author j1bdw02
 */
public class Product {
    private String product;
    private BigDecimal materialCostPerFoot;
    private BigDecimal laborCostPerFoot;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getMaterialCostPerFoot() {
        return materialCostPerFoot;
    }

    public void setMaterialCostPerFoot(BigDecimal materialCostPerFoot) {
        this.materialCostPerFoot = materialCostPerFoot;
    }

    public BigDecimal getLaborCostPerFoot() {
        return laborCostPerFoot;
    }

    public void setLaborCostPerFoot(BigDecimal laborCostPerFoot) {
        this.laborCostPerFoot = laborCostPerFoot;
    }
    
}
