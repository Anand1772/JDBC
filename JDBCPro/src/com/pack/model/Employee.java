package com.pack.model;

import java.util.Date;

public class Employee {
	private int id;
	private String name;
	private float salary;
	private Date dob;
	private String desig;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(int id, float salary, String desig) {
		super();
		this.id = id;
		this.salary = salary;
		this.desig = desig;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public Employee(int id, String name, float salary, Date dob, String desig) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.desig = desig;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id) {
		super();
		this.id = id;
	}

}
