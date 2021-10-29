package com.company.stream;


import java.util.*;

import java.util.stream.Stream;

public class EmpMain {
    public static class EmployeeNotFoundException extends Exception{
        private static final long serialVersionUID = 1L;

        public EmployeeNotFoundException() {
            super();

        }

        public EmployeeNotFoundException(String message) {
            super(message);

        }
    }

    public static void main(String[] args) {
        //Adding Employees to list
        List<Employee> EmplList = Arrays.asList(
                new Employee("james", "vijayawada", 21),
                new Employee("sara", "bangalore", 22),
                new Employee("karim", "hyderabad", 23),
                new Employee("veera", "vijayawada", 24),
                new Employee("ganesh", "hyderabad", 25));

        //All the employees
        System.out.println("All the employees :");
        System.out.println("");
        for (Employee emps : EmplList) {
            System.out.println(emps);
        }
        System.out.println("");
        System.out.println("Enter the city to filter Employees based on their cities: ");
        //Employees based on city
        Scanner input = new Scanner(System.in);
        String in = input.next();

        Stream<Employee> basedOnCity = EmplList.stream()
                .filter(p -> p.city.equalsIgnoreCase(in));  // filtering city

        //Iteration
        Iterator<Employee> it = basedOnCity.iterator();
        while (it.hasNext()) {
            Employee city = it.next();
            System.out.println(city);
        }

        //Sorting by employee name
        System.out.println("");
        Collections.sort(EmplList, Comparator.comparing(emp -> emp.name));
        for (Employee emps : EmplList) {
            System.out.println(emps);
        }

        //Getting employee by Id
        try {
            System.out.println("");
            System.out.println("Enter the Id to get Employees based on their Id: ");

            int innn = input.nextInt();
            Stream<Employee> Id = EmplList.stream()
                    .filter(p -> p.getEmpid() == innn);

            if(Id.findAny().isPresent()){
                Iterator<Employee> it2 = Id.iterator();
                while (it2.hasNext()) {
                    Employee id = it2.next();
                    System.out.println(id);
                }

            }else{
                throw new EmployeeNotFoundException("Employee not found");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Employee Empl;
            Empl = EmplList.stream()
                    .filter(employee -> employee.getName().startsWith("k"))
                    .findFirst().orElseThrow(() -> new Exception("No Employee with starting with K "));

            System.out.println(" ");

            System.out.println(Empl);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
