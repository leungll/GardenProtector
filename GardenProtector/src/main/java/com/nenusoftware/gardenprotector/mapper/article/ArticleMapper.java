package com.nenusoftware.gardenprotector.mapper.article;
import com.nenusoftware.gardenprotector.entity.article.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/13 21:43
 */
@Mapper
@Repository
public interface ArticleMapper {

    public boolean addArticle(@Param("article")Article article) throws Exception;

    public List<Article> listAllArticle() throws Exception;

    public boolean updateArticle(@Param("article")Article article) throws Exception;

    public boolean delArticle(@Param("id") int id) throws Exception;

    public boolean giveLike(@Param("id") int id, @Param("liked") int liked) throws Exception;

    public List<Article> getArticle(@Param("id") int id) throws Exception;

    public List<Article> selectArticleByTypes(@Param("types") String types) throws Exception;

    public List<Article> selectArticle(@Param("keyword") String keyword) throws Exception;

}
