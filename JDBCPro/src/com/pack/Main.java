package com.pack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.pack.model.Employee;
import com.pack.service.EmployeeBO;
public class Main
{	
	public static void main(String args[])throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("###Employee###");
		System.out.println("Menu");
		System.out.println("1. Add Employee");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. View");
		System.out.println("5. Exit");
		int ch; String name="";int id;
		float sal=0.0f; String dob="",desig="";
		do
		{
			System.out.println("enter choice");
			ch=sc.nextInt();
			sc=new Scanner(System.in);
			switch(ch)
			{
			case 1:
				System.out.println("Enter Name - ");
				name=sc.nextLine();
				System.out.println("Enter salary - ");
				sal=Float.parseFloat(sc.nextLine());
				System.out.println("Enter DOB - ");
				dob=sc.nextLine();
				System.out.println("Enter Designation - ");
				desig=sc.nextLine();
				Random x=new Random();
				int num =x.nextInt(900000)+100000;
				SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
				sdf.setLenient(false);     //wrong i/p then it will throw a exception
				Date d=null;
				try
				{
					d=sdf.parse(dob);
				}
				catch(ParseException p)
				{
					System.out.println(p);
				}
				Employee e=new Employee(num,name,sal,d,desig);
				int i=EmployeeBO.insertEmployee(e);
				if(i==1)
					System.out.println("Employee inserted successfully !");
				else
					System.out.println("unsuccessful insert ");
				break;
			case 2:
				System.out.println("enter emp id");
				id=Integer.parseInt(sc.nextLine());
				System.out.println("enter the salary");
				sal=Float.parseFloat(sc.nextLine());
				System.out.println("enter designation");
				desig=sc.nextLine();
			    Employee e1=new Employee(id,sal,desig);
			    int i1=EmployeeBO.updateEmployee(e1);
			    if(i1==1)
			    	System.out.println("Update succesfully");
			    else
			    	System.out.println("failed to update");
				break;
			case 3:
				System.out.println("enter emp id");
				id=Integer.parseInt(sc.nextLine());
				//Employee e2=new Employee(id);
				int i2= EmployeeBO.deleteEmployee(id);
				if(i2==1)
			    	System.out.println("Deleted succesfully");
			    else
			    	System.out.println("failed to delete");
				break;
			case 4:
				List<Employee> l = EmployeeBO.fetchEmployee();
				//for(Employee yu:l)
				//{
				/*	System.out.println(yu.getId());
					System.out.println(yu.getName());
					System.out.println(yu.getSalary());
					System.out.println(yu.getDesig());
					System.out.println();
					*/
					System.out.format("%-10s %-25s %-10s %-10s %-10s","EmployeeId","Employee Name","Salary","Date Birth","Designation");
					System.out.println();
					System.out.println("___________________________________________________________________________________________________");
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
					for(Employee y:l)
					{
						System.out.println();
						System.out.format("%-10s %-25s %-10s %-10s %-20s",y.getId(),y.getName(),y.getSalary(),sdf1.format(y.getDob()),y.getDesig());
						
					}
					System.out.println();
				//}
				break;
			case 5:
				System.out.println("THANK YOU FOR USING");
				System.exit(0);
				break;
			default :
				System.out.println("invalid");
			}
		}
			while(ch!=0 && ch<5);
		
		sc.close();
	}
}
