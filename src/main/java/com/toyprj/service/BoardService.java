package com.toyprj.service;

import java.util.List;

import com.toyprj.model.BoardVO;

public interface BoardService {

	public void enroll(BoardVO board);
	public List<BoardVO> getList();
}
