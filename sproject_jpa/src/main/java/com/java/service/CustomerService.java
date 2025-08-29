package com.java.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.java.dto.Board;
import com.java.dto.Member;

public interface CustomerService {

	//게시글 전체가져오기
	List<Board> findAll(Sort sort);

	Board findByBno(int bno);
	
	void deleteById(int bno);

	void save(Board b);

}
