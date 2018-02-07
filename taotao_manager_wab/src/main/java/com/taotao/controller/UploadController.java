package com.taotao.controller;

import com.taotao.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
//文件上传
@Controller
public class UploadController {
    @Value("${TAOTAO_IMAGE_URL}")
    private String TAOTAO_IMAGE_URL;
    //url:/pic/upload
    //参数类型:MultipartFile参数名称:uploadFile
    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile uploadFile){
        //上传成功或失败都需要返回 所以这里使用map来存
        //1.加入jar包fileupload
        //2.配置文件解析器springmvc.xml
        //3.调用fastDFS提供的客户端  使用工具类
        try {
            FastDFSClient client = new FastDFSClient("classpath:resource/fastdfs.conf");
            String filename = uploadFile.getOriginalFilename();//获取图片名字
            String extName = filename.substring(filename.lastIndexOf(".") + 1);//获取扩展名,不带点
            //第一个参数是字节数组,第二个参数是图片扩展名,不带点
            //返回图片路径group1/M00/00/00/wKgZhVp1WIOAWSUAAAuLAwKfnWg604.jpg格式
            String imagePath = client.uploadFile(uploadFile.getBytes(), extName);
            //访问的时候需要完整的url路径 所以需要拼接
            //String complPath = "http://192.168.25.133/"+imagePath;
            //路径改成灵活方式 属性注入 创建配置文件resource.properties  在springmvc.xml开启加载属性文件
           // <context:property-placeholder location="classpath:resource/resource.properties" />
            String complPath = TAOTAO_IMAGE_URL+imagePath;

           //返回Json给页面 成功返回 error =0,url:=complPath 失败error=1 massage:错误信息
            Map<String,Object> map = new HashMap<>();
            map.put("error",0);
            map.put("url",complPath);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            //失败时返回
            Map<String,Object> map = new HashMap<>();
            map.put("error",1);
            map.put("massage","上传失败");
            return map;
        }
    }
}
