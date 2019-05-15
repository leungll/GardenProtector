package com.nenusoftware.gardenprotector.controller.comment;

import com.nenusoftware.gardenprotector.entity.comment.Comment;
import com.nenusoftware.gardenprotector.service.comment.CommentService;
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
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentService commentService;

    @RequestMapping("listAllArticle")
//    public List<Article> listAllArticle(Model model){
    public String listAllArticle(Model model,int id){
        List<Comment> list = null;
        try {
            list = commentService.listComment(id);
            model.addAttribute("articleList",list);
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

    @RequestMapping("addComment")
    @ResponseBody
    public String addComment(Comment comment) throws Exception {
        commentService.addComment(comment);
        return "添加成功";
    }

    @RequestMapping("delComment/{id}")
    public String delComment(@PathVariable("id") int id) throws Exception {
        commentService.delComment(id);
        return "删除成功";
    }

    @RequestMapping("updateComment")
    public String updateComment(Comment comment, int id) throws Exception {
        comment.setId(id);
        commentService.updateComment(comment);
        return "修改成功";
    }
}
