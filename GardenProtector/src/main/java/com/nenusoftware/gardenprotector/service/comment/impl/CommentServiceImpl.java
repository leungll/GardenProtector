package com.nenusoftware.gardenprotector.service.comment.impl;

import com.nenusoftware.gardenprotector.entity.comment.Comment;
import com.nenusoftware.gardenprotector.mapper.comment.CommentMapper;
import com.nenusoftware.gardenprotector.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/14 11:07
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean addComment(Comment comment) throws Exception{
        return commentMapper.addComment(comment);
    }

    @Override
    public boolean delComment(int id) throws Exception{
        return commentMapper.delComment(id);
    }

    @Override
    public boolean updateComment(Comment comment) throws Exception{
        return commentMapper.updateComment(comment);
    }

    @Override
    public List<Comment> listComment(int article_id) throws Exception{
        List<Comment> list = Collections.emptyList();
        list = commentMapper.listComment(article_id);
        return list;
    }

    @Override
    public boolean giveLike(int id, int like) throws Exception{
        return commentMapper.giveLike(id, like);
    }

    @Override
    public List<Comment> getCommentLike(int id) throws Exception{
        List<Comment> list = Collections.emptyList();
        list = commentMapper.getCommentLike(id);
        return list;
    }
}
