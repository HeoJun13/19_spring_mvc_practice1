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
	public List<BoardDTO> selectListBoard() throws Exception{
		
		return sqlSession.selectList("boardMappers.selectListBoard");
	}


	@Override
	public BoardDTO selectOneBoard(long boardId) throws Exception{
		return sqlSession.selectOne("boardMappers.selectOneBoard" , boardId);
	}


	@Override
	public void updateReadCnt(long boardId) throws Exception {
		sqlSession.update("boardMappers.updateReadCnt" , boardId);
	}




	

	
}
