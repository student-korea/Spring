package com.site.service;

import java.util.List;
import java.util.Map;

import com.site.dto.Board;

public interface BService {

	Map<String, Object> findAll(int page);

	Board findByBno(int bno);

	void save(Board board);

	void delete(int bno);

	void update(Board b);

	List<Board> findByCaAndsW(String category, String sWord);
	
}
