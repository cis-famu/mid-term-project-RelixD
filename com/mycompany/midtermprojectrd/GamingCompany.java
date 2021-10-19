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
 * @author Relix Daniels
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@WebService        
public class GamingCompany {
    private @XmlAttribute String companyName;
    private @XmlAttribute int companyid;
    private @XmlAttribute String city;
    private @XmlAttribute String state;
    private int areacode;
    
    public GamingCompany(){
    }

    public GamingCompany(String companyName, int companyid, String city, String state, int areacode) {
        this.companyName = companyName;
        this.companyid = companyid;
        this.city = city;
        this.state = state;
        this.areacode = areacode;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAreacode(int areacode) {
        this.areacode = areacode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyid() {
        return companyid;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getAreacode() {
        return areacode;
    }
    
    
    
    
}
