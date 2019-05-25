package com.nenusoftware.gardenprotector.controller.reply;

import com.nenusoftware.gardenprotector.entity.reply.Reply;
import com.nenusoftware.gardenprotector.service.reply.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author:Liangll
 * @Description:
 * @Date: 13:37 2019/5/15
 */
@CrossOrigin
@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    ReplyService replyService;

    @RequestMapping("listAllReply")
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

    @RequestMapping("toAdd")
    public String file(){
        return "/add";
    }

    @RequestMapping("addReply")
    @ResponseBody
    public void addReply(String userIdStr, String authorStr, String replyCommentIdStr, String contentStr) throws Exception {
        int userId = Integer.parseInt(userIdStr);
        int replyCommentId = Integer.parseInt(replyCommentIdStr);
        Reply reply = new Reply();
        reply.setUser_id(userId);
        reply.setAuthor(authorStr);
        reply.setReplycomment_id(replyCommentId);
        reply.setContent(contentStr);
        reply.setLiked(0);
        Date date = new Date();
        String createTime = String.valueOf(date);
        reply.setCreatetime(createTime);
        replyService.addReply(reply);
        System.out.println("添加回复成功!");
    }

    @RequestMapping("delReply")
    public void delReply(String replyIdStr) throws Exception {
        int replyId = Integer.parseInt(replyIdStr);
        replyService.delReply(replyId);
        System.out.println("删除回复成功！");
    }
}
