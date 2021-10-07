package com.soya.yacode.blog.board.service.impl;

import com.soya.common.util.CustomBeanUtils;
import com.soya.yacode.blog.board.repository.BoardRepo;
import com.soya.yacode.blog.board.service.BoardService;
import com.soya.yacode.blog.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.board.service.impl
 * 3. 작성일     : 2021. 09. 30. 오후 12:13
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepo boardRepo;

    @Override
    public Page<BoardVO> selectAll(Pageable pageable, String searchTitle) {
        Page<BoardVO> boardVOS = boardRepo.findAllByBdTitleContaining(pageable, searchTitle);
        return boardVOS;
    }

    @Override
    public void insert(BoardVO boardVO) {

        if (boardVO != null) {
            boardRepo.save(boardVO);
        }

    }

    @Override
    public BoardVO selectOne(Integer bdNo) {
        BoardVO boardVO = boardRepo.findByBdNo(bdNo);
        return boardVO != null ? boardVO : new BoardVO();
    }

    @Override
    public void update(BoardVO boardVO) {

        if (boardVO != null) {
            BoardVO boardVO1 = this.selectOne(boardVO.getBdNo());
            if (boardVO1 != null) {
                CustomBeanUtils.copyProperties(boardVO, boardVO1);
            }
        }
    }
}
