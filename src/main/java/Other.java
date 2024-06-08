public class Other extends Car{
    private String additionalInformation; //pickup/motorcycle/...
    public Other(String type, String brand, String color, String licensePlate, boolean isRented, int rentedDays, int pricePerHour, String additionalInformation) {
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
