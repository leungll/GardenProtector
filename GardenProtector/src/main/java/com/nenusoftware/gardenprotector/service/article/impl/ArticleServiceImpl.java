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
    public boolean giveLike(int id, int liked) throws Exception{
        return articleMapper.giveLike(id, liked);
    }

    @Override
    public List<Article> getArticle(int id) throws Exception{
        List<Article> listArticle = Collections.emptyList();
        listArticle = articleMapper.getArticle(id);
        return listArticle;
    }

    @Override
    public List<Article> selectArticleByTypes(String types) throws Exception{
        List<Article> list = Collections.emptyList();
        list = articleMapper.selectArticleByTypes(types);
        return list;
    }

    @Override
    public List<Article> selectArticle(String keywordstr) throws Exception{
        List<Article> list = Collections.emptyList();
        String keyword = "%"+keywordstr+"%";
        list = articleMapper.selectArticle(keyword);
        return list;
    }
}
