package com.soya.yacode.blog.board.repository;

import com.soya.yacode.blog.board.vo.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.board.repository
 * 3. 작성일     : 2021. 09. 30. 오후 12:12
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Repository
public interface BoardRepo extends JpaRepository<BoardVO, Integer> {


}
