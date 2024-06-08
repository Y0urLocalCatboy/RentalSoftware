package com.example.rentalsoftware;

import java.util.List;

public class Return {
    private String licensePlate;
    private String vehicle;
    private double totalAmount;

    public Return(String licensePlate, String vehicle, double totalAmount) {
        this.licensePlate = licensePlate;
        this.vehicle = vehicle;
        this.totalAmount = totalAmount;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "License Plate: " + licensePlate + "\nBrand: " + vehicle + "\nTotal Amount: " + totalAmount + "PLN\n";
    }
}