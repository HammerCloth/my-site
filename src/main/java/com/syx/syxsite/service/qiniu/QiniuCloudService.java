package com.syx.syxsite.service.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author:syx
 * @date:2021/10/15 19:35
 * @version:v1.0
 */
@Component
public class QiniuCloudService {

    @Value("${qiniu.accesskey}")
    private String ACCESS_KEY;
    @Value("${qiniu.serectkey}")
    private String SECRET_KEY;
    /**
     * 仓库
     */
    @Value("${qiniu.bucket}")
    private String BUCKET;
    /**
     * 七牛云外网访问地址
     */
    @Value("${qiniu.cdn.url}")
    public String QINIU_UPLOAD_SITE;

    public String upload(MultipartFile file, String fileName) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Region.region0()); // 和七牛云的区域有关需要调整
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET);
        try {
            Response response = null;
            response = uploadManager.put(file.getInputStream(), fileName, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
        } catch (IOException e) {
            System.err.println("IO出现问题");
        }
        return "失败";
    }

}
