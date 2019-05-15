package com.nenusoftware.gardenprotector.article;

import com.nenusoftware.gardenprotector.entity.article.Article;
import com.nenusoftware.gardenprotector.service.article.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


/**
 * @author : kongyy
 * @time : 2019/5/13 23:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    public void testAddArticle() throws Exception{
        Article article = new Article();
        Date date = new Date();
        String createtime = String.valueOf(date);
        article.setAuthor("孔一言");
        article.setContent("孔一言小仙女");
        article.setCreatetime(createtime);
        article.setLiked(0);
        article.setTitle("aaa");
        article.setUser_id(3);
        articleService.addArticle(article);
    }

    @Test
    public void testUpdateArticle() throws Exception{
        Article article = new Article();
        article.setId(2);
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
        int id = 3;
        articleService.delArticle(id);
    }
}
