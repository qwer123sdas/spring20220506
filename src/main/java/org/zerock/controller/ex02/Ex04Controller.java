package org.zerock.controller.ex02;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex04")
public class Ex04Controller {
	@RequestMapping("sub01")
	public void method01(HttpServletRequest request) {
		System.out.println("/ex04/sub01 요청");
		// 1. request 파라미터 수집 가공
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("age"));
		// 2. bussiness logic 실행
		
		// 3. attribute 추가
		
		// 4. forward / redirect
	}
	
	
	// @ReqeustParam
	@RequestMapping("sub02")
	public void method02(@RequestParam("name") String n) {
		System.out.println(n);
	}
	@RequestMapping("sub03")
	public void method03(@RequestParam("name") String n, @RequestParam("age") String age) {
		System.out.println(n);
		System.out.println(age);
		int a = Integer.valueOf(age);
	}
	
	@RequestMapping("sub04")
	public void method04(@RequestParam("age") int age) {
		System.out.println(age);
	}
	
	@RequestMapping("sub05")
	public void method05(HttpServletRequest request) {
		//1. request parameter 수집/ 가공
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		
		int age = Integer.valueOf(ageStr);
		
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("sub06")
	public void method06(@RequestParam("name") String name, @RequestParam int age) {
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("sub07")
	public void method07(String name, int age) {
		System.out.println(name);
		System.out.println(age);
	}
	
	// http://localhost:8080/controller/ex04/sub08?address=seoul&number=300
	@RequestMapping("sub08")
	public void method08(String address, int number) {
		System.out.println(address); // seoul
		System.out.println(number);  // 300
	}
	
	// http://localhost:8080/controller/ex04/sub09?password=1q2w3e&number=10000
	@RequestMapping("sub09")
	public void method09(@RequestParam("password") String pw, @RequestParam("number") int num) {
		System.out.println(pw);  // 1q2w3e
		System.out.println(num);  // 10000
	}
	
	@RequestMapping("sub10")
	public void method10(@RequestParam(value = "name", required = true) String name) {
		System.out.println(name);
	}
	
	
	@RequestMapping("sub11")
	public void method11(HttpServletRequest request) {
		String[] foods = request.getParameterValues("food");
		System.out.println(Arrays.toString(foods));
	}
	@RequestMapping("sub12")
	public void method12(@RequestParam("food") String[] foods) {
		System.out.println(Arrays.toString(foods));
	}
	
	@RequestMapping("sub13")
	public void method13(String[] food) {
		System.out.println(Arrays.toString(food));
	}
	
	@RequestMapping("sub14")
	public void method14(@RequestParam("food") ArrayList<String> food) {
		System.out.println(food);
	}
}
