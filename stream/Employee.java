package com.company.stream;

public class Employee {
    String name;
    String   city;
    int empid;

    public Employee() {
       super();
    }

    public Employee(String name, String city, int empid) {
        this.name = name;
        this.city = city;
        this.empid = empid;
    }

    public String getCity() {
        this.city=city;
        return city;
    }

    public String getName()
    {this.name=name;
        return name;
    }

    public int getEmpid() {
        return empid;
    }

    @Override
    public String toString() {

        return "Employee [Name = " + name + ", City = " + city + ", Employee Id = " + empid + "]";

    }



}
