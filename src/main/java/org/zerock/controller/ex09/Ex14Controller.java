package org.zerock.controller.ex09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.ex02.Ex04Service;

@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	
	@Autowired
	private Ex04Service service;
	
	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		// 1. request parameter 수집 / 가공 
		// 파라미터 값 적어주기
		
		// 2. 비지니스 로직 처리
		String name = service.getNamebyId(id);
		// 3. model.addAttribute
		model.addAttribute("name", name);
		// 4. forward / redirect
	}
	
	// view에서 Employee의 firstname이 출력되도록 controller.method02로 작성
	// serivce에도 메서드 추가
	// mapper에도 메소드 추가 하기
	@RequestMapping("sub02")
	public String method02(int id, Model model) {
		String firstName = service.getEmployeeFirstName(id);
		
		model.addAttribute("firstName", firstName);
		
		return "ex14/sub01";
	}
}
