package com.neuedu.lishuailong.skilltrain.utils;

import com.neuedu.lishuailong.skilltrain.config.MyConfig;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDate;

public class FileOperateUtils {
//    private final MyConfig myConfig;
//    public FileOperateUtils(MyConfig config) {
//        this.myConfig = config;
//    }
    //获取上传到本地的默认路径，读取配置文件
//    @Value("${sk.storage.localPath}")
//    private static final String LOCAL_PATH ="";

    public static String checkDirectory(MultipartFile multipartFile) {
        //日期
        LocalDate nowLocalDate = LocalDate.now();
        int year = nowLocalDate.getYear();
        int month = nowLocalDate.getMonthValue();
        //上传文件名称
        String name = multipartFile.getOriginalFilename();
        //文件类型
        String ext = FilenameUtils.getExtension(name);
        if (StringUtils.isBlank(ext)) {
            ext = "file";
        }
        //拼接文件路径，创建接收的路径 "D:/upload/doc/2022/06/"
        StringBuilder pathStr = new StringBuilder();
        pathStr.append(MyConfig.getLocalPath()).append(File.separatorChar).append(ext).append(File.separatorChar).append(year)
                .append(File.separatorChar).append(month).append(File.separatorChar);
        File dir = new File(pathStr.toString());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return pathStr.toString();
    }

    public static String decode(String filePathEncoded) {
        try {
            return URLDecoder.decode(filePathEncoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return filePathEncoded;
        }
    }

    public static String encode(String filePathEncoded) {
        try {
            return URLEncoder.encode(filePathEncoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return filePathEncoded;
        }
    }
}
