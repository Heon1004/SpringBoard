package com.toyprj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyprj.model.BoardVO;
import com.toyprj.model.Criteria;
import com.toyprj.model.PageMakerDTO;
import com.toyprj.service.BoardService;

/*@Controller 어노테이션의 경우 해당 클래스를 스프링의 빈으로 인식하도록 하기 위함이고, 
@RequestMapping("/board/*")의 경우 '/board'로 시작하는 
모든 처리를 BoardController.java 가 하도록 지정하는 역할을 합니다.*/

@Controller
@RequestMapping("/customer/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService bservice;

	@GetMapping("/list")
	// => @RequestMapping(value="list", method=RequestMethod.GET)
	public void boardListGET(Model model, Criteria cri) {
		log.info("게시판 목록 페이지 진입");
		
		model.addAttribute("list", bservice.getListPaging(cri));
		int total = bservice.getTotal();
        model.addAttribute("pageMaker", new PageMakerDTO(cri, total));
	}

	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("掲示板投稿ページへ");
	}

	/* 게시판 등록 */
	@PostMapping("/enroll")
	// RedirectAttributesをパラメータで追加し、화면으로 이동시에 등록 성공 여부를 알리는 문자를 같이 전송하기 위함
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {

		log.info("投稿する");
		bservice.enroll(board);

		// 데이터 전송을 위한 메서드로서 addFlashAttribute()을 사용한 이유는 일회성으로만 데이터를 전달하기 위함
		rttr.addFlashAttribute("sysmsg", "enrol success");

		return "redirect:/customer/board/list";

	}
	 /* 게시판 조회 */
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model) {
        
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
    @PostMapping("/modifyPage")
    public void boardModifyGET(int bno, Model model) {
        
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
    /* 페이지 수정 */
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
        
        bservice.modify(board);
        
        rttr.addFlashAttribute("sysmsg", "modify success");
        
        return "redirect:/customer/board/list";
        
    }
    
    @PostMapping("delete")
    public String boardDeletePOST(int bno, RedirectAttributes rttr) {
    	bservice.delete(bno);
    	rttr.addFlashAttribute("sysmsg", "delete success");
    	
    	return "redirect:/customer/board/list";
    }
    
    
}
