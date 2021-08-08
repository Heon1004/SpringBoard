package com.toyprj.mapper;

import java.util.List;

import com.toyprj.model.BoardVO;

public interface BoardMapper {
	/* 작가 등록 */
	public void enroll(BoardVO board);
	
	public List<BoardVO> getList();
}
