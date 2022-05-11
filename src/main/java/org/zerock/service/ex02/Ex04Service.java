package org.zerock.service.ex02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.zerock.controller.ex03.Customer;
import org.zerock.domian.ex01.CustomerDto;
import org.zerock.domian.ex01.EmployeeDto;
import org.zerock.mapper.ex02.Ex02Mapper;

import com.sun.scenario.effect.Blend.Mode;

@Service
public class Ex04Service {
	
	@Autowired
	private  Ex02Mapper mapper;
	
	public String getNamebyId(int id) {
		String name = mapper.selectNameById(id);
		return name;
	}

	public String getEmployeeFirstName(int id) {
		String firstName = mapper.selectFirstName(id);
		
		
		return firstName;
	}

	public CustomerDto getCustomerInfoById(int id) {
		return mapper.selectCustomerById(id);
	}

	//---------------------------------------------------
	public EmployeeDto getEmployeeFullName(int id) {
		return mapper.selectFullName(id);
	}

	public String getEmployeeFullNameTest(int id) {
		EmployeeDto dto = mapper.selectFullName(id);
		String firstName = dto.getFirstName();
		String lastName = dto.getLastName();
		LocalDate birthDate = dto.getBirthDate();
		
		return firstName + " " + lastName;
	}
	
	public String getLocalDate(int id) {
		EmployeeDto dto = mapper.selectFullName(id);
		LocalDate birthDate = dto.getBirthDate();
		String birthDateStr = birthDate.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
		return birthDateStr;
	}
	//----------------------------------------------------

}
