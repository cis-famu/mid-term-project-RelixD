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
public class Game {
    
    private @XmlAttribute String title;
    private @XmlAttribute int quantity;
    private @XmlAttribute String quality;
    private @XmlAttribute int year;
    private String description;
    
    public Game() {
      
  }

    public Game(String title, int quantity, String quality, int year, String description) {
        this.title = title;
        this.quantity = quantity;
        this.quality = quality;
        this.year = year;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
