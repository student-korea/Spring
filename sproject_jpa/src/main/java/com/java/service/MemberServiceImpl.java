package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired MemberRepository memberRepository;
	
	@Override
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberRepository.findByIdAndPw(id,pw);
		return member;
	}

	@Override
	public Member findById(String id) {
		Member member = memberRepository.findById(id).orElseGet(
				()->{return new Member();}
		);
		return member;
	}

}
