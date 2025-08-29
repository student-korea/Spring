package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //getter,setter
@Builder            //부분생성자
@AllArgsConstructor //전체생성자
@NoArgsConstructor  //기본생성자
//@DynamicInsert 
@Entity             //jpa사용
@SequenceGenerator(
		name="board_seq_generator",
		sequenceName = "board_seq",
		initialValue = 101,
		allocationSize = 1 //메모리
		)
public class Board {
	
	@Id //기본키 - oracle : sequence사용
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "board_seq_generator") //DB제공되는 넘버링전략을 따라감.
	private int bno;
	@Column(nullable = false,length = 1000)
	private String btitle;
	@Lob  // oracle CLOB타입 : 4Gbyte 대용량TEXT타입 -> varchar2(4000) 4Kbyte제한
	private String bcontent;
	
	//Jpa 장점 : 객체사용 -> DB는 객체를 사용할수 없음.
	@ManyToOne(fetch = FetchType.EAGER)      // 1명 Member는 여러개 게시글을 사용할수 있음.
	@JoinColumn(name="id")  // id를 board테이블에서 Foreign key등록을 시켜줌
	private Member member; 
	
	//답변달기
	@ColumnDefault("0")
	private int bgroup;
	@ColumnDefault("0")
	private int bstep;
	@ColumnDefault("0")
	private int bindent;
	
	@ColumnDefault("0")
	private int bhit;
	@Column(length = 100)
	private String bfile;
	@CreationTimestamp
	private Timestamp bdate;

}
