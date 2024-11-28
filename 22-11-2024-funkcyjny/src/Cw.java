import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String surname;
    private int salary;
    private String position;

    public Employee(int id, String name, String surname, int salary, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}

public class Cw {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Imie1", "nazwisko1", 1500, "LOW"),
                new Employee(2, "Imie2", "nazwisko2", 3000, "MID"),
                new Employee(3, "Imie3", "nazwisko3", 4300, "MID"),
                new Employee(4, "Imie4", "nazwisko4", 5000, "HIGH"),
                new Employee(5, "Imie5", "nazwisko5", 2000, "LOW")
        );

        employees.stream()
                .filter(e -> e.getSalary() > 4000 && e.getSalary() < 5000)
                .filter(e -> "MID".equals(e.getPosition()))
                .peek(e -> e.setSalary(4800))
                .map(Employee::getId)
                .forEach(System.out::println);


        System.out.println("====");

        employees.forEach(System.out::println);
    }
}
