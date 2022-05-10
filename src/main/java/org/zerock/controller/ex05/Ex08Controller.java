package org.zerock.controller.ex05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex08")
public class Ex08Controller {
	@RequestMapping("sub01")
	public String method(HttpServletRequest req) {
		req.setAttribute("address", "new tyour");
		// full view name : /WEB-INF/views/ex08/sub01.jsp
		
		return "ex08/sub01";
	}
	@RequestMapping("sub02")
	public String method02(Model model) {
		model.addAttribute("address", "london");
		return "ex08/sub01";
	}
	
	@RequestMapping("sub03")
	public String method03(Model model) {
		model.addAttribute("myName", "홍길동");
		model.addAttribute("myAge", 30);
		return "ex08/sub03";
	}
	
	@RequestMapping("sub04")
	public void method04(Model model) {
		model.addAttribute("foods", new String[] {"apple", "milk", "coffee"});
		// void 요청경로 : /ex08/sub04
	}
	
	@RequestMapping("sub05")
	public void method05(Model model) {
		List<String> list = new ArrayList<>();
		list.add("토르");
		list.add("스파이더맨");
		list.add("아쿠아맨");
		model.addAttribute("heroList",list);
	}
	
	@RequestMapping("sub06")
	public void method06(Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "jin");
		map.put("song", "butter");
		map.put("group", "bts");
		
		model.addAttribute("desc", map);
	}
	
	@RequestMapping("sub07")
	public void method07(Model model) {
		Customer cus = new Customer();
		cus.setAddress("seoul");
		cus.setAge(30);
		cus.setName("donald");
		model.addAttribute("customer", cus);
	}
	
	@RequestMapping("sub08")
	public void method08(Model model) {
		Employee emp = new Employee();
		emp.setEmail("123@naver.com");
		emp.setName("donald");
		emp.setSalary(4000);
		
		model.addAttribute("employee", emp);
	}
	
	@RequestMapping("sub09")
	public String method09(Model model) {
		Employee emp = new Employee();
		emp.setEmail("korea@daum.net");
		emp.setName("sunja");
		emp.setSalary(70000);
		
		// attribute 이름이 클래스의 이름으로 결정된다.(단 lowerCamelCase 형식)
		// model.addAttribute("employee", emp);로 같은 형태
		model.addAttribute(emp);
		return "ex08/sub08";
	}
	
	@RequestMapping("sub10")
	public String method10(Model model) {
		Customer cus = new Customer();
		cus.setName("순자");
		cus.setAge(45);
		cus.setAddress("인천");
		model.addAttribute(cus);
		
		return "ex08/sub07";
	}
	
	@RequestMapping("sub11")
	public void  method11(Model model) {
		List<String> l = new ArrayList<>();
		
		l.add("wanda");
		l.add("doctor");
		l.add("wong");
		
		model.addAttribute("arrayList", l);
		// model.addAttribute(l);
	}
	
	@RequestMapping("sub12")
	public void method12() {
		// 1. reuqest 파라미터 수집 가공
		// 2. bussiness 로직처리
		// 3. attribute 추가
		// model.addAttribute();
		// 4. forward / redirect
	}
}
