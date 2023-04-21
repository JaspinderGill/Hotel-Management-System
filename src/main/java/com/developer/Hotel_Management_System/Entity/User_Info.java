package com.developer.Hotel_Management_System.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class User_Info {
   @Id
   int user_Id;
   String sname;
   String address;
   int mobile_no;

    public User_Info(int user_Id, String sname, String address, int mobile_no) {
        this.user_Id = user_Id;
        this.sname = sname;
        this.address = address;
        this.mobile_no = mobile_no;
    }
    
    public User_Info()
    {
    
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(int mobile_no) {
        this.mobile_no = mobile_no;
    }
   
   
   
         
}