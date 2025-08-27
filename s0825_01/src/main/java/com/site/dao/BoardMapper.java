package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.site.dto.Board;

@Mapper
public interface BoardMapper {

	List<Board> findAll(@Param("startrow") int startrow, @Param("endrow") int endrow);

	Board findByBno(int bno);

	void save(Board board);

	void delete(int bno);

	void update(Board b);

	List<Board> findByCaAndsW(@Param("category") String category,
			@Param("sWord") String sWord);

	int findByCount();

}
