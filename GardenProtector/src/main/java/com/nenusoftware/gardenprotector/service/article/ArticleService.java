package com.nenusoftware.gardenprotector.service.article;

import com.nenusoftware.gardenprotector.entity.article.Article;


import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/13 21:55
 */
public interface ArticleService {

    public boolean addArticle(Article article) throws Exception;

    public List<Article> listAllArticle() throws Exception;

    public boolean updateArticle(Article article) throws Exception;

    public boolean delArticle(int id) throws Exception;

    public boolean giveLiked(int id, int liked) throws Exception;
}
