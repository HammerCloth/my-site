package com.syx.syxsite.controller.admin;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.constant.Types;
import com.syx.syxsite.model.AttAch;
import com.syx.syxsite.model.User;
import com.syx.syxsite.service.AttAchService;
import com.syx.syxsite.service.qiniu.QiniuCloudService;
import com.syx.syxsite.utils.Commons;
import com.syx.syxsite.utils.EasyResponse;
import com.syx.syxsite.utils.TaleUtils;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 附件管理页面控制类
 *
 * @author:syx
 * @date:2021/10/10 19:37
 * @version:v1.0
 */
@Api(description = "附件管理页面控制类")
@Controller
public class AttachController {
    @Autowired
    private Commons commons;
    @Autowired
    private AttAchService attAchService;
    @Autowired
    private EasyResponse easyResponse;
    @Autowired
    private QiniuCloudService qiniuCloudService;

    @ApiOperation(value = "跳转到附件列表页面", notes = "跳转到附件列表页面")
    @GetMapping("/admin/attach")
    public String toAttach(@RequestParam(name = "page", required = false, defaultValue = "1")
                                   int page,
                           @RequestParam(name = "limit", required = false, defaultValue = "12")
                                   int limit,
                           Model model) {
        PageInfo<AttAch> atts = attAchService.getAtts(page, limit);
        model.addAttribute("commons", commons);
        model.addAttribute("attachs", atts);
        return "admin/attach";
    }

    @ApiOperation(value = "上传文件到七牛云，并保存连接到数据库", notes = "上传文件到七牛云，并保存连接到数据库")
    @PostMapping("/admin/attach/upload")
    @ResponseBody
    public EasyResponse uploadFile(@RequestParam(name = "file", required = true) MultipartFile[] files,
                                   HttpServletRequest request,
                                   HttpServletResponse response,
                                   HttpSession session) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");

            for (MultipartFile file : files) {
                //获取文件存储名
                String fileName = TaleUtils.getFileKey(file.getOriginalFilename()).replaceFirst("/", "");
                String upload = qiniuCloudService.upload(file, fileName);
                AttAch attAch = new AttAch();
                User login_user = (User) session.getAttribute("login_user");
                attAch.setAuthorId(login_user.getUid());
                attAch.setFtype(TaleUtils.isImage(file.getInputStream()) ? Types.IMAGE.getType() : Types.FILE.getType());
                attAch.setFname(fileName);
                String baseUrl = qiniuCloudService.QINIU_UPLOAD_SITE.endsWith("/") ? qiniuCloudService.QINIU_UPLOAD_SITE : qiniuCloudService.QINIU_UPLOAD_SITE + "/";
                attAch.setFkey(baseUrl + fileName);
                attAchService.addAttAch(attAch);
            }

            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        } catch (IOException e) {
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("上传失败");
        }
    }

    @ApiOperation(value = "删除连接", notes = "删除连接")
    @PostMapping("/admin/attach/delete")
    @ResponseBody
    public EasyResponse delFileInfo(@RequestParam(name = "id", required = true) Integer id){
        try {
            AttAch attAch = attAchService.getAttAchById(id);
            if (null == attAch){
                return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("文件不存在");
            }
            attAchService.deleteAttAch(id);
            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("文件删除出错");
        }
    }
}
