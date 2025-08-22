package com.site.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
}
