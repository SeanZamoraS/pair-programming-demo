package com.pluralsight.application;

import com.pluralsight.models.Vehicle;

public class SalesContract extends Contract {
    private boolean finance;

    public SalesContract(String date,
                         String customerName,
                         String customerEmail,
                         Vehicle vehicleSold,
                         boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    public double getTax()
    {
        return 0; //how are we calculating tax?
    }

    public double getSalesTax() {
        return getVehicleSold().getPrice() * 0.05;
    }

    public double getRecordingFee() {
        return 100.00;
    }

    public double getProcessingFee() {
        if (getVehicleSold().getPrice() > 10000) {
            return 295.00;
        }
        return 495;
    }

    @Override
    public double getTotalPrice() {

        return getVehicleSold()
                .getPrice()
                + getSalesTax()
                + getRecordingFee()
                + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0;
        }
        double totalPrice = getTotalPrice();

        double interestRate;
        int months;

        if (totalPrice >= 10000) {
            interestRate = 0.0425;
            months = 48;
        } else {
            interestRate = 0.0525;
            months = 24;
        }
        double monthlyRate = interestRate / 12;
        return (totalPrice * monthlyRate)
                / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
