package com.nenusoftware.gardenprotector.controller.article;

import com.nenusoftware.gardenprotector.entity.article.Article;
import com.nenusoftware.gardenprotector.service.article.ArticleService;
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
 * @Date: 20:34 2019/5/14
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @RequestMapping("listAllArticle")
//    public List<Article> listAllArticle(Model model){
    public String listAllArticle(Model model){
        List<Article> list = null;
        try {
            list = articleService.listAllArticle();
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

    @RequestMapping("addArticle")
    @ResponseBody
    public String addArticle(Article article) throws Exception {
        articleService.addArticle(article);
        return "添加成功";
    }

    @RequestMapping("delArticle/{id}")
    public String delArticle(@PathVariable("id") int id) throws Exception {
        articleService.delArticle(id);
        return "删除成功";
    }

    @RequestMapping("updateArticle")
    public String updateArticle(Article article, int id) throws Exception {
        article.setId(id);
        articleService.updateArticle(article);
        return "修改成功";
    }
}
