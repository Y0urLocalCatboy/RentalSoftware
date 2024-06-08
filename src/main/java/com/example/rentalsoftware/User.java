package com.example.rentalsoftware;

import java.util.List;

public class User {
    private String name;
    private String surname;
    private List<Vehicle> vehicles;

    public User(String name, String surname, List<Vehicle> vehicles) {
        this.name = name;
        this.surname = surname;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
