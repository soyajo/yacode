package com.soya.yacode.blog.comment.vo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.soya.common.vo.BaseVO;
import com.soya.yacode.blog.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
public class CommentVO extends BaseVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cmtNo;

    private Integer cmtSecNo;

    @Column(columnDefinition = "TEXT")
    private String cmtContents;

    private Date regDate;

    private Integer bdNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, insertable = false, name = "bdNo")
    @JsonBackReference
    private BoardVO boardVO;

    private Integer cmt_depth;

    private Integer cmt_order;
}
