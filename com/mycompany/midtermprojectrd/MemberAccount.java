/*
 * 
 * Game Purchasing System.

 */
package com.mycompany.midtermprojectrd;

import java.util.Date;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Relix Daniels
 */
@WebService
public class MemberAccount {
  private @XmlAttribute String fname;
  private @XmlAttribute String lname;
  private @XmlAttribute int memberid;
  private @XmlAttribute String premiumMember;
  private Date birthday;
  private @XmlAttribute int phonenumber;
    
    
    
    public MemberAccount(){
    }

    public MemberAccount(String fname, String lname, int memberid, String premiumMember, Date birthday, int phonenumber) {
        this.fname = fname;
        this.lname = lname;
        this.memberid = memberid;
        this.premiumMember = premiumMember;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public String getPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(String premiumMember) {
        this.premiumMember = premiumMember;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String createMemberAccount(String fname, String lname, int memberid, String premiumMember, Date birthday, int phonenumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
