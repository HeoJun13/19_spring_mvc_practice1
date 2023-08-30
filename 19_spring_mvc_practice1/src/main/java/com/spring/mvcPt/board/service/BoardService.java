package com.spring.mvcPt.board.service;

import java.util.List;

import com.spring.mvcPt.board.dto.BoardDTO;

public interface BoardService {

	public void addBoard(BoardDTO boardDTO) throws Exception;

	public List<BoardDTO> getBoardList() throws Exception;

	public BoardDTO getBoardDetail(long boardId) throws Exception;





}
