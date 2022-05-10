package org.zerock.controller.ex05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("heroList", new String[] {"ironman", "spiderman", "torr"});
	}
}
