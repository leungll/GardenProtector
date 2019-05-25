package com.nenusoftware.gardenprotector.mapper.comment;

import com.nenusoftware.gardenprotector.entity.comment.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/13 21:54
 */
@Mapper
@Repository
public interface CommentMapper {

    public boolean addComment(@Param("comment") Comment comment) throws Exception;

    public boolean delComment(@Param("id") int id) throws Exception;

    public boolean updateComment(@Param("comment") Comment comment) throws Exception;

    public List<Comment> listComment(@Param("article_id") int article_id) throws Exception;

    public boolean giveLike(@Param("id") int id, @Param("liked") int liked) throws Exception;

    public List<Comment> getCommentLike (@Param("id") int id) throws Exception;
}
