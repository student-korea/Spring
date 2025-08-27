package com.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.dto.member;

@Repository
public interface MRepository  extends JpaRepository<member,String>{

	Optional<member> findByIdAndPw(String id, String pw);
}
