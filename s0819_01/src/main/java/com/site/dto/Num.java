package com.site.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Num {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
}
