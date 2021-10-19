/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermprojectrd;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Relo's PC
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD) 
@WebService
public class Consoles {
private @XmlAttribute String type;
private @XmlAttribute int consoleid;
private @XmlAttribute int storage;
private @XmlAttribute String condition;
    
    
    
    public Consoles(){
    }

    public Consoles(String type, int consoleid, int storage, String condition) {
        this.type = type;
        this.consoleid = consoleid;
        this.storage = storage;
        this.condition = condition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setConsoleid(int consoleid) {
        this.consoleid = consoleid;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public int getConsoleid() {
        return consoleid;
    }

    public int getStorage() {
        return storage;
    }

    public String getCondition() {
        return condition;
    }
    
    
}