package com.site.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Member;

public interface MService {
	List<Member> selectAll();

	Member selectOne();

	Member selectLogin(String id, String pw);
}
