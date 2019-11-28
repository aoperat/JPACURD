package com.cos.crud.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository mRepo;
	
	@Transactional
	public void increaseCountAndTimeupdate(int id) {
		
		try {
			mRepo.increaseCount(id);
			mRepo.timeUpdate(id);	
		} catch (Exception e) {
			System.out.println("increaseCountAndTimeupdate 오류");
			throw new RuntimeException(e);
		}
		
	}
	
	

	
	//DB관련로직만 서비스에 필요하다.
	public List<Board> boardList() {
		List<Board> boards = mRepo.findAll();
		
		return boards;
	}

	public Board boardDetail(int id) {
		//세션있어야함
		Optional<Board> board = mRepo.findById(id);
		return board.get();
	}


	public int boardWrite(Board board, HttpSession session) {
		
		try {
			User user = (User)session.getAttribute("user");
			board.setUser(user);
			mRepo.save(board);
			return 1;
		} catch (Exception e) {
			System.out.println("BoardWrite 오류");
			
		}
		return -1;
		
	}

	public int boardDelete(int id) {
		try {
			mRepo.deleteById(id);
			return 1;
		} catch (Exception e) {
			System.out.println("boardDelete 오류");
		}
		return -1;
	}

	public Board boardUpdateForm(int id) {
		Optional<Board> board = mRepo.findById(id);
		return board.get();
	}

	public int boardUpdate(Board board) {
		try {
			mRepo.save(board);
			return 1;
		} catch (Exception e) {
			System.out.println("boardUpdate 오류");
		}
		return -1;
	}
}
