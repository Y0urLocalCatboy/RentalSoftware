package com.example.rentalsoftware;

public class Car extends Vehicle {
    private String additionalInfo;
    private String type; // ICE/hybrid/BEV
    private String brand;

    public Car(String type, String brand, String color, String licensePlate, boolean isRented, int rentedDays, int pricePerHour, String additionalInfo) {
        super(color, licensePlate, isRented, rentedDays, pricePerHour);
        this.type = type;
        this.brand = brand;
        this.additionalInfo = additionalInfo;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "[" + additionalInfo + "] " + getBrand() + " " + super.toString();
    }
}
