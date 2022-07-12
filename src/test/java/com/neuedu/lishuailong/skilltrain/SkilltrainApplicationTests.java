package com.neuedu.lishuailong.skilltrain;

import com.neuedu.lishuailong.skilltrain.model.Member;
import com.neuedu.lishuailong.skilltrain.service.MemberService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SkilltrainApplicationTests {

    @Autowired
    private MemberService service;

    @Test
    void contextLoads() {
        List<Member> list = new ArrayList<Member>();
        for(int i=0;i<100;i++){
            Member m = new Member();
            m.setId((long)10000+i);
            m.setName("aaa"+i);
            m.setAddress("aaa"+i);
            m.setPhone("1300000"+i);
            m.setSex(1);
            m.setCreateUser("dawn");
            m.setCreateTime(new Date());
            m.setUpdateUser("dawnlsl");
            m.setUpdateTime(new Date());
            list.add(m);
        }
        service.saveBatch(list);
    }
    @Ignore
    void update(){

    }
}
