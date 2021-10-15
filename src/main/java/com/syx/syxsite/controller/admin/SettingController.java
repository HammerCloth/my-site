package com.syx.syxsite.controller.admin;

import com.syx.syxsite.model.Options;
import com.syx.syxsite.service.OptionsService;
import com.syx.syxsite.utils.Commons;
import com.syx.syxsite.utils.EasyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.join;

/**
 * 设置控制类
 *
 * @author:syx
 * @date:2021/10/10 19:45
 * @version:v1.0
 */
@Api(description = "设置控制类")
@Controller
public class SettingController {
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private Commons commons;
    @Autowired
    private EasyResponse easyResponse;

    @ApiOperation(value = "跳转到设置页面", notes = "跳转到设置页面")
    @GetMapping("/admin/setting")
    public String toSetting(Model model) {
        List<Options> optionsList = optionsService.getOptions();
        model.addAttribute("commons", commons);
        Map<String, String> options = new HashMap<>(); // 由于页面的布局，需要将列表重新封装
        optionsList.forEach((option) -> {
            options.put(option.getName(), option.getValue());
        });
        model.addAttribute("options", options);
        return "admin/setting";
    }


    @ApiOperation(value = "设置保存", notes = "设置保存")
    @PostMapping("/admin/setting")
    @ResponseBody
    public EasyResponse saveSettings(HttpServletRequest request) {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String, String> query = new HashMap<>();
            parameterMap.forEach((key, value) -> {
                query.put(key, join(value)); // 将value字符串数组，缝合成一个字符串
            });
            optionsService.saveOptions(query);// 将数据保存到目标数据库
        } catch (Exception e) {
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("设置修改失败");
        }
        return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
    }

}
