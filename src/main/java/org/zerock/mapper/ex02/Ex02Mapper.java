package org.zerock.mapper.ex02;

import org.apache.ibatis.annotations.Select;

public interface Ex02Mapper {
	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = #{id}")   // ?를 대신하는게 #{메소드 파라미터 }
	String selectNameById(int id);
	
	@Select("SELECT FirstName FROM Employees WHERE EmployeeId = #{id}")
	String selectFirstName(int id);

}
