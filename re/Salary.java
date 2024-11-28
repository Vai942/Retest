package com.re;
import java.util.Scanner;

abstract class Employee {
		abstract void setSalary(int salary);
		abstract int getSalary();

 
		abstract void setGrade(String grade);
		abstract String getGrade();

 
		void label() {
			System.out.println("Employee's data:");
 		}
}

class Engineer extends Employee {
 private int salary;
 private String grade;

 public Engineer(String grade, int salary) {
     this.grade = grade;
     this.salary = salary;
 }

 // Implementing the abstract methods
 @Override
 void setSalary(int salary) {
     this.salary = salary;
 }

 @Override
 int getSalary() {
     return salary;
 }

 @Override
 void setGrade(String grade) {
     this.grade = grade;
 }

 @Override
 String getGrade() {
     return grade;
 }
}

//Class Manager extends Employee
class Manager extends Employee {
 // Private attributes for salary and grade
 private int salary;
 private String grade;

 // Constructor to initialize Manager with grade and salary
 public Manager(String grade, int salary) {
     this.grade = grade;
     this.salary = salary;
 }

 // Implementing the abstract methods
 @Override
 void setSalary(int salary) {
     this.salary = salary;
 }

 @Override
 int getSalary() {
     return salary;
 }

 @Override
 void setGrade(String grade) {
     this.grade = grade;
 }

 @Override
 String getGrade() {
     return grade;
 }
}

//Main class to handle input/output and process the employees


public class Salary {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Read the number of employees
     int n = scanner.nextInt();
     scanner.nextLine(); // To consume the newline left after reading the integer

     // Array of Employee objects
     Employee[] employees = new Employee[n];

     // Loop to read employee data and create instances of Engineer or Manager
     for (int i = 0; i < n; i++) {
         String[] input = scanner.nextLine().split(" ");
         String type = input[0];
         String grade = input[1];
         int salary = Integer.parseInt(input[2]);

         // Depending on the type, create an Engineer or Manager
         if (type.equals("ENGINEER")) {
             employees[i] = new Engineer(grade, salary);
         } else if (type.equals("MANAGER")) {
             employees[i] = new Manager(grade, salary);
         }
     }

     // Print the details of each employee
     for (Employee employee : employees) {
         employee.label();
         System.out.println("GRADE: " + employee.getGrade());
         System.out.println("SALARY: " + employee.getSalary());
     }

     scanner.close();
 }
}
