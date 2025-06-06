public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    // Constructor
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // Getters and Setters for all fields

    @Override
    public String toString() {
        return vin + " | " + year + " | " + make + " " + model + " | " + vehicleType + " | " + color + " | " + odometer + " miles | $" + price;
    }
}
