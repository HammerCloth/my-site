package com.syx.syxsite.controller.admin;

import com.syx.syxsite.model.Options;
import com.syx.syxsite.service.OptionsService;
import com.syx.syxsite.utils.Commons;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value = "跳转到设置页面", notes = "跳转到设置页面")
    @GetMapping("/admin/setting")
    public String toSetting(Model model) {
        List<Options> optionsList = optionsService.getOptions();
        model.addAttribute("commons",commons);
        Map<String, String> options = new HashMap<>();
        optionsList.forEach((option) -> {
            options.put(option.getName(), option.getValue());
        });
        model.addAttribute("options",options);
        return "admin/setting";
    }
}
