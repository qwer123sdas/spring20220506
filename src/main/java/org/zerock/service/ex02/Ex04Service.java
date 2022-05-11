package org.zerock.service.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.ex02.Ex02Mapper;

@Service
public class Ex04Service {
	
	@Autowired
	private  Ex02Mapper mapper;
	
	public String getNamebyId(int id) {
		String name = mapper.selectNameById(id);
		return name;
	}

	public String employeeFirstName(int id) {
		String FirstName = mapper.selectFirstName(id);
		return FirstName;
	}

}
