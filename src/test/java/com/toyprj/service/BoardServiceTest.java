package com.toyprj.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toyprj.mapper.BoardMapperTest;
import com.toyprj.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {

	private static final Logger log = LoggerFactory.getLogger(BoardMapperTest.class);
	
	@Autowired
	private BoardService service;

	/*
	 * @Test public void testEnroll() {
	 * 
	 * BoardVO vo = new BoardVO();
	 * 
	 * vo.setTitle("service test"); vo.setContent("service test");
	 * vo.setWriter("service test");
	 * 
	 * service.enroll(vo);
	 * 
	 * }
	 */
	
	/* 게시판 조회(페이징 적용) */
    @Test
    public void testGetListPaging() {
        
        Criteria cri = new Criteria();
        
        List list = service.getListPaging(cri);
        
        list.forEach(board -> log.info("" + board));
        
        
    }
}
