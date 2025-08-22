package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.BoardMapper;
import com.site.dto.Board;

@Service
public class BServiceImpl implements BService{
	@Autowired BoardMapper boardMapper;
	
	@Override
	public List<Board> findAll() {
		List<Board> board = boardMapper.findAll(); 
		return board;
	}

	@Override
	public Board findByBno(int bno) {
		Board b = boardMapper.findByBno(bno);
		return b;
	}

	@Override
	public void save(Board board) {
		boardMapper.save(board);
		
	}

	@Override
	public void delete(int bno) {
		boardMapper.delete(bno);
		
	}

}
