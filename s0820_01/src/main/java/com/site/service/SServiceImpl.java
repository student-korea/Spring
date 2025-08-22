package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.StuscoreMapper;
import com.site.dto.Stuscore;
@Service
public class SServiceImpl implements SService{
	
	@Autowired StuscoreMapper stuscoreMapper;
	@Override
	public List<Stuscore> selectAll() {
		List<Stuscore> list = stuscoreMapper.selectAll();
		return list;
	}
	
}
