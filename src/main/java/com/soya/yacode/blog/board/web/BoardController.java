package com.soya.yacode.blog.board.web;

import com.soya.common.controller.BaseController;
import com.soya.common.util.PageUtil;
import com.soya.common.vo.BaseVO;
import com.soya.common.vo.RedirectVO;
import com.soya.yacode.blog.board.service.BoardService;
import com.soya.yacode.blog.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.board.web
 * 3. 작성일     : 2021. 09. 30. 오후 12:13
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Controller
@RequestMapping(value = "/blog/board")
public class BoardController extends BaseController {

    @Autowired
    BoardService boardService;

    @GetMapping(value = "/list.html")
    public String list(Model model, @PageableDefault(size = 10) Pageable pageable, String searchTitle) {
        if (searchTitle == null) {
            searchTitle = "";
        }

        Page<BoardVO> boardVOS = boardService.selectAll(pageable, searchTitle);
        PageUtil pageUtil = new PageUtil(boardVOS);

        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("boardVOS", boardVOS.getContent());
        model.addAttribute("searchTitle", searchTitle);

        return "blog/board/list";
    }

    @GetMapping(value = "/insert.html")
    public String insert(Model model, BoardVO boardVO , Integer bdNo) {
        if (bdNo == null) {
            bdNo = 0;
        } else {
            boardVO = boardService.selectOne(bdNo);
        }
        model.addAttribute("bdNo", bdNo);
        model.addAttribute("BoardVO", boardVO);
        return "blog/board/insert";
    }

    @PostMapping(value = "/insertAction.html")
    public String insertAction(BoardVO boardVO, RedirectAttributes redirectAttributes) {

        if (boardVO.getBdNo() == null) {
            boardService.insert(boardVO);
        } else {
            BoardVO boardVO1 = boardService.selectOne(boardVO.getBdNo());
            if (boardVO1.getBdNo() != null) {
                boardService.update(boardVO);
            } else {
                boardService.insert(boardVO);
            }
        }
        RedirectVO redirectVO = new RedirectVO();
        redirectVO.setUrl("/blog/board/view.html?bdNo="+boardVO.getBdNo());
        redirectVO.setMessage(RedirectVO.MSG_OK);
        redirectAttributes.addFlashAttribute("redirectVO",redirectVO);
        return RedirectVO.URL_ALERT_AND_REDIRECT;
    }

    @GetMapping(value = "view.html")
    public String view(Model model, @RequestParam("bdNo") Integer bdNo) {

        /**
         * textarea 개행 처리 방법
         * https://solbel.tistory.com/1476
         */
        String nlString = System.getProperty("line.separator").toString();
        model.addAttribute("nlString",nlString);

        BoardVO boardVO = boardService.selectOne(bdNo);
        model.addAttribute("BoardVO", boardVO);
        model.addAttribute("bdNo", bdNo);

        return "blog/board/view";
    }


}
