package com.soya.common.vo;

import lombok.*;

/**
 * 1. 프로젝트명 : sapp
 * 2. 패키지명   : com.fourfree.common.vo
 * 3. 작성일     : 2020. 10. 14. 오후 1:03
 * 4. 작성자     : 고병만
 * 5. 이메일     : scormrte@gmail.com
 * 6  연락처     : 010-8299-5258
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class TermVO extends BaseVO {
    //년도
    private String year;

    //텀
    private String term;

    //텀 - 시작일자
    private String stdate;
    //텀 - 종료일자
    private String eddate;

    //텀코드
    private String termcode;

    public String getTermcode() {
        return year + "-" + (Integer.parseInt(term) < 10 ? "0"+term : term);
    }
}
