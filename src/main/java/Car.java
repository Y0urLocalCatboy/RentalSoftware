public class Car extends Vehicle{
    private String type; //ICE/hybrid/BEV/
    private String brand;
    public Car(String type, String brand, String color, String licensePlate, boolean isRented, int rentedDays, int pricePerHour) {
        super(color, licensePlate, isRented, rentedDays, pricePerHour);
        this.type = type;
        this.brand = brand;
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
        return "Car{" + super.toString() +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}