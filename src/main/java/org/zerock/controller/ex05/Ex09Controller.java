package org.zerock.controller.ex05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex09")
public class Ex09Controller {
	@RequestMapping("sub01")
	public void method01(String name, Model model) {  // (@RequestParam String name)이라 ㅇ같음
		// 1. request 파라미터 수집 / 가공
		System.out.println(name);
		// 3. model에 attribute 추가
		model.addAttribute("name", name);
		// 4. view forward : ex09/sub01.jsp
	}
	
	@RequestMapping("sub02")
	public String method02(@ModelAttribute("name") String name) {
		return "ex09/sub01";
	}
	
	@RequestMapping("sub03")
	public void method03(@ModelAttribute("address") String address, 
			             @ModelAttribute("email") String email) {
	}
	
	// java beans
	// ex09/sub04?name=trump&address=newyork
	@RequestMapping("sub04")
	public void method04(@ModelAttribute("customer") Customer cus) {
		
	}
	
	@RequestMapping("sub05")
	public String method05(@ModelAttribute Customer cus) {
		return "ex09/sub04";
	}
	
	@RequestMapping("sub06")
	public String method06(Customer cus) {
		return "ex09/sub04";
	}
	
	// Employee 객체가 쿼리 스트링으로 넘어온 파라미터 값들을 세팅해서 model
	// model에 "emoloyee"라는 이름의 attribute로 추가되고 /ex09/sub07 뷰 포워드가 되도록 작성
	// ?name=sunja&salary=50000&email=sunja@gmail.com
	// 요청경로 : /ex09/sub07
	@RequestMapping("sub07")
	public void method07(Employee emp) {
	}
	/*
	public void method07(HttpServletRequest request) {
		String name = request.getParameter("name");
		String salaryStr = request.getParameter("salary");
		String email = request.getParameter("email");
		
		int salary = Integer.valueOf(salaryStr);
		
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setName(name);
		emp.setSalary(salary);
		
		request.setAttribute("employee", emp);
		request.getRequestDispatcher("/WEB-INF/views/ex09/sub07.jsp");
	}
	*/
}
