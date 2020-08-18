package ru.geekbrains.java1.lesson4;

public class MainClass {
    private static Employee[] employees;
    public static void main(String[] args){
        Employee person1 = new Employee("Kondratev","Roman", "Aleksandrovich", "30.12.1989", 120000.00);
        //task 4
        System.out.println(person1.getFullName());
        //task 5
        employees = new Employee[]{new Employee("Vladimirov", "Igor", "Vladimirovich", "14.06.1990", 10000.00),
                new Employee("Julykova", "Marina", "Ivanovna", "12.03.1997", 120000.00),
                new Employee("Kostyleva", "Irina", "Olegovna", "18.03.1992", 170000.00),
                new Employee("Sidorov", "Oleg", "Ivanovich", "12.03.1960", 155600.00),
                new Employee("Ivanov", "Stepan", "Sergeevich", "12.03.1972", 1040.00),
        };
        salaryUp(45, 5000.00);
        showEmployees();
        System.out.println("Средний возраст сотрудников: " + averageAge(employees) + ", средняя звралвтв сотрудников: " + averageSalary(employees));
        System.out.println(person1.getEmployeeID());
        System.out.println(Employee.getCountID());
    }
    //task 6
    private static void salaryUp(int age, double diff){
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getAge() > age) employees[i].setSalary(employees[i].getSalary() + diff);
        }
    }

    //Show FIO + salary
    private static void showEmployees(){
        for (int i = 0; i < employees.length; i++){
            System.out.println(employees[i].getFullName() + ", salary: " + employees[i].getSalary());
        }
    }
    //task 7
    private static int averageAge(Employee[] employees){
        int age = 0;
        for (int i = 0; i < employees.length; i++){
            age+=employees[i].getAge();
        }
        return age/employees.length;
    }
    private static int averageSalary(Employee[] employees){
        int salary = 0;
        for (int i = 0; i < employees.length; i++){
            salary+=employees[i].getSalary();
        }
        return salary/employees.length;
    }
}
