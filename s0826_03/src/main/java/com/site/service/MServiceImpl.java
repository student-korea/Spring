	package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.member;
import com.site.repository.MRepository;

@Service
public class MServiceImpl implements MService{
	@Autowired MRepository mRepository;
	
	@Override
	public member findByIdAndPw(member m) {
		String id = m.getId();
		String pw = m.getPw();
		member mem = mRepository.findByIdAndPw(id, pw).orElseGet(
				() -> {return new member();}
		);
		
//		member mem = mRepository.findByIdAndPw(id,pw).orElseThrow(
//				() -> {return new IllegalArgumentException("예외발생-데이터가 없음");} 
//				); 
		return mem;
	}

}
