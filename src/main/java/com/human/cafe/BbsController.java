package com.human.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.human.service.IF_TestService;
import com.human.service.IF_boardService;
import com.human.util.FileDataUtil;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;
import com.human.vo.TestVO;

@Controller
public class BbsController {
	@Inject
	private IF_boardService bsrv;
	@Inject
	private IF_TestService tsrv;
	@Inject FileDataUtil fileDataUtil;
	
	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String WrAction(Locale locale, Model model,BoardVO bvo, MultipartFile[] file) throws Exception {
		// 객체로 받을 때는 파라미터이름과 객체의 변수의 이름이 일치하고 getter와 setter가 있어야 한다. > 자동매핑
		System.out.println(bvo.getName()+" -- 디버깅 용도");
		//System.out.println(file.getOriginalFilename()+"파일첨부 디버깅");
		// filedatautil 객체의 fileupload메서드를 호출 .. 매개변수로 file을 넘긴다.. <지정한 폴더로 첨부파일 복사>
		String[] fileNames = fileDataUtil.fileUpload(file);
		//System.out.println(fileNames[0]+"디비에 저장될 파일명.");
		// 넘겨받은 파일명을 boardVO files변수에 저장한다.
		bvo.setFiles(fileNames);
		// 디비작업..
		bsrv.insertOne(bvo);
		//System.out.println(fileNames[0]+" 이 디비에 자장됨 파일명"+fileNames[1]);
		return "redirect:/bbsList";
	}
	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public String bbsList(Locale locale, Model model, @ModelAttribute("pageVO") PageVO pageVO) throws Exception {
		// page 계산하기 위해서는 첫번째 페이지정보(클라이언트가 념겨줍니다), 두번째는 전체페이지수, 세번째는 페이지당 그리고 페이지그룹당 수
		JOptionPane.showMessageDialog(null, "zzzz");
		if(pageVO.getPage() == null) {
			pageVO.setPage(1);
		}
		System.out.println("현재 페이지 정보 : "+pageVO.getPage());
		
		int totalpageCnt = bsrv.countBoard();	// select count(*) from board_s;
		
		System.out.println(totalpageCnt+"건 등록됨.");
		pageVO.setTotalCount(totalpageCnt);
		List<BoardVO> list = bsrv.selectAll(pageVO);
		//System.out.println(list.size()+"건 가져옴. 디버깅용");
		model.addAttribute("bList",list);
		model.addAttribute("pageVO",pageVO);	//페이지 객체를 뷰에게 전달
		return "bbs/bbsList";
	}
	@RequestMapping(value = "/wrForm", method = RequestMethod.GET)
	public String wrForm(Locale locale, Model model) {
		// 객체로 받을 때는 파라미터이름과 객체의 변수의 이름이 일치하고 getter와 setter가 있어야 한다. > 자동매핑
		return "bbs/wrForm";
	}
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Locale locale, Model model) {
		// 객체로 받을 때는 파라미터이름과 객체의 변수의 이름이 일치하고 getter와 setter가 있어야 한다. > 자동매핑
		return "joinForm";
	}
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Locale locale, Model model, TestVO tvo) throws Exception {
		// 객체로 받을 때는 파라미터이름과 객체의 변수의 이름이 일치하고 getter와 setter가 있어야 한다. > 자동매핑
		tsrv.test_insert(tvo);
		return "home";
	}
	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String bbsView(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception{
		// 객체로 받을 때는 파라미터이름과 객체의 변수의 이름이 일치하고 getter와 setter가 있어야 한다. > 자동매핑
		//DB작업
		bsrv.updatecnt(vno);
		BoardVO tmpvo = bsrv.selectOne(vno);
		model.addAttribute("boardVO", tmpvo);
		List<String> attachList = bsrv.selectAttach(vno);
		model.addAttribute("attachList", attachList);
		return "bbs/bbsview";
	}
	@RequestMapping(value = "/bbsDel", method = RequestMethod.GET)
	public String bbsDel(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception{
		bsrv.boardDel(vno);
		return "redirect:bbsList";
	}
	@RequestMapping(value = "/bbsMod", method = RequestMethod.GET)
	public String bbsMod(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception{
		BoardVO tmpvo = bsrv.selectOne(vno);
		model.addAttribute("boardVO", tmpvo);
		return "bbs/bbsmod";
	}
	@RequestMapping(value = "/bbsModAction", method = RequestMethod.POST)
	public String bbsModAction(Locale locale, Model model,BoardVO bvo,MultipartFile[] file) throws Exception{
		bsrv.updateBoard(bvo);
		return "redirect:bbsView?vno="+bvo.getNum();
	}
}