package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pack.JDBCConnection;
import com.pack.model.Employee;

public class EmployeeDAO {
	public static int insertEmployee(Employee e) throws Exception
	{
		Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("Insert into employee values(?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setFloat(3, e.getSalary());
		java.sql.Date d1=new java.sql.Date(e.getDob().getTime());
		ps.setDate(4, d1);
		ps.setString(5, e.getDesig());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public static int updateEmployee(Employee e) throws Exception
	{
		Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("update employee set salary=?,designation=? where id=?");
		ps.setFloat(1, e.getSalary());
		ps.setString(2, e.getDesig());
		ps.setInt(3, e.getId());
		
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public static int deleteEmployee(int number) throws Exception
	{
		Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from Employee where id=?");
		ps.setInt(1, number);
		int i=ps.executeUpdate();
		con.close();
		return i;
	
	}
	public static List<Employee> fetchEmployee() throws Exception
	{
		Connection con=JDBCConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		List<Employee> l = new ArrayList<>();  //dynamic method dispatch
		while(rs.next())
		{
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getFloat(3));
			java.sql.Date d2=new java.sql.Date(rs.getDate(4).getTime());
			e.setDob(d2);
			e.setDesig(rs.getString(5));
			l.add(e);
		}
		return l;
	}


}
