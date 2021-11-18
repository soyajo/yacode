package com.soya.yacode.blog.comment.service.impl;

import com.soya.common.util.CustomBeanUtils;
import com.soya.yacode.blog.category.service.CategoryService;
import com.soya.yacode.blog.comment.repository.CommentRepo;
import com.soya.yacode.blog.comment.service.CommentService;
import com.soya.yacode.blog.comment.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 1. 프로젝트명 : yacode
 * 2. 패키지명   : com.soya.yacode.blog.comment.service.impl
 * 3. 작성일     : 2021. 09. 30. 오후 12:31
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Override
    public void cmtInsert(CommentVO commentVO) {
        commentVO.setRegDate(new Date());

        if (commentVO != null && commentVO.getCmtSecNo() == null) {
            commentRepo.save(commentVO);
        } else if (commentVO != null && commentVO.getCmtSecNo() != null) {
            commentRepo.save(commentVO);
        }
    }

    @Override
    public CommentVO selectOne(Integer cmt_no) {
        if (cmt_no != null && !cmt_no.equals("")) {
            CommentVO commentVO = commentRepo.findByCmtNo(cmt_no);
            return commentVO;
        } else {
            return new CommentVO();
        }
    }

    @Override
    public CommentVO selectOne_sec(CommentVO commentVO) {
        return null;
    }

    @Override
    public List<CommentVO> selectAll_sec(CommentVO commentVO) {
        if (commentVO != null && commentVO.getCmtNo() != null && !commentVO.getCmtNo().equals("")) {
            List<CommentVO> commentVOS = commentRepo.findAllByCmtNoAndCmtSecNoIsNotNull(commentVO);

            return commentVOS;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Page<CommentVO> selectAll(Integer bdNo, Pageable pageable) {
        Page<CommentVO> commentVOS = commentRepo.findAllByBdNoOrderByCmtNoAscCmtSecNoAsc(bdNo, pageable);
//        List<CommentVO> plist = new ArrayList<>();
//        List<CommentVO> chlist = new ArrayList<>();
//        commentVOS.stream().forEach(c -> {
//            if (c.getCmtSecNo() == null) {
//
//
//            }
//        });


        if (commentVOS != null && commentVOS.getContent().size() > 0) {
            return commentVOS;
        } else {
            return null;
        }

    }

    @Override
    public void update(CommentVO commentVO) {
        if (commentVO != null && commentVO.getCmtNo() != null) {
            CommentVO commentVO1 = this.selectOne(commentVO.getCmtNo());
            if (commentVO1 != null) {
                CustomBeanUtils.copyProperties(commentVO, commentVO1);
            }
        }
    }

    @Override
    public void deleteOne(Integer cmtNo) {

        if (cmtNo != null) {
            commentRepo.deleteAllByCmtSecNo(cmtNo);
            commentRepo.deleteByCmtNo(cmtNo);
        }
    }
}
