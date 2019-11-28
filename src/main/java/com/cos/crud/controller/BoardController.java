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
import com.cos.crud.repository.BoardRepository;
import com.cos.crud.utils.Script;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository mRepo;

	@GetMapping("/board/list")
	public String boardList(Model model) {
		List<Board> boards = mRepo.findAll();
		model.addAttribute("boards", boards);
		return "board/list";
	}

	@GetMapping("/board/detail/{id}")
	public String boardDetail(@PathVariable int id, Model model) {
		//세션있어야함
		Optional<Board> board = mRepo.findById(id);
		model.addAttribute("board",board.get());
		return "board/detail";
	}

	@GetMapping("/board/writeForm")
	public String boardWriteForm() {
		// 인터셉터 AOP 처리 - 관점지향 프로그래밍
		return "/board/writeForm";
		
	}

	@PostMapping("/board/write")
	public String boardWrite(Board board, HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		board.setUser(user);
		mRepo.save(board);
		return "redirect:/board/list";
		
	}

	@DeleteMapping("/board/delete/{id}")
	public String boardDelete(@PathVariable int id) {
		mRepo.deleteById(id);
		return "redirect:/board/list";
	}

	@GetMapping("/board/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id,Model model) {
		Optional<Board> board = mRepo.findById(id);
		//세션있어야함
		model.addAttribute("board", board.get());
		return "board/updateForm";
	}

	@PutMapping("/board/update")
	public String boardUpdate(Board board) {
		
		mRepo.save(board);
		//세션있어야함
		return "redirect:/board/list";
	}

}
