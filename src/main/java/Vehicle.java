public abstract class Vehicle {
    private String color;
    private String licensePlate;
    private boolean isRented; //true if the vehicle is already rented, false otherwise
    private int rentedDays; //number of hours the vehicle is rented for
    private int pricePerHour; //price for renting the vehicle for one hour
    public Vehicle(String color, String licensePlate, boolean isRented, int rentedDays, int pricePerHour) {
        this.color = color;
        this.licensePlate = licensePlate;
        this.isRented = isRented;
        this.rentedDays = rentedDays;
        this.pricePerHour = pricePerHour;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public boolean isRented() {
        return isRented;
    }
    public void setRented(boolean rented) {
        isRented = rented;
    }
    public int getRentedHours() {
        return rentedDays;
    }
    public void setRentedDays(int rentedDays) {
        this.rentedDays = rentedDays;
    }
    public int getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", isRented=" + isRented +
                ", rentedDays=" + rentedDays +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}