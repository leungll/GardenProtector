package com.nenusoftware.gardenprotector.service.comment;

import com.nenusoftware.gardenprotector.entity.comment.Comment;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/14 11:07
 */
public interface CommentService {

    public boolean addComment(Comment comment) throws Exception;

    public List<Comment> listComment(int article_id) throws Exception;

    public boolean updateComment(Comment comment) throws Exception;

    public boolean delComment(int id) throws Exception;

    public boolean giveLike(int id, int liked) throws Exception;

    public List<Comment> getCommentLike (int id) throws Exception;
}
