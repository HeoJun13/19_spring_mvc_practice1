package com.spring.mvcPt.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvcPt.board.dao.BoardDAO;
import com.spring.mvcPt.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void addBoard(BoardDTO boardDTO) {
		
	}

	@Override
	public List<BoardDTO> getBoardList() throws Exception {

		return boardDAO.selectListBoard();
	}

	@Override
	public BoardDTO getBoardDetail(long boardId) {
		
		boardDAO.getBoardDetail(boardId);
		
		return boardDAO.selectOneBoard(boardId);
	}

}
