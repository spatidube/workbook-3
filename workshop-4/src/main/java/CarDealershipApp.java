// Vehicle.java
public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

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

    public int getVin() { return vin; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getVehicleType() { return vehicleType; }
    public String getColor() { return color; }
    public int getOdometer() { return odometer; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return vin + " | " + year + " | " + make + " " + model + " | " + vehicleType + " | " + color + " | " + odometer + " miles | $" + price;
    }
}

// Dealership.java
import java.util.*;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(int vin) {
        inventory.removeIf(v -> v.getVin() == vin);
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) result.add(v);
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) result.add(v);
        }
        return result;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) result.add(v);
        }
        return result;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) result.add(v);
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) result.add(v);
        }
        return result;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(type)) result.add(v);
        }
        return result;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}

// DealershipFileManager.java
import java.io.*;
        import java.util.*;

public class DealershipFileManager {
    private final String filename = "inventory.csv";

    public Dealership getDealership() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] dealerInfo = reader.readLine().split("\\|");
            Dealership dealership = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                Vehicle v = new Vehicle(
                        Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        data[2], data[3], data[4], data[5],
                        Integer.parseInt(data[6]),
                        Double.parseDouble(data[7])
                );
                dealership.addVehicle(v);
            }
            return dealership;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// UserInterface.java
import java.util.*;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager = new DealershipFileManager();

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> processPriceRequest(scanner);
                case 2 -> processMakeModelRequest(scanner);
                case 3 -> processYearRequest(scanner);
                case 4 -> processColorRequest(scanner);
                case 5 -> processMileageRequest(scanner);
                case 6 -> processTypeRequest(scanner);
                case 7 -> processAllVehiclesRequest();
                case 8 -> processAddVehicleRequest(scanner);
                case 9 -> processRemoveVehicleRequest(scanner);
                case 99 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 99);
    }

    private void init() {
        this.dealership = fileManager.getDealership();
    }

    private void displayMenu() {
        System.out.println("""
            1 - Find vehicles by price
            2 - Find vehicles by make/model
            3 - Find vehicles by year
            4 - Find vehicles by color
            5 - Find vehicles by mileage
            6 - Find vehicles by type
            7 - List all vehicles
            8 - Add a vehicle
            9 - Remove a vehicle
            99 - Quit
        """);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processPriceRequest(Scanner scanner) {
        System.out.print("Enter min price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter max price: ");
        double max = scanner.nextDouble();
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processMakeModelRequest(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processYearRequest(Scanner scanner) {
        System.out.print("Enter min year: ");
        int min = scanner.nextInt();
        System.out.print("Enter max year: ");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processColorRequest(Scanner scanner) {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processMileageRequest(Scanner scanner) {
        System.out.print("Enter min mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter max mileage: ");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    private void processTypeRequest(Scanner scanner) {
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processAddVehicleRequest(Scanner scanner) {
        System.out.println("Enter new vehicle details:");
        System.out.print("VIN: "); int vin = scanner.nextInt();
        System.out.print("Year: "); int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Make: "); String make = scanner.nextLine();
        System.out.print("Model: "); String model = scanner.nextLine();
        System.out.print("Type: "); String type = scanner.nextLine();
        System.out.print("Color: "); String color = scanner.nextLine();
        System.out.print("Mileage: "); int mileage = scanner.nextInt();
        System.out.print("Price: "); double price = scanner.nextDouble();

        Vehicle v = new Vehicle(vin, year, make, model, type, color, mileage, price);
        dealership.addVehicle(v);
        fileManager.saveDealership(dealership);
    }

    private void processRemoveVehicleRequest(Scanner scanner) {
        System.out.print("Enter VIN to remove: ");
        int vin = scanner.nextInt();
        dealership.removeVehicle(vin);
        fileManager.saveDealership(dealership);
    }
}

// Program.java
public class Program {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.display();
    }
}
