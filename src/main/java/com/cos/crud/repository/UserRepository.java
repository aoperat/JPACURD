package com.cos.crud.repository;

import java.lang.annotation.Native;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.crud.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	//JpaRepository <모델, 아이디의 타입>
	//JpaRepository = CRUD 를 구현해주는 클래스 /naming 규칙 생성

	User findByEmailAndPassword(String email, String password);
}


//조회수를 증가시키고 싶다면
//@Native("쿼리문입력")
//void increaseCount(int id);


//void findByCount(int count);
//void findByPhone(int phone);
//void findByPhoneAndPassword(int phone, String password);