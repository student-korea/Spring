package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.site.dto.Member;

@Mapper  //자동으로 객체생성
public interface MemberMapper {

	//회원전체리스트
	List<Member> selectAll();

	Member selectOne();

	Member selectLogin(@Param("id") String id, @Param("pw") String pw);

}