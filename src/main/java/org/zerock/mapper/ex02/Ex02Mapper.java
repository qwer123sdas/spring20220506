package org.zerock.mapper.ex02;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.controller.ex03.Customer;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;

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

	
	@Select("SELECT EmployeeID id, LastName, FirstName,BirthDate, Photo, Notes FROM Employees ORDER BY EmployeeID")
	List<EmployeeDto> selectEmployees();
	
	@Select("SELECT CustomerID id, CustomerName, ContactName, Address, City, PostalCode Country "
			+ "FROM Customers "
			+ "ORDER BY CustomerID "
			+ "LIMIT #{page}, 10")
	List<CustomerDto> readCustomer(int page);
	@Select("SELECT COUNT(*) FROM Customers")
	int getTotal();

	
	// 
	@Select("SELECT CustomerID id, CustomerName, "
			+ "ContactName, "
			+ "Address, "
			+ "City, PostalCode, "
			+ "Country "
			+ "FROM Customers "
			+ "LIMIT #{from }, #{row }")  // 파라미터가 2개일 땐 안됨, 파라미터명이 변경됨. 그래서  @Param을 통해 유지시켜줘야함
	List<CustomerDto> listCustomerPage(@Param("from") int from, @Param("row") int row);
	
	@Select("SELECT COUNT(CustomerID) FROM Customers")
	int countCustomers();

	
	
	
}
