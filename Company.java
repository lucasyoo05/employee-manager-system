import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company {
    private List<Employee> employees;
    private int nextID;

    public Company(){
        this.employees = new ArrayList<>();
        this.nextID = 1;
    }

    public void add(String name, String department, String position, double salary, LocalDate hireDate){
        Employee employee = new Employee(this.nextID, name, department, position, salary, hireDate);

        this.employees.add(employee);

        this.nextID++;
    }

    public void remove(int ID) {
        Iterator<Employee> iterator = this.employees.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.getID() == ID) {
                iterator.remove();  // Safe removal via iterator
                return;
            }
        }
    }

    public void printAllEmployees(){
        for (Employee e : this.employees){
            System.out.println(e);
        }

        System.out.println("");
    }

    public void searchEmployee(int ID){
        boolean found = false;

        for(Employee e : this.employees){
            if (e.getID() == ID){
                System.out.println(e);
                found = true;
            }
        }

        if (!found){
            System.out.println("Employee not found");
        }
    }

    public boolean updateEmployee(int ID, String newName, String newDepartment, String newPosition, double newSalary){
        for (Employee e : this.employees) {
            if (e.getID() == ID) {
                e.setDepartment(newDepartment);
                e.setName(newName);
                e.setPosition(newPosition);
                e.setSalary(newSalary);
                return true;
            }
        }
        return false;
    }

    public int getEmployeeCount(){
        return this.employees.size();
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("No employees found with name: " + name);
    }
}
