package com.pack.service;

import java.util.List;

import com.pack.dao.EmployeeDAO;
import com.pack.model.Employee;

public class EmployeeBO {
public static int insertEmployee(Employee e) throws Exception
{
	int i=EmployeeDAO.insertEmployee(e);
	return i;
}
public static int updateEmployee(Employee e)throws Exception
{
	int i=EmployeeDAO.updateEmployee(e);
	return i;
}
public static int deleteEmployee(int num) throws Exception
{
	int i=EmployeeDAO.deleteEmployee(num);
	return i;
}
public static List<Employee> fetchEmployee()throws Exception
{
	List<Employee> l=EmployeeDAO.fetchEmployee();
	return l;
}
}
