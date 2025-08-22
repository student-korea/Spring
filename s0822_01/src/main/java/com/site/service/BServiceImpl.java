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
		List<Board> list = boardMapper.findAll();
		return list;
	}

	@Override
	public Board findByBno(int bno) {
		Board board = boardMapper.findByBno(bno);
		return board;
	}

}
