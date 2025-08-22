package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Stuscore;
@Mapper
public interface StuscoreMapper {

	List<Stuscore> selectAll();

}
