package com.site.service;


import java.util.List;

import com.site.dto.Member;

public interface MService {

	Member findByIdAndPw(String id, String pw);

	List<Member> findAll();

	Member findAndId(String id);

}
