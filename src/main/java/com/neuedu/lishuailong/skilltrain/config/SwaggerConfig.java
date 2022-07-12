package com.neuedu.lishuailong.skilltrain.config;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicate;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Swagger2
 * @description: 系统API接口文档配置类
 * @create: 2022-05-10 14:06:10
 * @Version 1.0.0
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.neuedu", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
public class SwaggerConfig {
    @Bean
    public Docket swaggerDocket() {
        List<Parameter> parameters = new ArrayList<>();
        ParameterBuilder versionParam = new ParameterBuilder();
        versionParam.name("api-version").description("API版本").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameters.add(versionParam.build());

        // 指定规范，这里是SWAGGER_2
        return new Docket(DocumentationType.SWAGGER_2)
                // 设定Api文档头信息，这个信息会展示在文档UI的头部位置
                .apiInfo(swaggerApiInfo()).select()
                // 这里配合@ComponentScan一起使用，又再次细化了匹配规则(当然，我们也可以只选择@ComponentScan、paths()方法当中的一中)
                .paths(allowPaths()).build().globalOperationParameters(parameters);
    }

    /**
     * 自定义API文档基本信息实体
     *
     * @return
     */
    private ApiInfo swaggerApiInfo() {
        // 构建联系实体，在UI界面会显示
        return new ApiInfoBuilder()
                // 文档标题
                .title("技能实训项目API文档")
                // 文档描述
                .description("技能实训项目API文档")
                // 文档版本
                .version("1.0.0").build();
    }
    /**
     * path匹配规则
     *
     * @return
     */
    private Predicate<String> allowPaths() {
        return new Predicate<String>() {

            @Override
            public boolean apply(@Nullable String input) {
                return input != null && !input.startsWith("/error");
            }
        };
    }

}

