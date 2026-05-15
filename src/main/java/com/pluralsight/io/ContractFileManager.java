package com.pluralsight.io;

import com.pluralsight.application.Contract;
import com.pluralsight.application.LeaseContract;
import com.pluralsight.application.SalesContract;
import com.pluralsight.models.Vehicle;
import com.pluralsight.models.Dealership;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager
{
    public void recordContract(Contract contract)
    {
        try(FileWriter fileWriter = new FileWriter("data/contracts.csv",true);
            PrintWriter writer = new PrintWriter(fileWriter))
        {
            writer.printf("%s|%s|%s|%s|((((%d|%d|%s|%s|%s|%s|%d|%.2f|)))%d|%d|%d|%d|%b|%d\n",
                    contract.getType(),
                    contract.getDate(),
                    contract.getCustomerName(),
                    contract.getCustomerEmail(),
                    //Sale/Lease, Date of Contract, Cust Name, Cust email.... 4
                    contract.getVehicleSold().getVin(),
                    contract.getVehicleSold().getYear(),
                    contract.getVehicleSold().getMake(),
                    contract.getVehicleSold().getModel(),
                    contract.getVehicleSold().getVehicleType(),
                    contract.getVehicleSold().getColor(),
                    contract.getVehicleSold().getOdometer(),
                    contract.getVehicleSold().getPrice(), //price from Vehicle
                    //info from Vehicle
                    contract.getTax(),
                    contract.getRecordingFee(),
                    contract.getProcessingFee(),
                    contract.getTotalPrice(),
                    contract.getType(),
                    contract.getMonthlyPayment()

            );
        }
        catch(IOException e)
        {
            //swallow
            System.out.println("Exception");
        }
    }

}