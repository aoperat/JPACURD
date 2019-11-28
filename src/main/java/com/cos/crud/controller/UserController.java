package com.cos.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.User;
import com.cos.crud.repository.UserRepository;
import com.cos.crud.utils.Script;

@Controller
public class UserController {

	@Autowired
	private UserRepository mRepo;
	
	//사용자가 원하는 데이터 = 나의 정보를 10번 찎어달라고함.
	@GetMapping("/user/{id}")
	public @ResponseBody List<User> getUser(@PathVariable int id) {
		
		List<User> users = new ArrayList<User>();
		
		for (int i = 0; i < 10; i++) {
			users.add(mRepo.findById(id).get());
		}
		
		return users;
	}
	//getUser(@requestParam int id) 입력시
	
	@PostMapping("/user/login")
	public @ResponseBody String userLogin(User user, HttpSession session, HttpServletResponse response) { //세션을 첫 파라메터에 입력
		User u = mRepo.findByEmailAndPassword(user.getEmail(),user.getPassword());
		
		if (u != null) {
			session.setAttribute("user", u);
			return Script.href("/");
		} else {
			return Script.back("로그인 실패");
		}
	}

	@GetMapping("/user/loginForm")
	public String userLoginForm() {
		return "user/loginForm";
	}

	@PostMapping("/user/join")
	public String userJoin(User user) {
//		user.setId(1);
		mRepo.save(user);
		
		return "redirect:/";
	}

	@GetMapping("/user/joinForm")
	public String userJoinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/user/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

//User user = mRepo.FindByUsername(user.getId());