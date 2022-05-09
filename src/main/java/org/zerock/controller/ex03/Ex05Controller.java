package org.zerock.controller.ex03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex05")
public class Ex05Controller {
	
	// /ex05/sub01?name=jin&age=11&address=seoul
	@RequestMapping("sub01")
	public void method01(HttpServletRequest request) {
		// 1. reuqest 파라미터 수집/ 가공
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		String address = request.getParameter("address");
		
		Customer cus = new Customer();
		cus.setName(name);
		cus.setAge(age);
		cus.setAddress(address);
			
		System.out.println(cus);
		// 2. bussiness 로직 처리
		// dao.insert(cus);
		// 3. add attribute
		
		// 4. forward / redirect
	}
	
	@RequestMapping("sub02")
	public void method02(Customer cus) {
		System.out.println(cus);
	}
	
	@RequestMapping("sub03")
	public void method03(@ModelAttribute Customer cus) {
		System.out.println(cus);
	}
	
	@RequestMapping("sub04")
	public void method04(Computer com) {
		System.out.println(com);
	}
	
	@RequestMapping("sub05")
	public void method05(Employee emp) {
		System.out.println(emp);
	}
}
