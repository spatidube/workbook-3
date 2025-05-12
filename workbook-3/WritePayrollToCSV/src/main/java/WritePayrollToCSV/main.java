import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

class Employee {
    private int id;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int id, String name, double hoursWorked, double payRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getGrossPay() { return hoursWorked * payRate; }
}

class WritePayrollToCSV {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice Smith", 40, 25));
        employees.add(new Employee(2, "Bob Johnson", 38, 30));
        employees.add(new Employee(3, "Charlie Rose", 42, 28));

        try (PrintWriter writer = new PrintWriter(new FileWriter("payroll.csv"))) {
            writer.println("ID,Name,Gross Pay");
            for (Employee e : employees) {
                writer.printf("%d,%s,%.2f\n", e.getId(), e.getName(), e.getGrossPay());
            }
            System.out.println("Payroll written to payroll.csv");
        } catch (Exception e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}
