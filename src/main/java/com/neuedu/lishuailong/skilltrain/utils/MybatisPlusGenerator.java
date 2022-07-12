package com.neuedu.lishuailong.skilltrain.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;


/**
 * 使用配置注意：
 * 1.生成文件输出位置：（ctrl+L：快速定位行数）** P.S.：第38行：更改作者**
 * 	》代码文件（java）： 第37行，修改成本地工程的绝对路径
 *         》 mapper文件（xml）：第91行，修改成本地工程的绝对路径
 * 2.配置生成内容：
 *         》可生成controller控制层、service业务层、dao(mapper)DAO层、bean(entity)实体类：第62-67行：各个层文件生成配置
 * 3.指定生成表：
 *         》配置用于生成的表：第116行，多个表用 逗号 分割
 * 4.执行
 *         》文件上右键->run as -> Java Application
 * */
@Slf4j
public class MybatisPlusGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //JavaCode
        String javaCodePath = "D:\\ideawork\\skilltrain\\src\\main\\java";
        //DaoXML
        String xmlMapperPath = "D:\\ideawork\\skilltrain\\src\\main\\resources\\mapper\\";
        File file1 = new File(javaCodePath);
        boolean flag1 = false;
        if(!file1.exists()) {
            flag1 = file1.mkdirs();
        }
        boolean flag2 = false;
        File file2 = new File(xmlMapperPath);
        if(!file2.exists()){
            flag2 = file2.mkdirs();
        }
        System.out.println("codeGen:"+flag1+",xmlGen:"+flag2);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //代码生成根路径：修改成本地绝对路径即可
        gc.setOutputDir(javaCodePath);
        gc.setAuthor("lishuailong");
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        gc.setFileOverride(true);


        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");

        //主键策略
        gc.setIdType(IdType.ID_WORKER);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/skilldb?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("bilibili1314");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.neuedu.lishuailong.skilltrain"); //工程父目录包
        pc.setController("controller"); //控制层，生成包名
        pc.setService("service"); //业务层，生成包名
        pc.setServiceImpl("service.impl"); //业务层实现类，生成包名
        pc.setMapper("mapper"); //DAO层接口：生成包名
        pc.setEntity("model"); //实体类：生成包名
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                //mapper的xml文件生成路径：修改成本地绝对路径，注意最后的 // 用来分割文件夹和文件名)
                return xmlMapperPath + tableInfo.getEntityName() + "Mapper"
                        + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 命名规则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表（数据库中ctrl+c，ctrl+v）
        strategy.setInclude("user");
        // 实体是否使用Lombok插件
        strategy.setEntityLombokModel(true);
        // 控制层是否使用Rest风格
        strategy.setRestControllerStyle(true);
        //生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        //继承类
//        strategy.setSuperControllerClass("com.neuedu.se.common.beans.BaseController");
        //url驼峰
        strategy.setControllerMappingHyphenStyle(true);

//		strategy.setSuperEntityColumns("id");

        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}