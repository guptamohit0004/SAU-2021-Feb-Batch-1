package com.Hibernate.EmployeeManager;

import java.util.Scanner;

public class OutputMenu {
	Scanner sch = new Scanner(System.in);
	public void printList() {
		System.out.println("Choose a option:\n1- Add Employee\n2- Update Employee\n3- Delete Employee- *This action cannot be undone\n4- Get All Employee\n5- Get Employee by ID\n6- Exit from the Panel ");
	}
	public void printChoice(){
		System.out.println("Enter Data to update:\n1- ID\n2-First Name\n3- Last Name\n4- DOB\n5- Designation\n6- Salary\n7- Age");
	}
	public Employee entChoice() {
		Employee e=new Employee();
		try {
		System.out.println("Please Enter Employee Details");
		System.out.println("Give First Name");
		e.setFname(sch.nextLine());
		System.out.println("Give Last Name");
		e.setLname(sch.nextLine());
		System.out.println("Give Designation");
		e.setDesignation(sch.nextLine());
		System.out.println("Give Date of Birth");
		e.setDob(sch.nextLine());
		System.out.println("Give Salary");
		e.setSalary(sch.nextInt());
		System.out.println("Give ID");
		e.setId(sch.nextInt());
		System.out.println("Give Age");
		e.setAge(sch.nextInt());
		sch.nextLine();
	}
	catch (Exception e1) {
		System.out.println(e);
	}
		return e;
	}

}
