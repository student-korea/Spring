package com.java.service;

import com.java.dto.Member;

public interface MemberService {

	Member findByIdAndPw(String id, String pw);

	Member findById(String id);

}
