package com.nenusoftware.gardenprotector.service.article.impl;

import com.nenusoftware.gardenprotector.entity.article.Article;
import com.nenusoftware.gardenprotector.mapper.article.ArticleMapper;
import com.nenusoftware.gardenprotector.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/13 21:56
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public boolean addArticle(Article article) throws Exception{
        return articleMapper.addArticle(article);
    }

    @Override
    public List<Article> listAllArticle() throws Exception{
        List<Article> list = Collections.emptyList();
        list = articleMapper.listAllArticle();
        return list;
    }

    @Override
    public boolean updateArticle(Article article) throws Exception{
        return articleMapper.updateArticle(article);
    }

    @Override
    public boolean delArticle(int id) throws Exception{
        return articleMapper.delArticle(id);
    }

    @Override
    public boolean giveLiked(int id, int liked) throws Exception{
        return articleMapper.giveLike(id, liked);
    }
}
