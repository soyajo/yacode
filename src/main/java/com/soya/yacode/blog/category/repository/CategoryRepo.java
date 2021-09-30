package com.soya.yacode.blog.category.repository;

import com.soya.yacode.blog.category.vo.CategoryVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.category.repository
 * 3. 작성일     : 2021. 09. 30. 오후 12:22
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Repository
public interface CategoryRepo extends JpaRepository<CategoryVO,Integer> {


}
