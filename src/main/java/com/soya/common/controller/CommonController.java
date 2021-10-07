package com.soya.common.controller;

import com.soya.common.vo.BaseVO;
import com.soya.common.vo.RedirectVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 */

@Controller
@RequestMapping("/common")
public class CommonController extends BaseVO {

    @RequestMapping("/redirect.html")
    public String AlertAndRedirect(HttpServletRequest request, HttpServletResponse response, Model model) {

        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        RedirectVO redirectVO = null;
        if (flashMap != null) {
            redirectVO = flashMap.get("redirectVO") == null ? null : (RedirectVO) flashMap.get("redirectVO");
        }

        String message = "";
        String url = "/";
        String murl = "";
        String ourl="";
        if (redirectVO != null) {
            if (StringUtils.isNotEmpty(redirectVO.getMessage())) {
                message = redirectVO.getMessage().trim();
            }
            if (StringUtils.isNotEmpty(redirectVO.getUrl())) {
                url = redirectVO.getUrl().trim();
            }
            if (StringUtils.isNotEmpty("murl")) {
                murl = redirectVO.getMurl();
            }
            if(StringUtils.isNotEmpty(redirectVO.getOpenerUrl())){
                ourl = request.getContextPath() + redirectVO.getOpenerUrl();
            }
            if(StringUtils.isEmpty(redirectVO.getMode())){
                redirectVO.setMode(RedirectVO.MODE_REDIRECT);
            }
        }

        String returl = request.getContextPath() + url;


        model.addAttribute("mode", redirectVO.getMode());
        model.addAttribute("url", returl);
        model.addAttribute("message", message);
        model.addAttribute("murl", murl);
        model.addAttribute("openerReload", redirectVO.openerReload);
        model.addAttribute("winClose",redirectVO.winClose);
        model.addAttribute("ourl",ourl);
        return "common/redirect/redirect";
    }

}
