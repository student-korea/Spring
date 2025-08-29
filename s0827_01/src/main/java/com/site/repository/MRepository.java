package com.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.dto.Member;

@Repository
public interface MRepository extends JpaRepository<Member, String>{

	Optional<Member> findByIdAndPw(String id, String pw);
	
	@Query(value = "select * from member where id=? and pw=?",nativeQuery = true)
	Optional<Member> findLogin(String id, String pw);
		
}
