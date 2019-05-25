package com.nenusoftware.gardenprotector.article;

import com.nenusoftware.gardenprotector.entity.article.Article;
import com.nenusoftware.gardenprotector.service.article.ArticleService;
import com.nenusoftware.gardenprotector.service.comment.CommentService;
import com.nenusoftware.gardenprotector.service.reply.ReplyService;
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
 * @time : 2019/5/13 23:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @Autowired
    ReplyService replyService;

    @Test
    public void testAddArticle() throws Exception{
        Article article = new Article();
        Date date = new Date();
        String createTime = String.valueOf(date);
        article.setAuthor("孔一言");
        article.setContent("孔一言小仙女");
        article.setCreatetime(createTime);
        article.setLiked(0);
        article.setTitle("aaa");
        article.setUser_id(3);
        articleService.addArticle(article);
    }

    @Test
    public void testUpdateArticle() throws Exception{
        Article article = new Article();
        article.setId(5);
        article.setTitle("heheda");
        article.setContent("哦吼");
        articleService.updateArticle(article);
    }

    @Test
    public void testListAll() throws Exception{
        System.out.println(articleService.listAllArticle());
    }

    @Test
    public void testDel() throws Exception{
        int id = 10;
        System.out.println(articleService.delArticle(id));
    }

    @Test
    public void testGetArticleAndComment() throws Exception{
        int articleId = 11;
        List articleList = new ArrayList();
        List commentList = new ArrayList();
        articleList.add(articleService.getArticle(articleId));
        commentList.add(commentService.listComment(articleId));
        articleList.addAll(commentList);
        System.out.println(articleList);
    }

    @Test
    public void testGiveArticleLike() throws Exception{
        int articleId = 5;
        int liked = 20;
        System.out.println(articleService.giveLike(articleId,liked));
        List articleList = new ArrayList();
        articleList = articleService.getArticle(articleId);
        System.out.println(articleList);
    }

    @Test
    public void testSelectArticleByTypes() throws Exception{
        String types = "植被";
        System.out.println(articleService.selectArticleByTypes(types));
    }

    @Test
    public void testSelectArticle() throws Exception{
        String keywordstr = "h";
        System.out.println(articleService.selectArticle(keywordstr));
    }
}
