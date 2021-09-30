package com.soya.yacode.blog.category.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.category.vo
 * 3. 작성일     : 2021. 09. 30. 오후 12:22
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "category")
public class CategoryVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ctgrNo;

    @Column(columnDefinition = "TEXT")
    private String ctgrTitle;

}
