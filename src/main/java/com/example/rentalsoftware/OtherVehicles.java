package com.example.rentalsoftware;

public class OtherVehicles extends Car implements UserInterface {
    private String additionalInformation; //pickup/motorcycle/...

    public OtherVehicles(String type, String brand, String color, String licensePlate, boolean isRented, int rentedDays, int pricePerHour, String additionalInformation) {
        super(type, brand, color, licensePlate, isRented, rentedDays, pricePerHour);
        this.additionalInformation = additionalInformation;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "[" + additionalInformation + "] " + super.getBrand() + " " + super.getPricePerHour() + " PLN/hour" + " License Plate: " + super.getLicensePlate();
    }
}
