package com.syx.syxsite.controller.admin;

import com.syx.syxsite.constant.Types;
import com.syx.syxsite.dto.cond.MetaCond;
import com.syx.syxsite.model.Content;
import com.syx.syxsite.model.Meta;
import com.syx.syxsite.service.ContentService;
import com.syx.syxsite.service.MetaService;
import com.syx.syxsite.utils.Commons;
import com.syx.syxsite.utils.EasyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 文章发布页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:12
 * @version:v1.0
 */
@Api(description = "文章发布页面控制器")
@Controller
public class ArticleEditController {
    @Autowired
    private MetaService metaService;
    @Autowired
    private Commons commons;
    @Autowired
    private ContentService contentService;
    @Autowired
    private EasyResponse easyResponse;

    @ApiOperation(value = "跳转到文章发布页面", notes = "跳转到文章发布页面")
    @GetMapping("/admin/article/publish")
    public String toArticleEdit(Model model) {
        MetaCond metaCond = new MetaCond();
        metaCond.setType(Types.CATEGORY.getType());
        List<Meta> categories = metaService.getMetas(metaCond);
        model.addAttribute("categories", categories);
        model.addAttribute("commons", commons);
        return "admin/article_edit";
    }

    @ApiOperation(value = "文章修改", notes = "修改文章")
    @PostMapping("/admin/article/modify")
    @ResponseBody
    public EasyResponse modify() {
        return null;
        // todo 修改文章内容
    }

    @ApiOperation(value = "文章保存", notes = "保存文章")
    @PostMapping("/admin/article/publish")
    @ResponseBody
    public EasyResponse publish(@RequestParam(name = "title", required = true)
                                        String title,
                                @RequestParam(name = "titlePic", required = false)
                                        String titlePic,
                                @RequestParam(name = "slug", required = false)
                                        String slug,
                                @RequestParam(name = "content", required = true)
                                        String content,
                                @RequestParam(name = "type", required = true)
                                        String type,
                                @RequestParam(name = "status", required = true)
                                        String status,
                                @RequestParam(name = "tags", required = false)
                                        String tags,
                                @RequestParam(name = "categories", required = false, defaultValue = "默认分类")
                                        String categories,
                                @RequestParam(name = "allowComment", required = true)
                                        Boolean allowComment) {

        try {
            Content contentObject = new Content();
            contentObject.setTitle(title);
            contentObject.setTitlePic(titlePic);
            contentObject.setTitle(slug);
            contentObject.setContent(content);
            contentObject.setType(type);
            contentObject.setStatus(status);
            contentObject.setTags(type.equals(Types.ARTICLE.getType()) ? tags : null);
            contentObject.setCategories(type.equals(Types.ARTICLE.getType()) ? categories : null);
            contentObject.setAllowComment(allowComment?1:0);
            contentService.addArticle(contentObject);
            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        } catch (Exception e) {
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("保存失败");
        }

    }
}
