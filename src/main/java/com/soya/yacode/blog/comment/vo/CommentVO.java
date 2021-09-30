package com.soya.yacode.blog.comment.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.comment.vo
 * 3. 작성일     : 2021. 09. 30. 오후 12:32
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "comment")
public class CommentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cmtNo;

    private Integer cmtSecNo;

    @Column(columnDefinition = "TEXT")
    private String cmtContents;

}
