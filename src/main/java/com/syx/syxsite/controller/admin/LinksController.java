package com.syx.syxsite.controller.admin;

import com.syx.syxsite.constant.Types;
import com.syx.syxsite.dto.cond.MetaCond;
import com.syx.syxsite.model.Meta;
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
 * 连接页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:41
 * @version:v1.0
 */
@Api(description = "连接页面控制器")
@Controller
public class LinksController {
    @Autowired
    private MetaService metaService;
    @Autowired
    private Commons commons;
    @Autowired
    private EasyResponse easyResponse;

    @ApiOperation(value = "跳转到连接主页面", notes = "跳转到连接主页面")
    @GetMapping("/admin/links")
    public String toLinks(Model model) {
        MetaCond metaCond = new MetaCond();
        metaCond.setType(Types.LINK.getType());
        List<Meta> links = metaService.getMetas(metaCond);
        model.addAttribute("links", links);
        model.addAttribute("commons", commons);//传递工具类，由于设计问题，基本每一次都需要传递
        return "admin/links";
    }

    @ApiOperation(value = "保存连接信息", notes = "提交相应的连接到数据库中")
    @PostMapping("/admin/links/save")
    @ResponseBody
    public EasyResponse saveLink(
            @RequestParam(name = "title", required = true)
                    String title,
            @RequestParam(name = "url", required = true)
                    String url,
            @RequestParam(name = "logo", required = false)
                    String logo,
            @RequestParam(name = "mid", required = false)
                    Integer mid,
            @RequestParam(name = "sort", required = false, defaultValue = "0")
                    int sort) {
        try {
            Meta link = new Meta();
            link.setName(title);
            link.setSlug(url);
            link.setDescription(logo);
            link.setSort(sort);
            link.setType(Types.LINK.getType());
            if (mid != null) {
                link.setMid(mid);// 当存在mid时，为修改相应的对象
                metaService.updateMeta(link);
            }else{//当不存在mid时，为增添加相应的项目
                metaService.addMeta(link);
            }
        } catch (Exception e) {
            return easyResponse.setMsg("添加失败").setCode(EasyResponse.CODE_FAIL);
        }
        return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
    }

    @ApiOperation(value = "删除连接", notes = "删除数据库中的连接")
    @PostMapping("/admin/links/delete")
    @ResponseBody
    public EasyResponse delLink(Integer mid) {

        try {
            metaService.delMetaById(mid);
        } catch (Exception e) {
            return easyResponse.setMsg("删除失败").setCode(EasyResponse.CODE_FAIL);
        }
        return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
    }
}
