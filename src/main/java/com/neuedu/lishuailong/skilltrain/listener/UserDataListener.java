package com.neuedu.lishuailong.skilltrain.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.neuedu.lishuailong.skilltrain.model.Member;
import com.neuedu.lishuailong.skilltrain.model.User;
import com.neuedu.lishuailong.skilltrain.service.MemberService;
import com.neuedu.lishuailong.skilltrain.service.UserService;


import java.util.ArrayList;
import java.util.List;

public class UserDataListener extends AnalysisEventListener<User> {

    /**
     * 每隔3000条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 3000;

    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private UserService userService;

    /**
     * 这个集合用于接收 读取Excel文件得到的数据
     */
    List<User> list = new ArrayList<>();


    public UserDataListener() {
    }
    /**
     * 不要使用自动装配
     * 在测试类中将dao当参数传进来
     */
    public UserDataListener(UserService userService) {
        this.userService = userService;
    }


    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        list.add(user);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            //保存
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }

    //保存方法，业务方法
    private void saveData(){
        //保存转换的数据
        userService.saveBatch(list);
    }

}
