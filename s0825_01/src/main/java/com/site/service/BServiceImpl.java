package com.site.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.BoardMapper;
import com.site.dto.Board;

@Service
public class BServiceImpl implements BService{
	@Autowired BoardMapper boardMapper;
	
	@Override //게시글 전체가져오기
	public Map<String, Object> findAll(int page) {
//		1. 총 게시글 수 ( countAll ) : select해서 가져옴.
//		2. 현재 페이지 ( page ) : 링크로 넘어옴
//		3. 최대 페이지 ( maxpage ) : (int)Math.ceil((double)countAll/rowPerpage 총게시글수 / rowPerpage = 소수점올림 
//		4. 첫 페이지 ( startpage ) : ((page-1)/10)*10+1 
//		5. 마지막 페이지 ( endpage ) : startpage+10-1 = 10
		// 하단넘버링 관련
		int rowPerpage = 10; //1page에 10개의 게시글을 출력
		int countAll = boardMapper.findByCount();
		int maxpage = (int)Math.ceil((double)countAll/rowPerpage);
		int startpage = ((page-1)/10)*10+1; //1,11,21,31,...
		int endpage = startpage+10-1; //10,20,30,....
		if(maxpage<endpage) endpage = maxpage;
		// 1페이지당 가져와야 할 row개수
		int startrow = (page-1)*rowPerpage+1; //1 , 
		int endrow = startrow+rowPerpage-1;   //10
		
		System.out.println("BServiceImpl 게시글 전체개수 : "+countAll);
		List<Board> list = boardMapper.findAll(startrow,endrow);
		
		//리턴해야 할 것 : countAll,maxpage,startpage,endpage,page,list
		Map<String, Object> map = new HashMap<>();
		map.put("countAll", countAll);
		map.put("maxpage", maxpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("page", page);
		map.put("list", list);
		return map;
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

	@Override
	public void update(Board b) {
		boardMapper.update(b);
		
	}

	@Override
	public List<Board> findByCaAndsW(String category, String sWord) {
		List<Board> list = boardMapper.findByCaAndsW(category,sWord);
		return list;
	}

}
