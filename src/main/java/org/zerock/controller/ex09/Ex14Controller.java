package org.zerock.controller.ex09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.ex03.Customer;
import org.zerock.domian.ex01.CustomerDto;
import org.zerock.domian.ex01.EmployeeDto;
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
	
	// /ex14/sub03?id=3
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		CustomerDto dto = service.getCustomerInfoById(id);
		
		model.addAttribute("customer", dto);
		
	}
	
	// ex14/sub04?id=7
	// 직원의 First NAme , LastName이 모두 Jsp로 출력되도록
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		EmployeeDto dto = service.getEmployeeFullName(id);
		model.addAttribute("employee", dto);
	}
	
	@RequestMapping("sub041")
	public String method041(int id, Model model) {
		String fullName = service.getEmployeeFullNameTest(id);
		model.addAttribute("fullName", fullName);
		
		return "ex14/sub04";
	}
	
	@RequestMapping("sub042")
	public String method042(int id, Model model) {
		String birthDate = service.getLocalDate(id);
		model.addAttribute("birthDate", birthDate);
		
		return "ex14/sub04";
	}
	
	// insert 하는방법
	@GetMapping("sub05")
	public void method05() {
		// form있는 jsp로 forward만 하기
	}
	
	@PostMapping("sub05")
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		// 1.
		// System.out.println(customer);
		// Customer객체에 자동으로 set함
		// 2. 
		boolean ok = service.addCustomer(customer);
		
		// 3. 
		if(ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		}else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		// 4.
		return "redirect:/ex14/sub05";
	}
	
	// 새 직원 입력해보는 것 만들기
	@GetMapping("sub06")
	public void method07(Model model) {
		List<EmployeeDto> list = service.getRead();
		model.addAttribute("employee", list);
	}
	
	@PostMapping("sub06")
	public String method08(EmployeeDto dto, RedirectAttributes rttr) {
		boolean ok = service.setEmployee(dto);
	    
	    
		if(ok) {
			rttr.addFlashAttribute("message", "등록완료");
		}else {
			rttr.addFlashAttribute("message", "등록실패");
		}
		
		return "redirect:/ex14/sub06";
	}
	
	
}
