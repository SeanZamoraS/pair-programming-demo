package com.pluralsight.application;

import com.pluralsight.io.DealershipFileManager;
import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import com.pluralsight.ui.UserInterface;

import java.io.IOException;
import java.util.ArrayList;

public class DealershipApplication
{
    Dealership dealership;

    public DealershipApplication(Dealership dealership) throws IOException
    {
        this.dealership = dealership;
    }

    public void run() throws IOException
    {
        while(true)
        {
            int choice = UserInterface.getHomeScreenSelection(dealership);

            switch (choice)
            {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    searchByPrice();
                    break;
                case 3:
                    searchByYear();
                    break;
                case 4:
                    searchByColor();
                    break;
                case 5:
                    searchByMileage();
                    break;
                case 6:
                    searchByVehicleType();
                    break;
                case 7:
                    addAVehicle();
                    break;
                case 0:
                    UserInterface.endApplication();
                    System.exit(0);
                default:
                    UserInterface.endApplication();
                    System.exit(0);
            }
        }
    }

    private void displayAllVehicles()
    {
        UserInterface.displayMessage("\nShow All Vehicles");
        UserInterface.displayMessage("------------------------------------");
        UserInterface.displayVehicles(dealership.getAllVehicles());
    }

    private void searchByPrice()
    {
        UserInterface.displayMessage("\nSearch by Price");
        UserInterface.displayMessage("------------------------------------");
        double min = UserInterface.getUserInputDouble("Minimum Price: ");
        double max = UserInterface.getUserInputDouble("Maximum Price: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        UserInterface.displayMessage("------------------------------------");
        UserInterface.displayVehicles(vehicles);

    }

    private void searchByYear()
    {
        // get min and max year from user
        UserInterface.displayMessage("\nSearch by year");
        UserInterface.displayMessage("--------------------------");
        int minYear = UserInterface.getUserInputInt("Minimum Year: ");
        int maxYear = UserInterface.getUserInputInt("Maximum Year: ");

        // search for vehicle by year
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);

        // display the vehicles
        UserInterface.displayVehicles(vehicles);
    }
    private void addAVehicle() throws IOException {
        UserInterface.displayMessage("\nAdd a vehicle");
        UserInterface.displayMessage("--------------------------");
        int vin = UserInterface.getUserInputInt("Enter the vin: ");
        int year = UserInterface.getUserInputInt("Enter the year of the vehicle: ");
        String make = UserInterface.getUserInput("Enter the make: ");
        String model = UserInterface.getUserInput("Enter the model: ");
        String type = UserInterface.getUserInput("Enter the vehicle type: ");
        String color = UserInterface.getUserInput("Enter the color: ");
        int odometer = UserInterface.getUserInputInt("Enter the miles on the vehicle: ");
        double price = UserInterface.getUserInputDouble("Enter the price of the vehicle: ");

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        DealershipFileManager.addVehicle(vehicle);
        Dealership newDealership = DealershipFileManager.loadDealership();
        DealershipFileManager.saveDealership(newDealership);


    }

    private void searchByColor()
    {
        UserInterface.displayMessage("search by color");
    }

    private void searchByMileage()
    {
        UserInterface.displayMessage("search by mileage");
    }

    private void searchByVehicleType()
    {
        UserInterface.displayMessage("search by vehicle type");
    }

    private void addVehicle()
    {
        UserInterface.displayMessage("build add vehicle logic");
    }
}
