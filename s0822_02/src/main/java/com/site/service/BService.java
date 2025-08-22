package com.site.service;

import java.util.List;

import com.site.dto.Board;

public interface BService {

	List<Board> findAll();

	Board findByBno(int bno);

	void save(Board board);

	void delete(int bno);

}
