package com.example.mohamed.timely4app;

import java.util.Random;

import static java.lang.Math.random;

/**
 * Created by mohamed on 4/1/17.
 */

public class Recipient {
    String fName;
    String lName;
    String location;
    Boolean isAvailable;

    public Recipient(String fName, String lName, Boolean isAvailable) {
        this.fName = fName;
        this.lName = lName;
        this.isAvailable = isAvailable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Recipient(){
        Random rand = new Random();
        int m = rand.nextInt(10);
        if(m < 7){
            isAvailable = true;
        }
        else{
            isAvailable = false;
        }
    }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
