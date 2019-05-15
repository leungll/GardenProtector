package com.nenusoftware.gardenprotector.controller.reply;

import com.nenusoftware.gardenprotector.entity.comment.Comment;
import com.nenusoftware.gardenprotector.entity.reply.Reply;
import com.nenusoftware.gardenprotector.service.comment.CommentService;
import com.nenusoftware.gardenprotector.service.reply.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:Liangll
 * @Description:
 * @Date: 13:37 2019/5/15
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    ReplyService replyService;

    @RequestMapping("listAllReply")
//    public List<Article> listAllArticle(Model model){
    public String listAllReply(Model model, int replyCommentId){
        List<Reply> list = null;
        try {
            list = replyService.listReply(replyCommentId);
            model.addAttribute("ReplyList",list);
        }catch (Exception e){
            e.printStackTrace();
        }
//        return list;
        return "home";
    }

    @RequestMapping("toAdd")
    public String file(){
        return "/add";
    }

    @RequestMapping("addReply")
    @ResponseBody
    public String addReply(Reply reply) throws Exception {
        replyService.addReply(reply);
        return "添加成功";
    }

    @RequestMapping("delReply/{id}")
    public String delReply(@PathVariable("id") int id) throws Exception {
        replyService.delReply(id);
        return "删除成功";
    }
}
