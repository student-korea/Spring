package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	private int bno;
	private String btitle;
	private String bcontent;
	private String id;
	
	private int bgroup;
	private int bstep;
	private int bindent;
	
	private String bhit;
	private String bfile;
	private Timestamp bdate;
}
