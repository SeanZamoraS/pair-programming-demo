package com.pluralsight.application;

import com.pluralsight.models.Vehicle;

public class LeaseContract extends Contract
{
    private double expectedEndValue;
    private final double leaseFee = 0.07;
    private final double interestRate = 0.04;

    public LeaseContract(String date,
                         String customerName,
                         String customerEmail,
                         Vehicle vehicleSold)
    {
        super(date, customerName, customerEmail, vehicleSold);
        double expectedEndValue = this.getVehicleSold().getPrice() * 0.5;
        this.expectedEndValue = expectedEndValue;
    }

    public void setExpectedEndValue(double expectedEndValue) {this.expectedEndValue = expectedEndValue;}
    public double getExpectedEndValue() {return this.expectedEndValue;}
    public double getLeaseFee() {return this.leaseFee;}
    public double getInterestRate() {return this.interestRate;}

    public double getTax()
    {
        return 0; //how are we calculating tax??
    }
    public double getProcessingFee() {return 0;} //leases have no fees?
    public double getRecordingFee() {return 0;}

    @Override
    public double getTotalPrice()
    {
        return this.expectedEndValue * (1 + this.leaseFee);
    }

    @Override
    public double getMonthlyPayment()
    {
        double pricePerMonth = this.getTotalPrice() / 36;
        pricePerMonth *= 1 + this.interestRate;
        return pricePerMonth;
    }



}