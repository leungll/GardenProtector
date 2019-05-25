package com.nenusoftware.gardenprotector.controller.article;

import com.nenusoftware.gardenprotector.entity.article.Article;
import com.nenusoftware.gardenprotector.service.article.ArticleService;
import com.nenusoftware.gardenprotector.service.comment.CommentService;
//import io.swagger.annotations.Api;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:Liangll
 * @Description:
 * @Date: 20:34 2019/5/14
 */
@CrossOrigin
@RestController
@RequestMapping("/article")
//@Api(value = "ArticleController|文章控制器")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @Resource
    CommentService commentService;

    @RequestMapping("listAllArticle")
    public List<Article> listAllArticle(Model model){
//    public String listAllArticle(Model model){
        List<Article> articleList = null;
        try {
            articleList = articleService.listAllArticle();
            model.addAttribute("articleList",articleList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return articleList;
//        return "home";
    }

    @RequestMapping("toAdd")
    public String file(){
        return "/add";
    }

    @RequestMapping("addArticle")
    @ResponseBody
    public void addArticle(String userIdStr, String authorStr, String titleStr, String contentStr) throws Exception {
        Article article = new Article();
        int userId = Integer.parseInt(userIdStr);
        Date date = new Date();
        String createTime = String.valueOf(date);
        article.setUser_id(userId);
        article.setAuthor(authorStr);
        article.setTitle(titleStr);
        article.setContent(contentStr);
        article.setCreatetime(createTime);
        article.setLiked(0);
        articleService.addArticle(article);
        System.out.println("添加文章成功！");
    }

    @RequestMapping("delArticle")
    public void delArticle(String articleIdStr) throws Exception {
        int articleId = Integer.parseInt(articleIdStr);
        articleService.delArticle(articleId);
        System.out.println("删除文章成功！");
    }

    @RequestMapping("updateArticle")
    public void updateArticle(String userIdStr, String authorStr, String titleStr, String contentStr, String likedStr, String articleIdStr) throws Exception {
        Article article = new Article();
        int articleId = Integer.parseInt(articleIdStr);
        int userId = Integer.parseInt(userIdStr);
        int liked = Integer.parseInt(likedStr);
        article.setId(articleId);
        article.setUser_id(userId);
        article.setAuthor(authorStr);
        article.setTitle(titleStr);
        article.setContent(contentStr);
        Date date = new Date();
        String createTime = String.valueOf(date);
        article.setCreatetime(createTime);
        article.setLiked(liked);
        articleService.updateArticle(article);
        System.out.println("修改文章成功！");
    }

    @RequestMapping("getArticleAndComment")
    public List getArticleAndComment(String articleIdStr) throws Exception {
        int articleId = Integer.parseInt(articleIdStr);
        List articleAndCommentList = new ArrayList();
        List commentList = new ArrayList();
        articleAndCommentList.add(articleService.getArticle(articleId));
        commentList.add(commentService.listComment(articleId));
        articleAndCommentList.addAll(commentList);
        return articleAndCommentList;
    }

    @RequestMapping("getArticleLike")
    public List giveArticleLike(String articleIdStr, String articleLikedStr) throws Exception {
        int articleId = Integer.parseInt(articleIdStr);
        int articleLiked = Integer.parseInt(articleIdStr);
        articleService.giveLike(articleId,articleLiked);
        List articleList = new ArrayList();
        articleList = articleService.getArticle(articleId);
        return articleList;
    }
}
