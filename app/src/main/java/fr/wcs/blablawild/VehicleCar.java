package fr.wcs.blablawild;

public class VehicleCar extends VehicleAbstract {

    int kilometers;

    public VehicleCar(String brand, String model, int kilometers) {
        super(brand,model);
        this.kilometers = kilometers;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s, %s", getBrand(), getModel(), getKilometers());
    }
}
