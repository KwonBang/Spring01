package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_boardDAO;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Service
public class BoardServiceImpl implements IF_boardService{
	@Inject
	private IF_boardDAO boarddao;
	@Override
	public void insertOne(BoardVO boardvo) throws Exception {
		// TODO Auto-generated method stub
		//board table insert
		//board_attath table insert
		boarddao.insertOne(boardvo);
		String[] fname = boardvo.getFiles();
		if(fname!=null) {
			for(int i = 0;i<fname.length;i++) {
				if(fname[i]!=null) {
					boarddao.insertAttath(fname[i]);
				}
			}
		}
	}
	@Override
	public List<BoardVO> selectAll(PageVO pageVO) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectAll(pageVO);
	}
	@Override
	public int countBoard() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.countBoard();
	}
	@Override
	public BoardVO selectOne(String vno) throws Exception {
		
		return boarddao.selectOne(vno);
	}
	@Override
	public List<String> selectAttach(String vno) throws Exception {
		
		return boarddao.selectAttach(vno);
	}
	@Override
	public void updatecnt(String vno) throws Exception {
		boarddao.updateCnt(vno);
	}
	@Override
	public void boardDel(String vno) throws Exception {
		boarddao.boardDel(vno);
	}
	@Override
	public void updateBoard(BoardVO boardvo) throws Exception {
		boarddao.updateBoard(boardvo);
	}

}
