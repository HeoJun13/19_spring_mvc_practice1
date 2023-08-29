package com.spring.mvcPt.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvcPt.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void insertBoard(BoardDTO boardDTO) throws Exception {
		
		sqlSession.insert("boardMappers.insertBoard" , boardDTO);
	}


	@Override
	public List<BoardDTO> selectListBoard() {
		
		return sqlSession.selectList("boardMappers.selectListBoard");
	}


	@Override
	public BoardDTO selectOneBoard(long boardId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void getBoardDetail(long boardId) {
		sqlSession.update("boardMappers.selectOneBoard" , boardId);
		
	}


	
}
