package com.spring.mvcPt.board.controller;
//08월28~29일 23시~24시34분 boardDetail 까지 구현완료 소요 1시간34분
//addBoard 파일데이터 추가 오류
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvcPt.board.dto.BoardDTO;
import com.spring.mvcPt.board.service.BoardService;

@Controller
public class BoardController {
	

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/addBoard")
	public ModelAndView addBoard() throws Exception{
		return new ModelAndView("board/addBoard");
		
	}
	
	@PostMapping("/addBoard")
	@ResponseBody
	public String addBoard(@ModelAttribute BoardDTO boardDTO) throws Exception{
		
		boardService.addBoard(boardDTO);
		
		String  jsScript = "<script>";
				jsScript += "alert('Post Added');";
				jsScript +=	"location.href='boardList';";
				jsScript += "</script>";
		
		return jsScript;
		
	}
	
	@GetMapping("/boardList")
	public ModelAndView boardList() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardList");
		mv.addObject("boardList", boardService.getBoardList());
		
		
		return mv;
		
		
	}
	
	@GetMapping("/boardDetail")
	public ModelAndView boardDetail(@RequestParam("boardId") long boardId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardDetail");
		mv.addObject("boardDTO", boardService.getBoardDetail(boardId));
		
		
		return mv;
		
	}
	
	
	
}
