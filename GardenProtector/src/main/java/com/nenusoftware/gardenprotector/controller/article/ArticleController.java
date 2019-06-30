package com.nenusoftware.gardenprotector.controller.article;

import com.nenusoftware.gardenprotector.entity.article.Article;
import com.nenusoftware.gardenprotector.service.article.ArticleService;
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
 * @Date: 20:34 2019/5/14
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/article")
//@Api(value = "ArticleController|文章控制器")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @Resource
    CommentService commentService;

    @Resource
    UserService userService;

    @RequestMapping("listAllArticle")
    @ResponseBody
    public List<Article> listAllArticle(){
        List<Article> articleList = null;
        try {
            articleList = articleService.listAllArticle();
        }catch (Exception e){
            e.printStackTrace();
        }
        return articleList;
    }

    @RequestMapping("addArticle")
    @ResponseBody
    public void addArticle(HttpServletRequest request, String titleStr, String contentStr, String typesStr) throws Exception {

        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();

        Article article = new Article();

        Date date = new Date();
        String createTime = String.valueOf(date);
        article.setUser_id(userId);
        article.setAuthor(username);
        article.setTitle(titleStr);
        article.setContent(contentStr);
        article.setTypes(typesStr);
        article.setCreatetime(createTime);
        article.setLiked(0);
        articleService.addArticle(article);
        System.out.println("添加文章成功！");

    }

    @RequestMapping("delArticle")
    @ResponseBody
    public void delArticle(String articleIdStr) throws Exception {
        int articleId = Integer.parseInt(articleIdStr);
        articleService.delArticle(articleId);
        System.out.println("删除文章成功！");
    }

    @RequestMapping("updateArticle")
    @ResponseBody
    public void updateArticle(String userIdStr, String authorStr, String titleStr, String contentStr, String likedStr, String articleIdStr, String typesStr) throws Exception {
        Article article = new Article();
        int articleId = Integer.parseInt(articleIdStr);
        int userId = Integer.parseInt(userIdStr);
        int liked = Integer.parseInt(likedStr);
        article.setId(articleId);
        article.setUser_id(userId);
        article.setAuthor(authorStr);
        article.setTitle(titleStr);
        article.setContent(contentStr);
        article.setTypes(typesStr);
        Date date = new Date();
        String createTime = String.valueOf(date);
        article.setCreatetime(createTime);
        article.setLiked(liked);
        articleService.updateArticle(article);
        System.out.println("修改文章成功！");
    }

    @RequestMapping("getArticleAndComment")
    @ResponseBody
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
    @ResponseBody
    public List giveArticleLike(String articleIdStr, String articleLikedStr) throws Exception {
        int articleId = Integer.parseInt(articleIdStr);
        int articleLiked = Integer.parseInt(articleLikedStr);
        articleService.giveLike(articleId,articleLiked);
        List articleList = new ArrayList();
        articleList = articleService.getArticle(articleId);
        return articleList;
    }

    @RequestMapping("queryArticleTitle")
    @ResponseBody
    public List queryArticleTitle(String keyStr) throws Exception {
        List<Article> articleList = new ArrayList<>();
        articleList = articleService.selectArticle(keyStr);
        return articleList;
    }

    @RequestMapping("listArticleByTypes")
    @ResponseBody
    public List listArticleByTypes(String types) throws Exception{
        List<Article> typeList = new ArrayList<>();
        typeList = articleService.selectArticleByTypes(types);
        return typeList;
    }

}
