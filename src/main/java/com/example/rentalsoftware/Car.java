package com.example.rentalsoftware;

public class Car extends Vehicle implements UserInterface {
    private String type; // ICE/hybrid/BEV
    private String brand;

    public Car(String type, String brand, String color, String licensePlate, boolean isRented, int rentedDays, int pricePerHour) {
        super(color, licensePlate, isRented, rentedDays, pricePerHour);
        this.type = type;
        this.brand = brand;
    }

    @Override
    public Return invoice() {
        Return return1 = new Return(getLicensePlate(), getBrand(), (24 * getRentedDays() * getPricePerHour()));
        this.setRented(false);
        return return1;
    }

    @Override
    public void reservation() {
        this.setRented(true);
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

    @Override
    public String toString() {
        return "[Car] " + getBrand() + " " + super.toString();
    }
}
