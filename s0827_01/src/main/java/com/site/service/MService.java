package com.site.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.site.dto.Member;

public interface MService {

	Member findById(String id);

	Member findByIdAndPw(String id, String pw);

	List<Member> findAll();

	void save(Member m);

	void delete(String id);

	Page<Member> findAll(Pageable pageable);

}
