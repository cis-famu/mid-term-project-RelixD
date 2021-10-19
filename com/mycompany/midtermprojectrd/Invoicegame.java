/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermprojectrd;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Relix Daniels
 */
@WebService
public class Invoicegame extends Game{
    private @XmlAttribute float retailPrice;
   
    
    public Invoicegame(){}

    public Invoicegame(float retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Invoicegame(float retailPrice, String title, int quantity, String quality, int year, String description) {
        super(title, quantity, quality, year, description);
        this.retailPrice = retailPrice;
    }

    public float getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
    }

  
    
    
    
    
    
    
    
}
