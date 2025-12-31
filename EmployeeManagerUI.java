import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EmployeeManagerUI {
    private Company company;
    private Scanner scanner;

    public EmployeeManagerUI(){
        this.company = new Company();
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getIntInput("Choose option (0-7)");

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    removeEmployee();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    listAllEmployees();
                    break;

                case 6:
                    getEmployeeCount();
                    break;

                case 7:
                    searchByName();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice/input");
            }
        }

        scanner.close();
        System.out.println("Goodbye");
    }

    public void printMenu(){
        System.out.println("=== Employee Manager ===");
        System.out.println("1. Add Employee" + "\n" + "2. Remove Employee" + "\n" + "3. Search Employee by ID" + "\n" + "4. Update Employee" + "\n" + "5. List All Employees" + "\n" + "6. Total Employees" + "\n" + "7. Search Employee by Name" + "\n" + "0. Exit" + "\n");
    }

    public void addEmployee(){
        try {
            System.out.println("Enter Name:");
            String name = scanner.nextLine();

            if (name.trim().isEmpty()){
                System.out.println("Name cannot be empty");
                return;
            }

            System.out.println("Enter department:");
            String department = scanner.nextLine();

            System.out.println("Enter position:");
            String position = scanner.nextLine();

            System.out.println("Enter salary:");
            double salary = Double.parseDouble(scanner.nextLine());

            if (salary < 0){
                System.out.println("Salary cannot be negative");
                return;
            }

            System.out.println("Enter hire date (YYYY-MM-DD):");
            LocalDate hireDate = LocalDate.parse(scanner.nextLine());

            this.company.add(name, department, position, salary, hireDate);
            System.out.println("Employee added successfully" + "\n");
        }

        catch (NumberFormatException e) {
            System.out.println("Invalid salary. Please enter a number");
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use YYYY-MM-DD");
        }
    }

    public void removeEmployee(){
        int ID = getIntInput("Enter employee's ID to remove: ");
        this.company.remove(ID);
        System.out.println("Operation completed");
    }

    public void searchEmployee(){
        int ID = getIntInput("Enter employee's ID to search: ");
        this.company.searchEmployee(ID);
        System.out.println("\n");
    }

    public void updateEmployee(){
        int ID = getIntInput("Enter employee's ID:" + "\n");

        System.out.println("Enter employee's new name:");
        String newName = scanner.nextLine();

        System.out.println("Enter employee's new department:");
        String newDepartment = scanner.nextLine();

        System.out.println("Enter employee's new position");
        String newPosition = scanner.nextLine();

        double newSalary = getDoubleInput("Enter employee's new salary: " + "\n");

        boolean success = this.company.updateEmployee(ID, newName, newDepartment, newPosition, newSalary);

        if (success){
            System.out.println("Update was successful");
        } else {
            System.out.println("Update failed");
        }
    }

    public void listAllEmployees(){
        this.company.printAllEmployees();
    }

    public void getEmployeeCount(){
        System.out.println("Total Employee/s: " + this.company.getEmployeeCount());
    }

    public void searchByName(){
        System.out.println("Enter employee's name to search: ");
        String name = scanner.nextLine();
        this.company.searchByName(name);
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}
