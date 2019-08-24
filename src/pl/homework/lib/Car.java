package pl.homework.lib;

public class Car {
    private String type;
    private String brand;
    private String model;
    private int annual;
    private int mileage;
    private int vinNumber;

    public Car() {
    }

    public Car(String type, String brand, String model, int annual, int mileage, int vinNumber) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.annual = annual;
        this.mileage = mileage;
        this.vinNumber = vinNumber;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnnual() {
        return annual;
    }

    public void setAnnual(int annual) {
        this.annual = annual;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", annual=" + annual +
                ", mileage=" + mileage +
                ", vinNumber=" + vinNumber +
                '}';
    }

    public String toCSV() {
        return type+";"+brand+";"+model+";"+annual+";"+mileage+";"+vinNumber+"\n";
    }
}
