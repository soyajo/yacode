package com.soya.yacode.blog.comment.repository;

import com.soya.yacode.blog.comment.vo.CommentVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.comment.repository
 * 3. 작성일     : 2021. 09. 30. 오후 12:31
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Repository
public interface CommentRepo extends JpaRepository<CommentVO, Integer> {


}
