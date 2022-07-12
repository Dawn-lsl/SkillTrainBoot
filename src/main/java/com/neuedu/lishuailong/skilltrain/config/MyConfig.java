package com.neuedu.lishuailong.skilltrain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {

    //静态属性值
    private static String localPath;
    //静态get方法
    public static String getLocalPath() {
        return localPath;
    }
    //Set方法不能使用静态
    @Value("${sk.storage.localPath}")
    public void setLocalPath(String localPath) {
        MyConfig.localPath = localPath;
    }


}
