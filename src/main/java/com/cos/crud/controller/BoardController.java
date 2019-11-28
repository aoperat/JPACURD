package com.cos.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.service.BoardService;
import com.cos.crud.utils.Script;

@Controller
public class BoardController {

	@Autowired
	private BoardService mService;

	@PostMapping("/ict/{id}")
	public @ResponseBody String increaseCountAndTimeUpdate(@PathVariable int id) {
		mService.increaseCountAndTimeupdate(id);
		
		return "테스트 완료";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model) {

		List<Board> boards = mService.boardList();
		model.addAttribute("boards", boards);
		return "board/list";
	}

	@GetMapping("/board/detail/{id}")
	public String boardDetail(@PathVariable int id, Model model) {
		// 세션있어야함
		Board board = mService.boardDetail(id);
		model.addAttribute("board", board);
		return "board/detail";
	}

	@GetMapping("/board/writeForm")
	public String boardWriteForm() {
		// 인터셉터 AOP 처리 - 관점지향 프로그래밍
		return "/board/writeForm";

	}

	@PostMapping("/board/write")
	public String boardWrite(Board board, HttpSession session) {
		int result = mService.boardWrite(board, session);
		if (result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/writeForm";
		}

	}

	@DeleteMapping("/board/delete/{id}")
	public @ResponseBody String boardDelete(@PathVariable int id) {
		int result = mService.boardDelete(id);
		if(result == 1) {
			return Script.href("/board/list");
		}else {
			return Script.back("삭제 실패");
		}
		
	}

	@GetMapping("/board/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id, Model model) {
		Board board = mService.boardUpdateForm(id);
		model.addAttribute("board", board);
		return "board/updateForm";
	}

	@PutMapping("/board/update")
	public @ResponseBody String boardUpdate(Board board) {

		int result = mService.boardUpdate(board);
		if(result==1) {
			return Script.href("/board/list");
		}
			return Script.back("수정실패");
	}

}
