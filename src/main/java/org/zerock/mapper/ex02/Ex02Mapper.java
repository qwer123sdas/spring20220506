package org.zerock.mapper.ex02;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
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
	
	@Insert("INSERT INTO Customers "
			+ "(CustomerName, ContactName, City, Country, Address, PostalCode) "
			+ "VALUES (#{customerName}, #{contactName}, #{city}, #{country}, #{address}, #{postalCode})")   // 이떄는 java 빈의 get property
	int insertCustomer(CustomerDto customer); // insert한 갯수(지금은 1)를 넘겨줌
	
	@Insert("INSERT INTO Employees (LastName, FirstName, BirthDate, Photo, Notes) "
			+ "VALUES (#{lastName}, #{firstName}, #{birthDate}, #{photo}, #{notes})")
	int insertEmployee(EmployeeDto dto);

	
	@Select("SELECT LastName, FirstName, Photo, Notes FROM Employees ORDER BY EmployeeID")
	List<EmployeeDto> selectEmployees();

	
	
}
