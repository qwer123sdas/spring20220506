package org.zerock.mapper.ex02;

import org.apache.ibatis.annotations.Select;
import org.zerock.controller.ex03.Customer;
import org.zerock.domian.ex01.CustomerDto;
import org.zerock.domian.ex01.EmployeeDto;

public interface Ex02Mapper {
	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = #{id}")   // ?를 대신하는게 #{메소드 파라미터 }
	String selectNameById(int id);
	
	@Select("SELECT FirstName FROM Employees WHERE EmployeeId = #{id}")
	String selectFirstName(int id);
	
	@Select("SELECT CustomerName AS Name, Address, City, Country FROM Customers WHERE CustomerID = #{id}")
	CustomerDto selectCustomerById(int id);

	@Select("SELECT FirstName, LastName, BirthDate FROM Employees WHERE EmployeeId = #{id}")
	EmployeeDto selectFullName(int id);

	
}
