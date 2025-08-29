package com.java.service;

import java.beans.Transient;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.Member;
import com.java.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerRepository customerRepository;
	//@PersistenceContext private EntityManager entityManager;
	
	@Override //게시글 전체가져오기
	public List<Board> findAll(Sort sort) {
		List<Board> list = customerRepository.findAll(sort);
		return list;
	}

	@Override
	public Board findByBno(int bno) {
		// .get():에러처리안함 .orElseGet():빈객체처리 .roElseThrow():예외처리
		Board board = customerRepository.findById(bno).orElseThrow(
		 () -> { 
			return new IllegalArgumentException("해당되는 게시글이 존재하지 않습니다."); 
		 }
		);
		
		return board;
	}

	@Override //게시글삭제
	public void deleteById(int bno) {
		customerRepository.deleteById(bno);
	}
	
	@Transactional
	@Override
	public void save(Board b) {
		
		Board board = customerRepository.save(b);
		b.setBgroup(b.getBno());
		b.setBdate(new Timestamp(System.currentTimeMillis()));
//		b.setBstep(0);
//		b.setBindent(0);
//		b.setBhit(0);
//		b.setBfile("");
		
//		entityManager.persist(b);
//		b.setBgroup(b.getBno());
//		b.setBstep(0);
//		b.setBindent(0);
//		b.setBhit(0);
//		b.setBfile("");
//		b.setBdate(new Timestamp(System.currentTimeMillis()));
//		customerRepository.save(b);
		
	}

}
