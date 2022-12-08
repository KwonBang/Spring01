package com.human.service;

import java.util.List;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

public interface IF_boardService {
	public void insertOne(BoardVO boardvo) throws Exception;	//컨트롤러에서 호출할 메서드
	public List<BoardVO> selectAll(PageVO pageVO) throws Exception;
	public int countBoard() throws Exception;
	public BoardVO selectOne(String vno) throws Exception;
	public List<String> selectAttach(String vno) throws Exception;
	public void updatecnt(String vno) throws Exception;
	public void boardDel(String vno) throws Exception;
	public void updateBoard(BoardVO boardvo) throws Exception;
	// 정의된 메서드는 컨트롤러가 호출하는 메서드이다.. 구현은 dao를 호출하는 메서드가 있을 것이다..
	// 이름을 동일하게 쓰는 이유는 가독성때문이다.. 가독성도 상대적입니다. 그래서 컨트롤러<> 서비스<> dao를 먼저 이해하고
	// 이 기반에서 가독성을 이해해야.. 가독성이 좋다는 의미를 이해할 수 있다..
}
