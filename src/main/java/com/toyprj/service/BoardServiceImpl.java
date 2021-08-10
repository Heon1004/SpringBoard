package com.toyprj.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyprj.mapper.BoardMapper;
import com.toyprj.model.BoardVO;
import com.toyprj.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void enroll(BoardVO board) {
		
		mapper.enroll(board);
		
	}

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}

	@Override
	public BoardVO getPage(int bno) {
		
		return mapper.getPage(bno);
	}

	@Override
	public int modify(BoardVO board) {
		
		return mapper.modify(board);
	}

	@Override
	public int delete(int bno) {
		
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListPaging(cri);
	}

	@Override
	public int getTotal() {
		
		return mapper.getTotal();
	}

}
