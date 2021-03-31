package com.springstudy.bbs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.bbs.dao.BoardDao;
import com.springstudy.bbs.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private static final int PAGE_SIZE = 10;

	private static final int PAGE_GROUP = 10;

	@Autowired
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map<String, Object> boardList(int pageNum) {

		int currentPage = pageNum;

		int startRow = (currentPage - 1) * PAGE_SIZE;

		int listCount = boardDao.getBoardCount();

		List<Board> boardList = boardDao.boardList(startRow, PAGE_SIZE);

		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);

		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);

		int endPage = startPage + PAGE_GROUP - 1;

		if (endPage > pageCount) {
			endPage = pageCount;
		}

		Map<String, Object> modelMap = new HashMap<String, Object>();

		modelMap.put("boardList", boardList);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("listCount", listCount);
		modelMap.put("pageGroup", PAGE_GROUP);

		return modelMap;
	}

	@Override
	public Board getBoard(int no, boolean isCount) {
		return boardDao.getBoard(no, isCount);
	}

	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}

	public boolean isPassCheck(int no, String pass) {
		return boardDao.isPassCheck(no, pass);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int no) {
		boardDao.deleteBoard(no);
	}
}
