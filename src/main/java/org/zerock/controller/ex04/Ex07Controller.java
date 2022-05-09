package org.zerock.controller.ex04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex07")
public class Ex07Controller {
	@RequestMapping("sub01")
	public String method01() {
		// 1. request 파라미터 수집 / 가공
		// 메소드 파라미터에 잘 넣으면 됨.
		
		// 2. bussiness 로직 처리
		
		// 3. attribute 추가
		
		// 4. forward / redirect
		// redirect 하는 방법
		// return "redirect:";
		return "redirect:https://www.naver.com";
	}
	@RequestMapping("sub02")
	public String method02() {
		// /ex07/sub02에서 /ex06/sub01로 redirect하기
		
		// 메소드의 파라미터에 httpservlet으로 request, response을 받고,,, method(httpServeltReqeust requset, httServletResponse response)
		// String location = request.getContextPath() + "/ex06/sub01"; response.sendRedirect(location);으로 했었음
		return "redirect:/ex06/sub01";
	}
	
	@RequestMapping("sub04")
	public String method03() {
		// ex06/ sub05로 리디렉션하는 코드 작성
		return "redirect:/ex06/sub05";
	}
}
