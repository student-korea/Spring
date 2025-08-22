package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.MemberMapper;
import com.site.dto.Member;

@Service
public class MServiceImpl implements MService{
	@Autowired MemberMapper memberMapper;
	
	@Override
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberMapper.findByIdAndPw(id,pw);
		return member;
	}

	@Override
	public List<Member> findAll() {
		List<Member> list = memberMapper.findAll();
		return list;
	}

	@Override
	public Member findAndId(String id) {
		Member member = memberMapper.findAndId(id);
		return member;
	}

}
