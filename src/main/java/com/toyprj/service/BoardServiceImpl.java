package com.toyprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyprj.mapper.BoardMapper;
import com.toyprj.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void enroll(BoardVO board) {
		
		mapper.enroll(board);
		
	}

}
