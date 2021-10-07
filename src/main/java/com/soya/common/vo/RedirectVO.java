package com.soya.common.vo;


import lombok.*;

/**
 * 1. 프로젝트명 : sales
 * 2. 패키지명   : com.fourfree.sales.common.service
 * 3. 작성일     : 2018. 07. 16. 오전 10:38
 * 4. 작성자     : 고병만
 * 5. 이메일     : scormrte@gmail.com
 * 6  연락처     : 010-8299-5258
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class RedirectVO extends BaseVO {

    public static final String URL_ALERT_AND_REDIRECT = "redirect:/common/redirect.html";
    public static final String URL_ALERT_AND_PARENT_REDIRECT = "redirect:/common/parent_redirect.html";
    public static final String MSG_OK = "정상 처리 되었습니다.";

    public static final String MODE_REDIRECT = "redirect";
    public static final String MODE_PREDIRECT = "predirect";

    //메시지
    private String message;

    //리텐 url
    private String url;
    //리턴 url 이후 리턴될 url ex) 로그인 이후 -> 이동할 페이지 처리
    private String murl;
    //부모 -> redirect url
    private String openerUrl;

    //리다이렌트 유형
    @Builder.Default
    private String mode="redirect";

    @Builder.Default
    public boolean openerReload=false;

    @Builder.Default
    public boolean winClose=false;
}
