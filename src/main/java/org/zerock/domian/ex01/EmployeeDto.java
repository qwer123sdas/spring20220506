package org.zerock.domian.ex01;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class EmployeeDto {
	private String id;
	private String firstName;
	private String lastName;
	
	// simple data type에는 LocalDate가 없기 떄문이다.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(iso = ISO.DATE) 국제 표준 양식
	private LocalDate birthDate;
	
	private String photo;
	private String notes;
}
