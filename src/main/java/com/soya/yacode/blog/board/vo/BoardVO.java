package com.soya.yacode.blog.board.vo;

import com.soya.common.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.board.vo
 * 3. 작성일     : 2021. 09. 30. 오후 12:01
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "board")
public class BoardVO extends BaseVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bdNo;

    private String bdContents;

    private String bdTitle;

}
