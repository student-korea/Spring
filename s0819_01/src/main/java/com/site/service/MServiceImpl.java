package com.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.site.dto.Member;

@Service
public class MServiceImpl implements MService{
	
	static List<Member> list = new ArrayList<>();
	{
		list.add(new Member("aaa", "1111", "Eric", "010-1111-1111", "남자", "게임,골프"));
		list.add(new Member("bbb", "2222", "Hina", "010-2222-2222", "여자", "수영,독서"));
		list.add(new Member("ccc", "3333", "Rei", "010-3333-3333", "여자", "수영,조깅"));
	}
	public Member selectOne() {
		return list.get(0);
	}
	
	public List<Member> selectAll(){
		return list;
	}
	
	@Override
	public void insertOne(Member member) {
		list.add(member);
	}
}
