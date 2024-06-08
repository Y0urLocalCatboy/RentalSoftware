public class OtherVehicles extends Car implements UserInterface {
    private String additionalInformation; //pickup/motorcycle/...
    @Override
    public void search() {
        System.out.println("Searching for other vehicles");
    }
    @Override
    public void reservation() {
        System.out.println("Reserving other vehicles");
    }
    @Override
    public void invoice() {
        System.out.println("Invoicing other vehicles");
    }
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
        return "Other{" + super.toString() +
                "additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
