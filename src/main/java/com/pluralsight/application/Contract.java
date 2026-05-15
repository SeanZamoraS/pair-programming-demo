package com.pluralsight.application;

import com.pluralsight.models.Vehicle;

public abstract class Contract {

    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract (String date,
                     String customerName,
                     String customerEmail,
                     Vehicle vehicleSold){
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;

    }
    //getters
    public String getDate(){
        return date;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getCustomerEmail(){
        return customerEmail;
    }
    public Vehicle getVehicleSold(){
        return vehicleSold;
    }
    // abstract method for calculation
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

}
