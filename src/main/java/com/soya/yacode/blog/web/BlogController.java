package com.soya.yacode.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.web
 * 3. 작성일     : 2021. 09. 30. 오후 3:42
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @GetMapping(value = "/index.html")
    public String index() {


        return "blog/index";
    }
}
