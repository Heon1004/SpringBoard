package com.toyprj.mapper;

import java.util.List;

import com.toyprj.model.BoardVO;
import com.toyprj.model.Criteria;

public interface BoardMapper {
	
	/* 작가 등록 */
	public void enroll(BoardVO board);
	/* 掲示板リスト */
	public List<BoardVO> getList();
	/* 掲示板参照 */
	public BoardVO getPage(int bno);
	public int modify(BoardVO board);
	public int delete(int bno);
	/* 게시판 목록(페이징 적용) */
    public List<BoardVO> getListPaging(Criteria cri);
    public int getTotal();
   
}
