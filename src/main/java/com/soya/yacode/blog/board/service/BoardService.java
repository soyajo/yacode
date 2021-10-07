package com.soya.yacode.blog.board.service;

import com.soya.yacode.blog.board.vo.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.board.service
 * 3. 작성일     : 2021. 09. 30. 오후 12:12
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface BoardService {


    Page<BoardVO> selectAll(Pageable pageable, String searchTitle);

    void insert(BoardVO boardVO);

    BoardVO selectOne(Integer bdNo);

    void update(BoardVO boardVO);
}
