package org.zerock.controller.ex10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ex02.BoardDto;
import org.zerock.domain.ex02.ReplyDto;
import org.zerock.service.ex03.Ex05Service;
import org.zerock.service.ex03.Ex06Service;

@Controller
@RequestMapping("ex15")
public class E15Controller {  	// 게시판 컨트롤러

	@Autowired
	private Ex05Service service;
	
	@Autowired
	private Ex06Service replyService;
	E15Controller(){}
	/*
	 * @Autowired E15Controller(Ex05Service service){ this.service = service; }
	 */
	
	@RequestMapping("sub01")
	public String method01(int id, Model model) {
		String name = service.getCustomerNameById(id);
		model.addAttribute("name", name);
		return "/ex14/sub01";
	}
	
	@RequestMapping("sub02")
	public String method02(int id, Model model) {
		String firstName = service.getEmployeeFirstnameById(id);
		model.addAttribute("firstName", firstName);
		
		return "/ex14/sub01";
	}
	
	// /ex15/board/list
	@GetMapping("board/list")
	public void listBoard(Model model) {
		List<BoardDto>list = service.listBoard();
		model.addAttribute("boardList", list);
		//System.out.println(list.size());
	}
	
	
	// {id} : 경로 변수(path variable)
	@GetMapping("board/{id}")
	public String getBoard(@PathVariable("id") int id, Model model) {
		//System.out.println(id);
		// 서비스 일 시켜서  id에 해당하는 게시물 select해서 모델에 넣고
		BoardDto boardDto = service.getBoard(id);
		model.addAttribute("boardDto", boardDto);
		
		// 댓글작성한 내용 보이게 하는 메서드
		List<ReplyDto> replyList = replyService.listReplyByBoardId(id);
		model.addAttribute("replyList", replyList);
		// board/get.jsp로 forward
		return "/ex15/board/get";
	}
	
	@PostMapping("board/modify")
	public String modifyBoard(BoardDto board) {
		boolean success = service.updateBoard(board);
		if(success) {
			
		}else {
			
		}
		
		return "redirect:/ex15/board/" + board.getId();
	}
	
	@PostMapping("board/remove")
	public String removeBoard(int id) {
		boolean success = service.removeBoardById(id);
		
		if(success) {
			
		}else {
			
		}
		
		return "redirect:/ex15/board/list";
	}
	
	@GetMapping("board/write")
	public void writeBoard() {
		
	}
	@PostMapping("board/write")
	public String writeBoardPorcess(BoardDto boardDto) {
		// insert하고 insert한 컬럼의 id를 boardDto에 저장함.
		boolean success = service.addBoardboardDto(boardDto);
		
		if(success) {
			
		}else {
			
		}
		
		return "redirect:/ex15/board/" + boardDto.getId();
	}
}
