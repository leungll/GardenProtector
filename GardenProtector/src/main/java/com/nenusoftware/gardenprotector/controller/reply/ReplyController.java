package com.nenusoftware.gardenprotector.controller.reply;

import com.nenusoftware.gardenprotector.entity.reply.Reply;
import com.nenusoftware.gardenprotector.service.reply.ReplyService;
import com.nenusoftware.gardenprotector.service.user.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Author:Liangll
 * @Description:
 * @Date: 13:37 2019/5/15
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    ReplyService replyService;

    @Resource
    UserService userService;

    @RequestMapping("listAllReply")
    @ResponseBody
    public List<Reply> listAllReply(String replyCommentIdStr){
        int replyCommentId = Integer.parseInt(replyCommentIdStr);
        List<Reply> replyList = null;
        try {
            replyList = replyService.listReply(replyCommentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return replyList;
    }

    @RequestMapping("addReply")
    @ResponseBody
    public List<Reply> addReply(String replyCommentIdStr, String contentStr, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        int replyCommentId = Integer.parseInt(replyCommentIdStr);
        Reply reply = new Reply();
        reply.setUser_id(userId);
        reply.setAuthor(username);
        reply.setReplycomment_id(replyCommentId);
        reply.setContent(contentStr);
        reply.setLiked(0);
        Date date = new Date();
        String createTime = String.valueOf(date);
        reply.setCreatetime(createTime);
        replyService.addReply(reply);
        System.out.println("添加回复成功!");

        List<Reply> replyList = null;
        replyList = replyService.listReply(replyCommentId);
        return replyList;
    }

    @RequestMapping("delReply")
    @ResponseBody
    public List<Reply> delReply(String idStr, String replyCommentIdStr, String userIdFrontStr, HttpServletRequest request) throws Exception {
        int replyCommentId = Integer.parseInt(replyCommentIdStr);
        int replyId = Integer.parseInt(idStr);
        int userIdFront = Integer.parseInt(userIdFrontStr);
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        if(userId == userIdFront){
            replyService.delReply(replyId);
            System.out.println("删除回复成功！");
        }else{
            System.out.println("您不是这篇评论的作者，无权删除！");
        }
        List<Reply> replyList = null;
        replyList = replyService.listReply(replyCommentId);
        return replyList;
    }
}
