package com.cos.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.crud.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	
	

}
