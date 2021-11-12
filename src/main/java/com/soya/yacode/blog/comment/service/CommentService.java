package com.soya.yacode.blog.comment.service;

import com.soya.yacode.blog.comment.vo.CommentVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.comment.service
 * 3. 작성일     : 2021. 09. 30. 오후 12:30
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface CommentService {

    void cmtInsert(CommentVO commentVO);

    CommentVO selectOne(Integer cmt_no);

    CommentVO selectOne_sec(CommentVO commentVO);

    List<CommentVO> selectAll_sec(CommentVO commentVO);

    Page<CommentVO> selectAll(Integer bdNo , Pageable pageable);

    void update(CommentVO commentVO);

    void deleteOne(Integer cmtNo);
}
