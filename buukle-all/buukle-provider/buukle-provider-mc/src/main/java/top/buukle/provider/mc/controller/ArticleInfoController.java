package top.buukle.provider.mc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.buukle.provider.mc.constants.Constants;
import top.buukle.provider.mc.entity.ArticleInfo;
import top.buukle.provider.mc.service.ArticleInfoService;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description :
 */
@Controller
@RequestMapping(value = "/articleInfo",produces = {Constants.PRODUCES_CONTENT_TYPE_JSON_UTF_8})
public class ArticleInfoController {

    @Autowired
    private ArticleInfoService articleInfoService;

    @RequestMapping(value = "/getArticleInfoService/{id}")
    @ResponseBody
    public ArticleInfo getUserById(@PathVariable("id") Integer id) throws Exception {
        return  articleInfoService.getArticleInfoService(id);
    }
}
