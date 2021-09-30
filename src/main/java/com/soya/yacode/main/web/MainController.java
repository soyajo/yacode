package com.soya.yacode.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.main.web
 * 3. 작성일     : 2021. 09. 30. 오전 11:47
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Controller
@RequestMapping(value = {"/"})
public class MainController {


    public String index() {

        return "";
    }

}
