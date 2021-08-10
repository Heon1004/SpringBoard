package com.toyprj.service;

import java.util.List;

import com.toyprj.model.BoardVO;
import com.toyprj.model.Criteria;

public interface BoardService {

	public void enroll(BoardVO board);
	public List<BoardVO> getList();
	public BoardVO getPage(int bno);
	public int modify(BoardVO board);
	/* 게시판 목록(페이징 적용) */
    public List<BoardVO> getListPaging(Criteria cri);
	public int delete(int bno);
	public int getTotal();
}
