package fr.wcs.blablawild;

public class VehicleBoat extends VehicleAbstract {

    int hours;

    public VehicleBoat(String brand, String model, int hours) {
        super(brand, model);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s, %s", getBrand(), getModel(), getHours());
    }
}
