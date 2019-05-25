package com.nenusoftware.gardenprotector.comment;

import com.nenusoftware.gardenprotector.entity.comment.Comment;
import com.nenusoftware.gardenprotector.service.comment.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/14 14:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    public void testAddComment() throws Exception{
        Date date = new Date();
        String createtime = String.valueOf(date);
        Comment comment = new Comment();
        comment.setArticle_id(1);
        comment.setUser_id(3);
        comment.setAuthor("kongyiyan");
        comment.setContent("真棒");
        comment.setLiked(0);
        comment.setCreatetime(createtime);
        commentService.addComment(comment);
    }

    @Test
    public void testlistComment() throws Exception{
        int article_id = 5;
        System.out.println(commentService.listComment(article_id));
    }

//    @Test
//    public void testUpdateComment() throws Exception{
//        int id = 2;
//        Comment comment = new Comment();
//        comment.setId(id);
//        comment.setContent("ayouyouyou");
//        commentService.updateComment(comment);
//    }

    @Test
    public void testGetLike() throws Exception{
        int id = 1;
        System.out.println(commentService.getCommentLike(id));
    }

    @Test
    public void testGiveCommentLike() throws Exception{
        int commentId = 1;
        int commentLiked = 20;
        System.out.println(commentService.giveLike(commentId,commentLiked));
        List commentList = new ArrayList();
        commentList = commentService.getCommentLike(commentId);
        System.out.println(commentList);
    }
}
