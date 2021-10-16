package com.syx.syxsite.controller.admin;

import com.syx.syxsite.constant.Types;
import com.syx.syxsite.dto.cond.MetaCond;
import com.syx.syxsite.model.Meta;
import com.syx.syxsite.service.MetaService;
import com.syx.syxsite.utils.Commons;
import com.syx.syxsite.utils.EasyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 标签管理页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:33
 * @version:v1.0
 */
@Api(description = "标签管理页面控制器")
@Controller
public class CategoryController {
    @Autowired
    private MetaService metaService;
    @Autowired
    private Commons commons;
    @Autowired
    private EasyResponse easyResponse;

    @ApiOperation(value = "跳转到标签列表页面", notes = "跳转到标签列表页面")
    @GetMapping("/admin/category")
    public String toCategory(Model model) {
        MetaCond metaCond = new MetaCond();
        metaCond.setType(Types.CATEGORY.getType());
        List<Meta> categories = metaService.getMetas(metaCond);
        metaCond.setType(Types.TAG.getType());
        List<Meta> tags = metaService.getMetas(metaCond);
        model.addAttribute("commons", commons);
        model.addAttribute("categories", categories);
        model.addAttribute("tags", tags);
        return "admin/category";
    }

    @ApiOperation(value = "保存分类", notes = "保存分类")
    @PostMapping("/admin/category/save")
    @ResponseBody
    public EasyResponse saveCategory(@RequestParam(name = "cname", required = true)
                                             String cname,
                                     @RequestParam(name = "mid", required = false)
                                             Integer mid) {

        try {
            metaService.saveMeta(Types.CATEGORY.getType(), cname, mid);
        } catch (Exception e) {
            if (e.getMessage().equals("repeat")){
                return easyResponse.setCode(EasyResponse.CODE_FAIL).setCode("类型已存在");
            }else if (e.getMessage().equals("blank")){
                return easyResponse.setCode(EasyResponse.CODE_FAIL).setCode("空白输入");
            }else{
                return easyResponse.setCode(EasyResponse.CODE_FAIL).setCode("意外失败");
            }
        }
        return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
    }

    @ApiOperation(value = "删除分类", notes = "删除分类")
    @PostMapping("/admin/category/delete")
    @ResponseBody
    public EasyResponse delCategory(@RequestParam(name = "mid",required = true) Integer mid){
        try {
            metaService.delMetaById(mid);
        } catch (Exception e) {
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setCode("意外失败");
        }
        return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
    }
}
