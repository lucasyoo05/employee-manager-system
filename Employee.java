import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private int ID;
    private String name;
    private String department;
    private String position;
    private double salary;
    private LocalDate hireDate;

    public Employee(int ID, String name, String department, String position, double salary, LocalDate hireDate){
        this.ID = ID;
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public String getDepartment(){
        return this.department;
    }

    public String getPosition(){
        return this.position;
    }

    public double getSalary(){
        return this.salary;
    }

    public LocalDate getHireDate(){
        return this.hireDate;
    }

    @Override
    public String toString(){
        return String.format("ID: %-3d | Name: %-20s | Dept: %-15s | Salary: $%,.2f",
                ID, name, department, salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID;  // Compare by ID only
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDepartment(String newDepartment){
        this.department = newDepartment;
    }

    public void setPosition(String newPosition){
        this.position = newPosition;
    }

    public void setSalary(double newSalary){
        this.salary = newSalary;
    }

}
