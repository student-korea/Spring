package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MRepository;
@Service
public class MServiceImpl implements MService{

	@Autowired MRepository mRepository;
	
	@Override
	public Member findById(String id) {
//		Member member = mRepository.findById(id).get();
		
		Member member = mRepository.findById(id).orElseGet(
				()->{return new Member();}
				);
		
//		Member member = mRepository.findById(id).orElseThrow(
//				()->{return new IllegalArgumentException();}
//				);
		return member;
	}
	
	@Override
	public Member findByIdAndPw(String id, String pw) {
		Member member = mRepository.findByIdAndPw(id,pw).orElseGet(
				()->{return new Member();}
				);
		return member;
	}

	@Override
	public List<Member> findAll() {
		List<Member> list = mRepository.findAll(Sort.by(Sort.Order.desc("gender"),Sort.Order.asc("name"))); //기본메소드 - Repository 메소드 필요없음.

//		Sort sort = Sort.by(Sort.Order.asc("gender"),Sort.Order.desc("name"));
//		List<Member> list = mRepository.findAll(sort);
		return list;
	}

	@Override
	public void save(Member m) {
		mRepository.save(m); //기본메소드 - Repository 메소드 필요없음.
		
	}

	@Override
	public void delete(String id) {
		Member member = mRepository.findById(id).get(); //검색
		mRepository.delete(member); //삭제
		
	}

	@Override
	public Page<Member> findAll(Pageable pageable) {
		Page<Member> list = mRepository.findAll(pageable);
		return list;
	}

}
