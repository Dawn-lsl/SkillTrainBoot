package com.neuedu.lishuailong.skilltrain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neuedu.lishuailong.skilltrain.mapper")
public class SkilltrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkilltrainApplication.class, args);
    }

}
