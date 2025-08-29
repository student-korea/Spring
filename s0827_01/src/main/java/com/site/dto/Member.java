package com.site.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {
	@Id
	private String id;
	@Column(nullable=false,length=50)
	private String pw;
	@Column(nullable=false,length=100)
	private String name;
	@Column(length=30)	
	private String phone;
	@ColumnDefault("'남자'")
	private String gender;
	@Column(length=100)	
	private String hobby;
	@CreationTimestamp
	private Timestamp mdate;
}
