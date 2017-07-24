package com.example.keshav.projecttcs;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AmanPC on 21-07-2017.
 */

public class DonorDeatils implements Serializable {

    public String username;
    public String city;
    public String mobile;
    public String bloodgroup;


    public DonorDeatils(){}

    public void setUsername(String username) { this.username = username; }

    public void setCity(String city) { this.city = city; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public void setBloodgroup(String bloodgroup){ this.bloodgroup = bloodgroup; }

    public String getUsername() { return username; }

    public String getCity() { return city; }

    public String getMobile() { return mobile; }

    public String getBloodgroup() { return bloodgroup; }


}
