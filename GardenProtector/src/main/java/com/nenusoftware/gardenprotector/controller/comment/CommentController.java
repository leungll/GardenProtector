package com.nenusoftware.gardenprotector.controller.comment;

import com.nenusoftware.gardenprotector.entity.comment.Comment;
import com.nenusoftware.gardenprotector.service.comment.CommentService;
import com.nenusoftware.gardenprotector.service.user.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:Liangll
 * @Description:
 * @Date: 13:37 2019/5/15
 */
@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentService commentService;

    @Resource
    UserService userService;

    @RequestMapping("listAllComment")
    public List<Comment> listAllComment(String articleIdStr){
        int articleId = Integer.parseInt(articleIdStr);
        List<Comment> commentList = null;
        try {
            commentList = commentService.listComment(articleId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return commentList;
    }

    @RequestMapping("addComment")
    @ResponseBody
    public void addComment(String articleIdStr, String authorStr, String contentStr, HttpServletRequest request) throws Exception {
        Comment comment = new Comment();
        int articleId = Integer.parseInt(articleIdStr);
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        comment.setArticle_id(articleId);
        comment.setUser_id(userId);
        comment.setAuthor(authorStr);
        comment.setContent(contentStr);
        comment.setLiked(0);
        Date date = new Date();
        String createTime = String.valueOf(date);
        comment.setCreatetime(createTime);
        commentService.addComment(comment);
        System.out.println("添加评论成功！");
    }

    @RequestMapping("delComment")
    public void delComment(String commentIdStr, HttpServletRequest request, String userIdFrontStr) throws Exception {
        int userIdFront = Integer.parseInt(userIdFrontStr);
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        if(userId == userIdFront){
            int commentId = Integer.parseInt(commentIdStr);
            commentService.delComment(commentId);
            System.out.println("删除评论成功！");
        }else{
            System.out.println("您不是这篇评论的作者，无权删除！");
        }
    }

    @RequestMapping("updateComment")
    public void updateComment(String articleIdStr, String userIdStr, String commentIdStr, String authorStr, String contentStr, String likedStr) throws Exception {
        int commentId = Integer.parseInt(commentIdStr);
        int articleId = Integer.parseInt(articleIdStr);
        int userId = Integer.parseInt(userIdStr);
        int liked = Integer.parseInt(likedStr);
        Date date = new Date();
        String createTime = String.valueOf(date);
        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setArticle_id(articleId);
        comment.setUser_id(userId);
        comment.setAuthor(authorStr);
        comment.setContent(contentStr);
        comment.setLiked(liked);
        comment.setCreatetime(createTime);
        commentService.updateComment(comment);
        System.out.println("修改评论成功！");
    }


    @RequestMapping("/getCommentLike")
    @ResponseBody
    public List giveCommentLike(String commentIdStr, String commentLikedStr) throws Exception {
        int commentId = Integer.parseInt(commentIdStr);
        int commentLiked = Integer.parseInt(commentLikedStr);
        commentService.giveLike(commentId,commentLiked);
        List commentList = new ArrayList();
        commentList = commentService.getCommentLike(commentId);
        return commentList;
    }
}
